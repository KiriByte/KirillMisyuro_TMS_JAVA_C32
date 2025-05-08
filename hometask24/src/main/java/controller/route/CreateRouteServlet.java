package controller.route;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Route;
import repository.RouteRepository;
import repository.impl.RouteRepositoryImpl;

import java.io.IOException;

@WebServlet("/createRoute")
public class CreateRouteServlet extends HttpServlet {
    private final RouteRepository routeRepository = new RouteRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var description = req.getParameter("description");
        var length = Integer.parseInt(req.getParameter("length"));
        var route = new Route(description, length);
        var isSuccess = routeRepository.addRoute(route);
        if (isSuccess) {
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
