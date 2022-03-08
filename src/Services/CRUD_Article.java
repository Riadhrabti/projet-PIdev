package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
;
import Utils.MydataBase;
import Entities.Article;
import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CRUD_Article {
    private Connection conn ;
    private Statement ste;
    private PreparedStatement pste;
public CRUD_Article() {
        conn = MydataBase.getInstance().getCnx();
}

     
        public void ajouter(String s ,int a,int b ,int c ,String Des,int boost,String etat,String image ) {
        String req = "INSERT INTO `article` (article.titre,article.id_categorie,article.id_proprietaire,article.id_Gouvernorat,article.Description,article.boost,article.etat,article.image) VALUES( ?,?,?,?,?,?,?,?)";
        try {
            pste = conn.prepareStatement(req);
            pste.setString(1, s);
            pste.setInt(2, a);
            pste.setInt(3, b);
            pste.setInt(4, c);  
            pste.setString(5, Des);
            pste.setInt(6, boost); 
            pste.setString(7, etat);
            pste.setString(8, image);
            pste.executeUpdate();
            System.out.println("article créée");
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    }
        

    public void updateTitre(String s ,int a,int b ,int c ,String Des,int boost,String etat,String image) {
        String req = "UPDATE `article` SET `id_proprietaire`=?,`echange_cross_cat`=? "+
        ",`Date_publication`=?,`etat`=?,`Description`=?,`titre`=? "+
        ",`boost`=?,`id_categorie`=?,`id_Gouvernorat`=?,`image`=? "+
        "WHERE `id`=?" ;
        try {
            Article A    = new Article() ; 
           pste = conn.prepareStatement(req);
            pste.setString(1, s);
            pste.setInt(2, a);
            pste.setInt(3, b);
            pste.setInt(4, c);  
            pste.setString(5, Des);
            pste.setInt(6, boost); 
            pste.setString(7, etat);
            pste.setString(8, image);
            pste.setInt(9, A.getId());
            pste.executeUpdate();
            System.out.println("titre modifié");
        } catch (SQLException ex) {
            Logger.getLogger(CRUD_Article.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
       
    }
//    public void Delete(Article a) {
//        String req = "Delete FROM `article' where id=?" ;
//        try {
//           pste = conn.prepareStatement(req); 
//           pste.setInt(1, a.getId());
//            pste.executeUpdate();
//            System.out.println("Article supprimé");
//        } catch (SQLException ex) {
//            Logger.getLogger(CRUD_Article.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//       
//    public String getTitle (int a) {
//        String req = "Select From `article` where id=?" ;
//        String r="";
//        try {
//           pste = conn.prepareStatement(req);
//          
//            pste.setInt(1, a);
//            ResultSet rst; 
//            rst = pste.executeQuery();
//             
//            while (rst.next()){
//             r = rst.getString(3);
//            }
//            
//            
//        } catch (SQLException ex) {
//            
//        }
//        return r ; 
//        
//    }    
    
    
   



















}