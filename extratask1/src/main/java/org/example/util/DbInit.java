package org.example.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {

    public static void init() {
        String questionsTable = """
                CREATE TABLE IF NOT EXISTS questions (
                    id SERIAL PRIMARY KEY,
                    text TEXT NOT NULL,
                    is_active BOOLEAN DEFAULT TRUE
                );
                """;

        String answersTable = """
                CREATE TABLE IF NOT EXISTS answers (
                    id SERIAL PRIMARY KEY,
                    text TEXT NOT NULL,
                    is_active BOOLEAN DEFAULT TRUE,
                    question_id INT NOT NULL,
                    FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE
                );
                """;

        try (Connection conn = DbConnection.getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(questionsTable);
            statement.executeUpdate(answersTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
