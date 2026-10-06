package com.hospital.util;

import org.apache.taglibs.standard.extra.spath.SPathTag;

import java.net.SocketTimeoutException;
import java.sql.*;

public class DatabaseConnection {

        private static final String URL = "jdbc:postgresql://localhost:5432/Ediagnostic";
        private static final String USER = "postgres";
        private static final String PASSWORD = "pgres";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER, PASSWORD);
    }

    public static void main(String[] args){
        try{
            Connection con = getConnection();
            System.out.println("Connection reussite ");
            con.close();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
    }

    }
