package president.election.application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Mysql connector file
 */
public class DbOperations {
    /**
     *
     * @return connection to our db.
     */
    public static Connection connectToDb() {

        String DB_URL = "jdbc:mysql://localhost/election_db";
        String USER = "root";
        String PASS = "root";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Disconnecting from db.
     * @param connection
     * @param statement
     */
    public static void disconnectFromDb(Connection connection, Statement statement) {
        try {
            if (connection != null && statement != null) {
                connection.close();
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
