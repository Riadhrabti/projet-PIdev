/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.gestion_echange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riadh
 */
public class ArticleService {
    Connection mc;
    PreparedStatement ste;
    
    public ArticleService(){
    mc=ConnexionBD.getInstance().getCnx();
}
    
    public void ajouterArticle(Article a){
    String sql="insert into Article(etat,description)values(?,?)";
    try{
        ste=mc.prepareStatement(sql);
        ste.setString(1,a.getTitre());
        ste.setString(2,a.getDescription());
        ste.executeUpdate();
        System.out.println("article ajouté");
        
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    public void UpdateArticle(Article a){
        String sql ="update Article set etat = ? , Description = ? where id = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(3, a.getId());
            ste.setString(1, a.getTitre());
            ste.setString(2, a.getDescription());
            ste.executeUpdate();
            System.out.println("Article modifier");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public List<Article> afficherArticle(){
        List<Article> articles = new ArrayList<>();
        String sql = "select * from Article";
        try {
            ste = mc.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.getTitre(rs.getString("Titre"));
                a.getDescription(rs.getString("Description"));
                articles.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return articles;

        
    }
        public void DeleteArticle(Article a ){
        
        String sql ="delete from personne where id = ?";
        try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1, a.getId());
        ste.executeUpdate();
        System.out.println("article supprimer");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
}
