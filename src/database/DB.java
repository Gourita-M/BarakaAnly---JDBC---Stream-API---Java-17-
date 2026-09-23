package src.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection connection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/BankingAnalysis";
        String userName = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, userName, password);

        return connection;
    }
}
