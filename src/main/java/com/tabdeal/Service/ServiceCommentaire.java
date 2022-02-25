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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SBS
 */
public class ServiceCommentaire implements InterfaceService <Commentaire> {
    private Connection con;
    private Statement ste;
    private PreparedStatement pste;

    public ServiceCommentaire() {
        con = DataBase.getInstance().getConnection();

   
    }

    @Override
    public void ajouter(Commentaire t)  {
        String req = "INSERT INTO `publication` (`id`, `id_user`, `id_publication`, `commentaire`, `date`) VALUES (" + t.getId()+ "," + t.getId_user() + "," + t.getId_publication()+ "," + t.getCommentaire() + "," + t.getDate() + ")";
    
        try {
            ste = con.createStatement();
            ste.executeUpdate(req);
            System.out.println("commentaire créé");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommentaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(Commentaire t)  {
        String req = "delete from commentaire where id=?;";
        try {
            pste = con.prepareStatement(req);

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
            pste = con.prepareStatement(req);
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
    public List<Commentaire> readAll()  {
        List<Commentaire> commentaires = new ArrayList<>();
        String req = "SELECT * FROM `commentaire`";

        try {
//            pste = conn.prepareStatement(req);
//            ResultSet rs = pste.executeQuery();

            ste = con.createStatement();
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
