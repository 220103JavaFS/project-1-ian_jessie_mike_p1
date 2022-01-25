package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

    Connection getConnection() {
        Connection myConnect = null;
        try {
            //
            myConnect = DriverManager.getConnection(
                    "jdbc:postgresql://javafs220103mjl.cmzfaa2clgvb.us-east-1.rds.amazonaws.com:5432/demos",
                    "postgres", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myConnect;
    }
}
