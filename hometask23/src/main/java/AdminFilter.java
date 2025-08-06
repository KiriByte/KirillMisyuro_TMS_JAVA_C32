import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/admins")
public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        var httpResponse = (HttpServletResponse) response;
        var role = request.getParameter("role");

        if (role == null) {
            httpResponse.setStatus(403);
            httpResponse.getWriter().println("Access denied. Missing role");
            return;
        }
        if (!role.equals("ADMIN")) {
            httpResponse.setStatus(403);
            httpResponse.getWriter().println("Access denied. Invalid role");
            return;
        }
        chain.doFilter(request, response);
    }
}
