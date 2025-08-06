package repository.impl;

import repository.VoteRouteRepository;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteRouteRepositoryImpl implements VoteRouteRepository {
    @Override
    public boolean addVote(int user_id, int route_id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "INSERT INTO route_votes (user_id, route_id) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                statement.setInt(2, route_id);
                int result = statement.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeVote(int user_id, int route_id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "DELETE FROM route_votes WHERE user_id = ? AND route_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                statement.setInt(2, route_id);
                int result = statement.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasVoted(int user_id, int route_id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM route_votes WHERE user_id = ? AND route_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                statement.setInt(2, route_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    }
                }
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getVotesCount(int route_id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM route_votes WHERE route_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, route_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                    return 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Integer> getRoutesVotedByUser(int user_id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT route_id FROM route_votes WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user_id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<Integer> route_ids = new ArrayList<>();
                    while (resultSet.next()) {
                        route_ids.add(resultSet.getInt(1));
                    }
                    return route_ids;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
