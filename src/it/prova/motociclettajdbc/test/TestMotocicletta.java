package it.prova.motociclettajdbc.test;

import com.mysql.cj.jdbc.MysqlDataSource;
import it.prova.motociclettajdbc.connection.MyConnection;

public class TestMotocicletta {
    public static void main(String[] args) {

        System.out.println("Connecting to database...:" + MyConnection.getConnection());
    }
}
