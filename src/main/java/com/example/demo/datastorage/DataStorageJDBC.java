package com.example.demo.datastorage;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

@Component
public class DataStorageJDBC {

    private static Logger logger = Logger.getLogger(DataStorageJDBC.class.getName());

    public DataStorageJDBC() {
    }

    private static Connection getConnection() throws SQLException, IOException {
        FileInputStream fis;
        Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            File file = new File(classLoader.getResource("application.properties").getFile());
            fis = new FileInputStream(file);
            properties.load(fis);
            String url = properties.getProperty("database.url");
            String userName = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");
            String dialectDataBase = properties.getProperty("database.dialect");
            return DriverManager.getConnection(url, userName, password);
    }

    public Statement init() throws IOException, SQLException {

         return   getConnection().createStatement();


    }


}
