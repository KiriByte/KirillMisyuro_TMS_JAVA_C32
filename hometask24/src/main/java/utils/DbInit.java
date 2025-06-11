package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbInit {

    public static void init() {
        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id SERIAL PRIMARY KEY,
                    login VARCHAR(100),
                    password VARCHAR(100),
                    token VARCHAR(100)
                )
                """;
        String routesTable = """
                CREATE TABLE IF NOT EXISTS routes (
                    id SERIAL PRIMARY KEY,
                    description VARCHAR(100),
                    length_in_meters INTEGER NOT NULL
                )
                """;
        String routeVotesTable = """
                CREATE TABLE IF NOT EXISTS route_votes (
                    id SERIAL PRIMARY KEY,
                    route_id INTEGER NOT NULL,
                    user_id INTEGER NOT NULL,
                    FOREIGN KEY (route_id) REFERENCES routes(id) ON DELETE CASCADE,
                    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                    UNIQUE (route_id, user_id)
                )
                """;


        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();) {
            stmt.execute(usersTable);
            stmt.execute(routesTable);
            stmt.execute(routeVotesTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
