package com.kitchen.reliablekitchen.database;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    @Test
    void databaseConnection(){
    Connection conn =DatabaseConnection.getInstance().getConnection();
        Assertions.assertNotNull(conn);
    }

}
