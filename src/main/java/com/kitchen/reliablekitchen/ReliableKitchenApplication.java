package com.kitchen.reliablekitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.SQLException;

@SpringBootApplication
public class ReliableKitchenApplication {


    public static void main(String[] args) throws SQLException{
        SpringApplication.run(ReliableKitchenApplication.class, args);
    }

}
