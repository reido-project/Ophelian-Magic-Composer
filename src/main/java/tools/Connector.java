package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

class Connector {
    private Connection conn;
    private Statement stmt;

    void connect() {
        try {
            final String url = "jdbc:sqlite:src/main/java/database.sqlite";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    void disconnect() {
        try {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing database: " + e.getMessage());
        }
    }

    void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
        }
    }

    ResultSet view(String sql) {
        ResultSet result = null;
        try {
            result = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("View Error: " + ex.getMessage());
        }
        return result;
    }

    void executeSQLFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             Statement statement = this.conn.createStatement()) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("--") || line.isEmpty()) {
                    continue;
                }

                sqlBuilder.append(line).append(" ");

                if (line.endsWith(";")) {
                    String sql = sqlBuilder.toString().trim();
                    statement.execute(sql);

                    sqlBuilder.setLength(0);
                }
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}