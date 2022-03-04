/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Service;

import com.tabdeal.Entite.Commentaire;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SBS
 */
public class ServiceCommentaire implements InterfaceService <Commentaire> {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;

    public ServiceCommentaire() {
        conn = DataBase.getInstance().getConnection();

   
    }

    @Override
    public void ajouter(Commentaire t)  {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_commentaire = new Date(System.currentTimeMillis()) ;
        
        PreparedStatement ps;
        
        try {
            String req = "INSERT INTO `commentaire` ( `id_user`, `id_publication`, `commentaire`, `date`) VALUES (?,?,?,?)";
            ps= conn.prepareStatement(req);
            
             ps.setInt(1, t.getId_user());
             ps.setInt(2, t.getId_publication());
             ps.setString(3, t.getCommentaire());
             ps.setString(4, date_commentaire.toString());
             
             ps.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(Commentaire t)  {
        String req = "delete from commentaire where id=?;";
        try {
            pste = conn.prepareStatement(req);

            pste.setInt(1, t.getId());

            pste.executeUpdate();
            System.out.println("commentaire Supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Commentaire t)  {
        String req = "update commentaire set commentaire=?, date=?  where id=?;";
        try {
            pste = conn.prepareStatement(req);
            pste.setString(1, t.getCommentaire());
            pste.setString(2, t.getDate());
            

            pste.executeUpdate();
            System.out.println("publication créée");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ObservableList<Commentaire> readAll()  {
        ObservableList<Commentaire> commentaires = FXCollections.observableArrayList();
        String req = "SELECT * FROM `commentaire`";

        try {
//            pste = conn.prepareStatement(req);
//            ResultSet rs = pste.executeQuery();

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);

            while (rs.next()) {
                Commentaire p = new Commentaire();
                p.setId(rs.getInt("id"));
                p.setId_user(rs.getInt(2));
                p.setId_publication(rs.getInt(3));
                p.setCommentaire(rs.getString(4));
                p.setDate(rs.getString("commentaire"));
                

                commentaires.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commentaires;
    }
    
}
