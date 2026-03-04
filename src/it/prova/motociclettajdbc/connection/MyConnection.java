package it.prova.motociclettajdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final String URL = "jdbc:mysql://localhost:3306/motociclettajdbc"
            + "?user=" + USER
            + "&password=" + PASSWORD
            + "&allowPublicKeyRetrieval=true"
            + "&useSSL=false"
            + "&serverTimezone=UTC";
    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return connection;
    }
}
