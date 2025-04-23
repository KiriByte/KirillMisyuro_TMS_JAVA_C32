package org.example.services.impl;

import org.example.services.StringReader;
import org.example.services.StringWriter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StringStorage implements StringReader, StringWriter {

    private final Connection connection;

    public StringStorage(Connection connection) {
        this.connection = connection;
        createTableIfNotExists();
    }

    private void createTableIfNotExists() {
        try {
            Statement st = connection.createStatement();
            var query = "CREATE TABLE IF NOT EXISTS string_data (data VARCHAR)";
            st.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }

    @Override
    public List<String> readStrings() throws SQLException {
        List<String> result = new ArrayList<>();
        var query = "SELECT data FROM string_data";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("data"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public void writeString(String data) throws SQLException {
        var query = "INSERT INTO string_data (data) VALUES (?)";
        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setString(1, data);
            st.executeUpdate();
        }
    }
}
