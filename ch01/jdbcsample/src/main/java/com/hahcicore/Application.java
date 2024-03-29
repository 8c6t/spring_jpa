package com.hahcicore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "hachicore";
        String password = "123456";

        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);
            String sql = "CREATE TABLE ACCOUNT (id int, username varchar(255), password varchar(255))";
            String sql2 = "INSERT INTO ACCOUNT VALUES(1, 'hachicore', '123456')";
            try(PreparedStatement statement = connection.prepareStatement(sql2)) {
                statement.execute();
            }
        }
    }

}
