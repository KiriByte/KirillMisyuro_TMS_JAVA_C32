package org.example;

import org.example.services.impl.StringStorage;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String URL = System.getenv("POSTGRES_URL");
        final String LOGIN = System.getenv("POSTGRES_LOGIN");
        final String PASSWORD = System.getenv("POSTGRES_PASSWORD");

        if (URL == null || LOGIN == null || PASSWORD == null) {
            System.err.println("Required environment variables is not set");
            return;
        }

        var props = new Properties();
        props.setProperty("user", LOGIN);
        props.setProperty("password", PASSWORD);

        try (Connection conn = DriverManager.getConnection(URL, props);
             Scanner scanner = new Scanner(System.in)) {
            StringStorage stringStorage = new StringStorage(conn);
            System.out.println("Connected to database");

            while (true) {
                System.out.print("Please enter the string: ");
                var input = scanner.nextLine();
                if (input.isEmpty()) {
                    var strings = stringStorage.readStrings();
                    for (var string : strings) {
                        System.out.println(string);
                    }
                    break;
                }
                stringStorage.writeString(input);
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}