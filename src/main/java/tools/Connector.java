package tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import app.Config;

class Connector {
    private Connection conn;
    private Statement stmt;

    void connect() {
        try {
            final String url = "jdbc:sqlite:" + Config.SQLITE_DIR;
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

    void executeSQLFile(String resourcePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalStateException("SQL file not found on classpath: " + resourcePath);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                 Statement statement = conn.createStatement()) {

                StringBuilder sqlBuilder = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.startsWith("--") || line.isEmpty()) continue;

                    sqlBuilder.append(line).append(" ");

                    if (line.endsWith(";")) {
                        statement.execute(sqlBuilder.toString().trim());
                        sqlBuilder.setLength(0);
                    }
                }
                System.out.println("Successfully executed: " + resourcePath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error executing SQL file (" + resourcePath + "): " + e.getMessage(), e);
        }
    }
}