package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    public static Connection getConnection() {
        Connection myConnect = null;
        try {
            //
            myConnect = DriverManager.getConnection(
                    "jdbc:postgresql://javafs220103mjl.cmzfaa2clgvb.us-east-1.rds.amazonaws.com:5432/postgres",
                    "postgres", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myConnect;
    }
}
