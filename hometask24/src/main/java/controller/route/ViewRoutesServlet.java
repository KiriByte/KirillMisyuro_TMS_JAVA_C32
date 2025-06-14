package controller.route;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.RouteRepository;
import repository.VoteRouteRepository;
import repository.impl.RouteRepositoryImpl;
import repository.impl.VoteRouteRepositoryImpl;

import java.io.IOException;

@WebServlet("/routes")
public class ViewRoutesServlet extends HttpServlet {
    private final RouteRepository routeRepository = new RouteRepositoryImpl();
    private final VoteRouteRepository voteRepository = new VoteRouteRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var routes = routeRepository.getAllRoutes();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write("<html><body>");
        resp.getWriter().write("<h1>Routes</h1>");
        resp.getWriter().write("<table border='1'>");
        resp.getWriter().write("<tr><th>ID</th><th>Description</th><th>Length</th><th>Votes</th></tr>");
        for (var route : routes) {
            int votesCount = voteRepository.getVotesCount(route.getId());
            resp.getWriter().write("<tr>");
            resp.getWriter().write("<td>" + route.getId() + "</td>");
            resp.getWriter().write("<td>" + route.getDescription() + "</td>");
            resp.getWriter().write("<td>" + route.getLengthInMeters() + "</td>");
            resp.getWriter().write("<td>" + votesCount + "</td>");
            resp.getWriter().write("</tr>");
        }
        resp.getWriter().write("</table>");
        resp.getWriter().write("</body></html>");
    }
}

