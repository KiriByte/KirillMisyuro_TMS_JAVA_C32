package org.example.repository.impl;

import org.example.entity.QuestionEntity;
import org.example.repository.QuestionRepository;
import org.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionRepositoryImpl implements QuestionRepository {
    @Override
    public boolean addQuestion(QuestionEntity question) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "INSERT INTO questions (text, is_active) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, question.getText());
                statement.setBoolean(2, question.isActive());
                int lines = statement.executeUpdate();
                return lines > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteQuestionById(int id) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "UPDATE questions SET is_active = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setBoolean(1, false);
                statement.setInt(2, id);
                int lines = statement.executeUpdate();
                return lines > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateQuestion(QuestionEntity question) {
        return false;
    }

    @Override
    public Optional<QuestionEntity> getQuestionById(int id) {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM questions WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(ResultToEntity(resultSet));
                    }
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionEntity> getAllQuestions() {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM questions";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<QuestionEntity> questions = new ArrayList<>();
                    while (resultSet.next()) {
                        questions.add(ResultToEntity(resultSet));
                    }
                    return questions;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<QuestionEntity> getAllActiveQuestions() {
        try (Connection connection = DbConnection.getConnection()) {
            String query = "SELECT * FROM questions WHERE is_active = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setBoolean(1, true);
                try (ResultSet resultSet = statement.executeQuery()) {
                    List<QuestionEntity> questions = new ArrayList<>();
                    while (resultSet.next()) {
                        questions.add(ResultToEntity(resultSet));
                    }
                    return questions;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private QuestionEntity ResultToEntity(ResultSet resultSet) throws SQLException {
        QuestionEntity question = new QuestionEntity();
        question.setId(resultSet.getInt("id"));
        question.setText(resultSet.getString("text"));
        question.setActive(resultSet.getBoolean("is_active"));
        return question;
    }
}
