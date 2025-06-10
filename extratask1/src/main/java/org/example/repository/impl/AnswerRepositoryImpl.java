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

public class AnswerRepositoryImpl implements AnswerRepository {
    @Override
    public boolean addAnswer(AnswerEntity answer) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "INSERT INTO answers (text, is_active, question_id) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, answer.getText());
                statement.setBoolean(2, answer.isActive());
                statement.setInt(3, answer.getQuestionId());
                int lines = statement.executeUpdate();
                return lines > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAnswer(AnswerEntity answer) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "UPDATE answers SET is_active=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setBoolean(1, answer.isActive());
                statement.setInt(2, answer.getId());
                int lines = statement.executeUpdate();
                return lines > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateAnswer(AnswerEntity answer) {
        return false;
    }

    @Override
    public List<AnswerEntity> getAllAnswersByQuestionId(int questionId) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM answers WHERE question_id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, questionId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<AnswerEntity> answers = new ArrayList<>();
                    while (resultSet.next()) {
                        answers.add(ResultToEntity(resultSet));
                    }
                    return answers;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<AnswerEntity> getAllActiveAnswersByQuestionId(int questionId) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM answers WHERE is_active=? AND question_id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setBoolean(1, true);
                statement.setInt(2, questionId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<AnswerEntity> answers = new ArrayList<>();
                    while (resultSet.next()) {
                        answers.add(ResultToEntity(resultSet));
                    }
                    return answers;
                }
            }

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
}
