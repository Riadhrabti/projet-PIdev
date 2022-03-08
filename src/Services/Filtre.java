/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author DELL
 */
import Utils.MydataBase;
import Entities.Article;
import java.sql.*;



public class Filtre {
    private Connection conn ;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst ;
public Filtre() {
        conn = MydataBase.getInstance().getCnx();
}
public void FiltreCategorie (int id) {
    String req = "SELECT nom_categorie , article.id_categorie  ,article.titre\n" +
"FROM categorie \n" +
"INNER JOIN article \n" +
"on categorie.id_categorie=article.id_categorie \n" +
"WHERE article.id_categorie=" +id ;
   
        try {
            ste = conn.createStatement();
            
            
            rst=ste.executeQuery(req);
            while (rst.next()){
            System.out.println( "titre : " +rst.getString("titre")+" "+"Categorie : "+rst.getString("nom_categorie") );
            
            }
            
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    
    
}
public void ajouterFavoirs(int id_article,int id_utilisateur){
String req="INSERT INTO `favoris_article` (id_article,id_utilisateur) values (?,?)";
try{            
pste = conn.prepareStatement(req);
            
            pste.setInt(1, id_article);
            pste.setInt(2, id_utilisateur);
            pste.executeUpdate();
            
}catch(SQLException e){}
}
public Boolean verifFavoris(int id_article,int id_utilisateur){
  boolean resultat =false  ; 
        
   try {
            String req = "SELECT EXISTS(SELECT * FROM `favoris_article` WHERE id_utilisateur="+id_utilisateur+" and id_article="+ id_article+ ") " ;
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

public void Favoris(int id_utilisateur , int id_article) {
        
        Filtre v; 
        v=new Filtre(); 
    if(v.verifFavoris(id_article,id_utilisateur)==false){
    v.ajouterFavoirs( id_article,id_utilisateur);
    
    }else {
    System.out.print("article déja vu\n");
    }
    }


public void FiltreFavoris (int id) {
    String req = "SELECT utilisateur.nom ,utilisateur.prenom ,favoris.id_utilisateur , article.titre \n" +
"FROM favoris\n" +
"INNER JOIN utilisateur \n" +
"ON favoris.id_utilisateur=utilisateur.id_utilisateur \n" +
"INNER JOIN article \n" +
"on article.id=favoris.id_article \n" +
"WHERE favoris.id_utilisateur= " +id ;
   
        try {
            ste = conn.createStatement();
            rst=ste.executeQuery(req);
            
            System.out.println(  "Article Favoris : "  );
            while (rst.next()){
            System.out.println(  rst.getString("titre") +"\n" );
            
            }
            
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    
    
}







}
