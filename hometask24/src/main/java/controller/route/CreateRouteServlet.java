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

        var descriptionParam = req.getParameter("descriptionParam");
        var lengthParam = req.getParameter("length");

        if (descriptionParam == null || lengthParam == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Description and length are required");
            return;
        }

        if (descriptionParam.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Description cannot be empty");
            return;
        }

        int length;
        try {
            length = Integer.parseInt(lengthParam);
            if (length <= 0) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Length must be a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid length format (must be a number)");
            return;
        }

        var route = new Route(descriptionParam, length);
        var isSuccess = routeRepository.addRoute(route);
        if (isSuccess) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to create route");
        }
    }
}
