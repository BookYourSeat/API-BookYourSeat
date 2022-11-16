package com.bookyourseat.api.Core.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Connector {

    private final String url = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=BookYourSeat;user=sa;password=123456";
    private Connection connection;

    public Connector() {
        try {
            this.connect();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(this.url);
    }

    public Connection getConnection() {
        return this.connection;
    }
}
