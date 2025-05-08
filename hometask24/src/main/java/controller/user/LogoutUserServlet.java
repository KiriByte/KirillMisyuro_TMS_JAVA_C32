package controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutUserServlet extends HttpServlet {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        String token = null;
        if (cookies != null) {
            for (var cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if (token == null || token.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        var user = userRepository.findByToken(token);
        if (user.isEmpty()) {
            System.out.println("User not found");
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        userRepository.updateToken(user.get().getId(), "");

        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/auth");


    }
}
