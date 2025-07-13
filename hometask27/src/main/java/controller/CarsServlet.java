package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Car;

import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> cars = List.of(
                new Car(1, "Toyota", 25000),
                new Car(2, "Honda", 27000),
                new Car(3, "BMW", 60000),
                new Car(4, "Audi", 50000),
                new Car(5, "Ford", 40000),
                new Car(6, "Golf", 30000)
        );

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/cars.jsp").forward(req, resp);
    }
}
