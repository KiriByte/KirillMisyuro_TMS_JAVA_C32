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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var login = req.getParameter("login");
        var password = req.getParameter("password");
        var confirmPassword = req.getParameter("confirmPassword");

        if (login == null || password == null || confirmPassword == null ||
                login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Login and password are required");
            return;
        }
        if (userRepository.existsByLogin(login)) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "User already exists");
            return;
        }
        if (!password.equals(confirmPassword)) {
            resp.sendError(HttpServletResponse.SC_CONFLICT, "Passwords do not match");
            return;
        }

        var hashPassword = PasswordHash.GetHash(password);
        var user = new User(login, hashPassword);
        userRepository.saveUser(user);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}
