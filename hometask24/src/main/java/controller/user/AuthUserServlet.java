package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import utils.PasswordHash;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/auth")
public class AuthUserServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var login = req.getParameter("login");
        var password = req.getParameter("password");
        if (login == null || password == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (login.isEmpty() || password.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        boolean passwordIsVeryfied = false;
        Optional<User> user = userRepository.findByLogin(login);
        if (user.isPresent()) {
            passwordIsVeryfied = PasswordHash.VerifyHash(password, user.get().getPassword());
            if (!passwordIsVeryfied) {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                resp.getWriter().println("Invalid password");
                return;
            }
        }

        var token = UUID.randomUUID().toString();
        userRepository.updateToken(user.get().getId(), token);
        Cookie cookie = new Cookie("token", token);
        //0 - удалить, >0 - установить срок, <0 - сессионная кука.
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.sendError(HttpServletResponse.SC_OK);
    }
}
