package org.example.repository.impl;

import org.example.entity.QuestionEntity;
import org.example.repository.CrudRepository;
import org.example.repository.QuestionRepository;
import org.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionRepositoryImpl implements
        QuestionRepository {

    @Override
    public QuestionEntity create(QuestionEntity entity) {
        String query = "INSERT INTO questions (text) VALUES (?) RETURNING *";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getText());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return ResultToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int update(QuestionEntity entity) {
        String query = "UPDATE questions SET text = ?, is_active = ? WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getText());
            statement.setBoolean(2, entity.isActive());
            statement.setInt(3, entity.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<QuestionEntity> findById(int id) {
        String query = "SELECT * FROM questions WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(ResultToEntity(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionEntity> findAll() {
        String query = "SELECT * FROM questions";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<QuestionEntity> questions = new ArrayList<>();
            while (resultSet.next()) {
                questions.add(ResultToEntity(resultSet));
            }
            return questions;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM questions WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateStatus(QuestionEntity question) {
        String query = "UPDATE questions SET is_active = ? WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1, question.isActive());
            statement.setInt(2, question.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionEntity> findAllActive() {
        String query = "SELECT * FROM questions WHERE is_active = true";
        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            List<QuestionEntity> questions = new ArrayList<>();
            while (resultSet.next()) {
                questions.add(ResultToEntity(resultSet));
            }
            return questions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private QuestionEntity ResultToEntity(ResultSet resultSet) throws SQLException {
        QuestionEntity entity = new QuestionEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setText(resultSet.getString("text"));
        entity.setActive(resultSet.getBoolean("is_active"));
        return entity;
    }


}
