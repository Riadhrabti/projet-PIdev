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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String res = null;
            ste = mc.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setId_membre(rs.getInt("id_membre"));
                r.setId_echange(rs.getInt("id_echange"));
                r.setTitre(rs.getString("Titre"));
                r.setDescription(rs.getString("Description"));
                r.setDate_rec(rs.getDate("Date_rec"));
                {
                if(rs.getInt("etat")==1){
                    res="non traité";
                
                }
                else if(rs.getInt("etat")==2) {
                    res=" traité";
                            }
                   
                }
                
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
        
public ObservableList<Reclamation> rechercheetat(String searchby, String value) {
        String sql = "select * from reclamation where " + searchby + " like '%" + value + "%'";

        ObservableList<Reclamation> list = FXCollections.observableArrayList();
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rst = ste.executeQuery(sql);
            while (rst.next()) {//parcourir le resultset
                list.add(new Reclamation(rst.getInt("id"), rst.getInt("id_membre"), rst.getInt("id_echange"), rst.getString("titre"),rst.getString("Description"), rst.getDate("Date_rec"), rst.getInt("etat")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public ObservableList<Reclamation> recherchedate(String searchby) {
        String sql = "select * from reclamation where " + searchby + " order by Date_rec desc" ;

        ObservableList<Reclamation> list = FXCollections.observableArrayList();
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rst = ste.executeQuery(sql);
            while (rst.next()) {//parcourir le resultset
                list.add(new Reclamation(rst.getInt("id"), rst.getInt("id_membre"), rst.getInt("id_echange"), rst.getString("titre"),rst.getString("Description"), rst.getDate("Date_rec"), rst.getInt("etat")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

public int Countdate(String searchby) {
        
           
        ObservableList<Reclamation> list = FXCollections.observableArrayList();
          int resultat=0;
        try {
             String sql = "SELECT COUNT(*) FROM  `reclamation`  WHERE DATEDIFF(SYSDATE(),Date_rec)>1";
       
            ste=mc.prepareStatement(sql);
            ResultSet rst = ste.executeQuery(sql);
           
             while(rst.next()){
                resultat=rst.getInt("COUNT(*)");
             }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return resultat;
    }
}
