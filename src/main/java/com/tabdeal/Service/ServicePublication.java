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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public void ajouter(Publication t) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date_publication = new Date(System.currentTimeMillis()) ;
        

        String req = "INSERT INTO `publication` (`id`, `titre`, `date`, `description`, `like`, `dislike`, `id_categorie`, `dislike`) VALUES (" + t.getId() + "," + t.getTitre() + "," + format.format(date_publication).toString() + "," + t.getDescription() + "," + t.getLike() + "," + t.getDislike() + "," + t.getId_categorie() + "," + t.getId_user() + ")";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("publication créé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
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
        String req = "update publication set titre=?, date=? ,description=? , id_categorie=? ,  where id=?;";
        try {
            pste = conn.prepareStatement(req);
            pste.setString(1, t.getTitre());
            pste.setString(2, t.getDate());
            pste.setString(3, t.getDescription());
            pste.setInt(4, t.getId_categorie());
            

            pste.executeUpdate();
            System.out.println("publication créée");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public List<Publication> readAll() {
        List<Publication> publications = new ArrayList<>();
        String req = "SELECT * FROM `publication`";

        try {
//            pste = conn.prepareStatement(req);
//            ResultSet rs = pste.executeQuery();

            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);

            while (rs.next()) {
                Publication p = new Publication();
                p.setId(rs.getInt("id"));
                p.setTitre(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setDate(rs.getString(4));
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
