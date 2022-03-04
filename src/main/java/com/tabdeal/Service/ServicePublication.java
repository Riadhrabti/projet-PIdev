/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Service;

import com.tabdeal.Entite.Categorie;
import com.tabdeal.Entite.Publication;
import com.tabdeal.InterfaceService.InterfaceService;
import com.tabdeal.Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SBS
 */
public class ServicePublication implements InterfaceService<Publication> {
    
  
    

    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;
    
    

    public ServicePublication() {
        conn = DataBase.getInstance().getConnection();
    }
    
    public boolean isCleanOfBadWords(Publication t){
            
        List<String> badWords=Arrays.asList("FUCK","DAMN","SHIT","BITCH");
       String publicationTitle = t.getTitre();
       String publicationDescription = t.getDescription();
       
       String[] publicationTitleWords = publicationTitle.split(" ");
       String[] publicationDescriptionWords = publicationDescription.split(" ");
       
       for ( String word :publicationTitleWords ) {
       if(badWords.contains(word.toUpperCase())){
       return false;       
       }
       }
       for (String word : publicationDescriptionWords){
            if(badWords.contains(word.toUpperCase())){
       return false;       
       }       
       }
        return true;
    }

    @Override
    public void ajouter(Publication t) {
        
        
      if(isCleanOfBadWords(t)){
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_publication = new Date(System.currentTimeMillis()) ;
        
     PreparedStatement ps;
        
        try {
            String req = "INSERT INTO `publication` ( `titre`, `date`, `description`, `like`, `dislike`, `id_categorie`,`id_user`) VALUES (?,?,?,?,?,?,?)";
            ps= conn.prepareStatement(req);
            
             ps.setString(1, t.getTitre());
             ps.setString(2, date_publication.toString());
             ps.setString(3, t.getDescription());
             ps.setInt(4, t.getLike());
             ps.setInt(5, t.getDislike());
             ps.setInt(6, t.getId_categorie());
             ps.setInt(7, t.getId_user());
             ps.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
        }}
      else {
        throw new RuntimeException("Your Publication is not clean");
      }

    }

    @Override
    public boolean delete(Publication t) {
        String req = "delete from publication where id=?;";
        try {
            pste = conn.prepareStatement(req);

            pste.setInt(1, t.getId());

            pste.executeUpdate();
            System.out.println("publication Supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean update(Publication t) {
        String req = "update publication set titre=? , description=? , id_categorie=?   where id=?;";
        try {
            pste = conn.prepareStatement(req);
            pste.setString(1, t.getTitre());
            
            pste.setString(2, t.getDescription());
            pste.setInt(3, t.getId_categorie());
            pste.setInt(4, t.getId());
            
            

            pste.executeUpdate();
            System.out.println("publication créée");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public ObservableList<Publication> readAll() {
        ObservableList<Publication> publications =  FXCollections.observableArrayList();
        String req = "SELECT * FROM `publication`";

        try {
//            pste = conn.prepareStatement(req);
//            ResultSet rs = pste.executeQuery();

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);

            while (rs.next()) {
                Publication p = new Publication();
                p.setId(rs.getInt("id"));
                p.setTitre(rs.getString("titre"));
                System.out.println(p.getTitre());
                p.setDescription(rs.getString("description"));
                p.setDate(rs.getString("date"));
                p.setLike(rs.getInt("like"));
                p.setDislike(rs.getInt("dislike"));
                p.setId_categorie(rs.getInt("id_categorie"));
                p.setId_user(rs.getInt("id_user"));

                publications.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }

        return publications;

    }

}
