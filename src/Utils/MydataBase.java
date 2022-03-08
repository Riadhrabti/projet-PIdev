package Utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
/**
 *
 * @author remo
 */
public class MydataBase {
    private String url = "jdbc:mysql://localhost:3306/tabdeal";
    private String username = "root";
    private String password = "";
    
    private Connection cnx;
    private static MydataBase instance;
    
    private MydataBase() {
        try {
            cnx = DriverManager.getConnection(url, username, password);
            System.out.println("database connected");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
    public static MydataBase getInstance() {
        if(instance == null){
            instance = new MydataBase();
        }
        return instance;
    }
     
}
