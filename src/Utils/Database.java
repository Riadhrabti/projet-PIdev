/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Database {
 
     private static String url ="jdbc:mysql://localhost:3306/pi_dev";
    private static String user ="root";
    private static String pwd ="";
    
    private static Connection conn;
 
    private static Database instance;
    
    private Database() {
        
        try {
            
            conn = DriverManager.getConnection(url, user, pwd);
                        System.out.println(" connecté..");

        } catch (SQLException ex) {
            System.out.println("un probleme de liberation de la source :  "+ex.getMessage());
        }
    }
    
    public static Database getInstance(){
        if(instance == null)
            instance = new Database();
        
        return instance;
    }

    public static Connection getConn() {
        return conn;
    }
    
    
    
    
}
