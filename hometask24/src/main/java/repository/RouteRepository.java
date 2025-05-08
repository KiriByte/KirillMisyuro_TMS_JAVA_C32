package repository;

import model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteRepository {
    //CRUD
    boolean addRoute(Route route);

    Optional<Route> getRouteById(int id);

    List<Route> getAllRoutes();

    boolean updateRoute(Route route);

    boolean deleteRouteById(int id);

}
