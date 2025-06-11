package repository.impl;

import model.Route;
import repository.RouteRepository;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RouteRepositoryImpl implements RouteRepository {
    @Override
    public boolean addRoute(Route route) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "INSERT INTO routes(description, length_in_meters) VALUES (?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, route.getDescription());
                ps.setInt(2, route.getLengthInMeters());
                int lines = ps.executeUpdate();
                return lines > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Route> getRouteById(int id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM routes WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return Optional.of(RawToRoute(rs));
                    }
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Route> getAllRoutes() {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM routes";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    List<Route> routes = new ArrayList<>();
                    while (rs.next()) {
                        routes.add(RawToRoute(rs));
                    }
                    return routes;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateRoute(Route route) {
        return false;
    }

    @Override
    public boolean deleteRouteById(int id) {
        return false;
    }

    private Route RawToRoute(ResultSet rs) throws SQLException {
        Route route = new Route();
        route.setId(rs.getInt("id"));
        route.setDescription(rs.getString("description"));
        route.setLengthInMeters(rs.getInt("length_in_meters"));
        return route;
    }
}
