package it.prova.motociclettajdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECT_STR = "jdbc:mysql://localhost:3306/motociclettajdbc?user=root&password=Irene11@&allowPublicKeyRetrieval=true&useSSL=FALSE&serverTimezone=UTC";

    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(CONNECT_STR);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return connection;
    }
}
