import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Random;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            var dt = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
            if (new Random().nextBoolean()) {
                throw new IOException("Random error!");
            }
            try (PrintWriter pw = resp.getWriter()) {
                pw.println(dt);
            }
            //throw new IOException("error");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            if (!resp.isCommitted()) {
                resp.sendError(500);
            }
        }
    }
}
