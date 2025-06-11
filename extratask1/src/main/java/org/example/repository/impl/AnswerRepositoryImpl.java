package org.example.repository.impl;

import org.example.entity.AnswerEntity;
import org.example.repository.AnswerRepository;
import org.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnswerRepositoryImpl implements AnswerRepository {

    @Override
    public AnswerEntity create(AnswerEntity entity) {
        String query = "INSERT INTO answers (text, question_id) VALUES (?,?) RETURNING *";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getText());
            statement.setInt(2, entity.getQuestionId());
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
    public Optional<AnswerEntity> findById(int id) {
        String query = "SELECT * FROM answers WHERE id = ?";
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
    public List<AnswerEntity> findAll() {
        String query = "SELECT * FROM answers";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<AnswerEntity> answers = new ArrayList<>();
            while (resultSet.next()) {
                answers.add(ResultToEntity(resultSet));
            }
            return answers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(AnswerEntity entity) {
        String query = "UPDATE answers SET text = ?, is_active = ?, question_id = ? WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, entity.getText());
            statement.setBoolean(2, entity.isActive());
            statement.setInt(3, entity.getQuestionId());
            statement.setInt(4, entity.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM answers WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private AnswerEntity ResultToEntity(ResultSet resultSet) throws SQLException {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId(resultSet.getInt("id"));
        answerEntity.setText(resultSet.getString("text"));
        answerEntity.setActive(resultSet.getBoolean("is_active"));
        answerEntity.setQuestionId(resultSet.getInt("question_id"));
        return answerEntity;
    }

    @Override
    public List<AnswerEntity> findAllActiveByQuestionId(long questionId) {
        String query = "SELECT * FROM answers WHERE question_id = ? and is_active = true";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, questionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<AnswerEntity> answers = new ArrayList<>();
                while (resultSet.next()) {
                    answers.add(ResultToEntity(resultSet));
                }
                return answers;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateStatus(AnswerEntity answerEntity) {
        String query = "UPDATE answers SET is_active = ? WHERE id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1, answerEntity.isActive());
            statement.setInt(2, answerEntity.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
