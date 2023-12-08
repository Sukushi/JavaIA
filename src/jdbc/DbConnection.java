package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection = null;
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/javaia";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private DbConnection() {

    }

    // only method to access connection variable
    // this variable can only be instanced one time
    // design pattern single tone
    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            // nécessaire pour charger le driver MariaDb
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }
        return connection;
    }
}
