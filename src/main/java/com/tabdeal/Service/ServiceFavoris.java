/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Service;

import com.tabdeal.Entite.Favoris;
import com.tabdeal.InterfaceService.InterfaceService;
import com.tabdeal.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SBS
 */
public class ServiceFavoris implements InterfaceService <Favoris>  {
    private Connection con;
    private Statement ste;
    private PreparedStatement pste;

    public ServiceFavoris() {
        con = DataBase.getInstance().getConnection();
        
    }
    

    @Override
    public void ajouter(Favoris t)  {
        String req = "INSERT INTO `favoris` (`id`, `id_user`, `id_categorie`) VALUES (" + t.getId()+ "," + t.getId_user() + "," + t.getId_categorie()+ ")";
    
        try {
            ste = con.createStatement();
            ste.executeUpdate(req);
            System.out.println("favoris créé");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavoris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(Favoris t)  {
        String req = "delete from favoris where id=?;";
        try {
            pste = con.prepareStatement(req);

            pste.setInt(1, t.getId());

            pste.executeUpdate();
            System.out.println("favoris Supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavoris.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Favoris t)  {
        return true;
    }

    @Override
    public List<Favoris> readAll()  {
        return null;
        
    }
    
    public void getFavoriesCategoriesByUser(int id_user){
        String req = "Select * from catégorie as c inner join favoris as f on c.id=f.id_categorie where f.id_user="+ id_user +";"   ;
        try {
            ste = con.createStatement();
            ResultSet rs=ste.executeQuery(req);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceFavoris.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void getUsersByCategorie (int id_categorie){
        
    }
    
}
