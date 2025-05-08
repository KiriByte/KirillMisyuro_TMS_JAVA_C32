package repository.impl;

import model.User;
import repository.UserRepository;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) {
        try (Connection connection = DbConnection.getConnection()) {

            String sql = "INSERT INTO users(login,password,token) VALUES (?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getToken());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE login = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, login);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return Optional.of(RawToUser(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByToken(String token) {
        try (Connection connection = DbConnection.getConnection();) {
            String sql = "SELECT * FROM users WHERE token = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, token);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return Optional.of(RawToUser(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(int id) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return Optional.of(RawToUser(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateToken(int id, String token) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "UPDATE users SET token = ? WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, token);
                ps.setInt(2, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean existsByLogin(String login) {
        try (Connection connection = DbConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE login = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, login);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User RawToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("token"));
    }
}
