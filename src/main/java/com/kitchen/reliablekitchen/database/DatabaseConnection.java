package com.kitchen.reliablekitchen.database;

import com.kitchen.reliablekitchen.utilities.PropertiesReader;

import java.sql.*;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseConnection {

  private Connection connection = null;
  private static DatabaseConnection dataConnection = null;


  private PropertiesReader propertiesReader = new PropertiesReader();

  private DatabaseConnection() {
    createConnection();
  }

  void createConnection() {
    try {
      Properties props = propertiesReader.getProperties("src/main/resources/dbConfig.properties");
      String env = System.getProperty("APP_ENV", "dev");
      String baseUrl, url = "", username = "", password = "";
      if (env.equalsIgnoreCase("prod")) {
        baseUrl =
          "jdbc:mysql://" +
          props.getProperty("PROD_DB_HOST") +
          ":" +
          props.getProperty("PROD_DB_PORT") +
          "/";
        url = baseUrl + props.getProperty("PROD_DB_NAME");
        username = props.getProperty("PROD_DB_USERNAME");
        password = props.getProperty("PROD_DB_PASSWORD");
      } else if (env.equalsIgnoreCase("test")) {
        baseUrl =
          "jdbc:mysql://" +
          props.getProperty("TEST_DB_HOST") +
          ":" +
          props.getProperty("TEST_DB_PORT") +
          "/";
        url = baseUrl + props.getProperty("TEST_DB_NAME");
        username = props.getProperty("TEST_DB_USERNAME");
        password = props.getProperty("TEST_DB_PASSWORD");
      } else {
        baseUrl =
          "jdbc:mysql://" +
          props.getProperty("DEV_DB_HOST") +
          ":" +
          props.getProperty("DEV_DB_PORT") +
          "/";
        url = baseUrl + props.getProperty("DEV_DB_NAME");
        username = props.getProperty("DEV_DB_USERNAME");
        password = props.getProperty("DEV_DB_PASSWORD");
      }
    connection = DriverManager.getConnection(url, username, password);
      if (connection != null) {
        System.out.println("Connection with DB successful!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static DatabaseConnection getInstance() {
    if (null == dataConnection)
		{
			dataConnection = new DatabaseConnection();
		}
		return dataConnection;

  }

  public Connection getConnection(){
    return connection;
  }

  public void closeConnection() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (Exception e) {
      connection = null;
    }
  }
}
