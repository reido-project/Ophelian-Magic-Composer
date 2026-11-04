package app.models.database;

import app.Config;

import java.sql.*;

public abstract class Database {
    protected Connection conn;
    protected Statement stmt;

    protected void connect() {
        try {
            final String url = "jdbc:sqlite:" + Config.SQLITE_DIR;
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    protected void disconnect() {
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

    protected void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
        }
    }

    protected ResultSet view(String sql) {
        ResultSet result = null;
        try {
            result = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("View Error: " + ex.getMessage());
        }
        return result;
    }
}
