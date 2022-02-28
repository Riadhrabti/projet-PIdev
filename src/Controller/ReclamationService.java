package Controller;

import Config.Database;
import Entity.Article;
import Entity.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Riadh
 */
public class ReclamationService {
    Connection mc;
    PreparedStatement ste;
    
    public ReclamationService(){
    mc=Database.getInstance().getCnx();
}
    public void ajouterReclamation(Reclamation r){
    String sql="INSERT INTO reclamation(id_membre,id_echange,titre,Description,Date_rec,etat) VALUES (?,?,?,?,?,?)";
    try{
        
        ste=mc.prepareStatement(sql);
        ste.setInt(1,r.getId_membre());
        ste.setInt(2,r.getId_echange());
        ste.setString(3,r.getTitre());
        ste.setString(4,r.getDescription());
        ste.setDate(5,r.getDate_rec());
        ste.setInt(6,r.getEtat());
        ste.executeUpdate();
        System.out.println("Reclamation ajouté");
        
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    public void UpdateReclamation(Reclamation r){
        String sql ="update Reclamation set etat = ?  where id = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(2, r.getId());
            ste.setInt(1, r.getEtat());
            
            ste.executeUpdate();
            System.out.println("RECLAMATION modifié");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
         public ObservableList<Reclamation> afficherReclamation(){
        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
        String sql = "select * from Reclamation";
        try {
            ste = mc.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setId_membre(rs.getInt("id_membre"));
                r.setId_echange(rs.getInt("id_echange"));
                r.setTitre(rs.getString("Titre"));
                r.setDescription(rs.getString("Description"));
                r.setEtat(rs.getInt("etat"));
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return reclamations;
    }
         public void DeleteReclamation(Reclamation r ){
        
        String sql ="delete from reclamation where id = ?";
        try{
            
        ste=mc.prepareStatement(sql);
        ste.setInt(1, r.getId());
        ste.executeUpdate();
        System.out.println("reclamation supprimée");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        

}
