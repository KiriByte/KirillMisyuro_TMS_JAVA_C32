package controller.route;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.RouteRepository;
import repository.UserRepository;
import repository.VoteRouteRepository;
import repository.impl.RouteRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import repository.impl.VoteRouteRepositoryImpl;

import java.io.IOException;

@WebServlet("/vote")
public class VoteRouteServlet extends HttpServlet {

    private final UserRepository userRepository = new UserRepositoryImpl();
    private final VoteRouteRepository voteRouteRepository = new VoteRouteRepositoryImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var routeIdParam = req.getParameter("id");
        String token = null;
        var cookies = req.getCookies();
        if (cookies != null) {
            for (var cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if (routeIdParam == null || token == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Route id and authentication token are required");
            return;
        }

        int routeId;
        try {
            routeId = Integer.parseInt(routeIdParam);
            if (routeId <= 0) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Route ID must be a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid route id format (must be a number)");
            return;
        }

        var user = userRepository.findByToken(token);
        if (user.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }
        var userId = user.get().getId();

        boolean isSuccess = voteRouteRepository.addVote(userId, routeId);
        if (isSuccess) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to register vote");
        }

    }
}
