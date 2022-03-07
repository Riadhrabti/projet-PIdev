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
 * @author Riadh
 */

public class Database {
    public String url="jdbc:mysql://localhost:3306/tabdealdb";
    public String user="root";
    public String pwd="";
    public static Database cn;
    private Connection cnx;
    private Database(){
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion etablie");
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            
        }

    }
    public static Database getInstance(){
        if(cn==null)
            cn= new Database();
           return cn;
      
    }
      public Connection getCnx() {
        return cnx;  
    }
}
