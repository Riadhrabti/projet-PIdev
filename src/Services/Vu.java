/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.MydataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class Vu {
     private Connection conn ;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst ;
public Vu() {
        conn = MydataBase.getInstance().getCnx();
}
    


public int VuArticleCount (int id) {
    
   int resultat =0 ; 
        try {
            String req = "SELECT count(*) FROM `vu` WHERE vu.id_article=" +id ;
            ste = conn.createStatement();
            
            
            rst=ste.executeQuery(req);
            while (rst.next()){
            
            resultat=rst.getInt("count(*)"); 
            }
            
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    
    return resultat;
}

public Boolean VuVerif (int id_utilisateur,int id_article) {
    
  boolean resultat =false  ; 
        
   try {
            String req = "SELECT EXISTS(SELECT * FROM vu WHERE id_utilisateur="+id_utilisateur+" and id_article="+ id_article+ ") " ;
            ste = conn.createStatement();
            
            
            rst=ste.executeQuery(req);
            while (rst.next()){
            
            if (rst.getInt(1)==1){
            resultat=true ; 
               }
            }
            
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    
    return resultat;
}

public void ajouter(int id_utilisateur , int id_article) {
        
    
    
    
    String req = "INSERT INTO vu (id_utilisateur,id_article) VALUES ('" + id_utilisateur + "','" + id_article + "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Vu ajouté\n");
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    }

public void consulter(int id_utilisateur , int id_article) {
        
        Vu v; 
        v=new Vu(); 
    if(v.VuVerif(id_utilisateur, id_article)==false){
    v.ajouter(id_utilisateur, id_article);
    
    }else {
    System.out.print("article déja vu\n");
    }
    }
























   
       

}
