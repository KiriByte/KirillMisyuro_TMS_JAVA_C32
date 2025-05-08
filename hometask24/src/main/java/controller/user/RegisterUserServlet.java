package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import utils.PasswordHash;

import java.io.IOException;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var login = request.getParameter("login");
        var password = request.getParameter("password");
        var confirmPassword = request.getParameter("confirmPassword");

        if (login == null || password == null || confirmPassword == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Login and password are required");
            return;
        }
        if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Login and password are required");
            return;
        }
        if (userRepository.existsByLogin(login)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            response.getWriter().println("User already exists");
            return;
        }
        if (!password.equals(confirmPassword)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Passwords do not match");
            return;
        }

        var hashPassword = PasswordHash.GetHash(password);
        var user = new User(login, hashPassword);
        userRepository.save(user);
        response.sendRedirect(request.getContextPath() + "/auth");
    }

}
