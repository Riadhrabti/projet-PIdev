/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Service;

import com.tabdeal.Entite.Categorie;
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
public class ServiceCategorie implements InterfaceService <Categorie>{
    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;
public ServiceCategorie() {
        conn = DataBase.getInstance().getConnection();

    }


    @Override
    public void ajouter(Categorie t)  {
        String req = "INSERT INTO `categorie` (`id`,`nom`) VALUE ('" + t.getId() + "','" + t.getNom() + "')";
        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Categorie crée");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void ajouter2(Categorie t) {
        String req = "INSERT INTO `catégorie` (`id`,`nom`) VALUE (?,?)";
        try {
            pste = conn.prepareStatement(req);
            pste.setInt(1, t.getId());
            pste.setString(2, t.getNom());
            pste.executeUpdate();
            System.out.println("Catégorie crée");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean delete(Categorie t)  {
        String req = "delete from categorie where id=?;";
        try {
            pste = conn.prepareStatement(req);
            
            pste.setInt(1, t.getId());
            
            pste.executeUpdate();
            System.out.println("Catégorie Supprimé");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public boolean update(Categorie t)  {
        String req ="update publication set nom=?";
         try {
            pste = conn.prepareStatement(req);
            pste.setString(1, t.getNom());
            
            
            pste.executeUpdate();
            System.out.println("Categorie Modifier");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePublication.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }

    @Override
    public List<Categorie> readAll() {
        List<Categorie> categories = new ArrayList<>();
        String req = "SELECT id,nom FROM `catégorie`";
        
        try {
//            pste = conn.prepareStatement(req);
//            ResultSet rs = pste.executeQuery();
            
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                Categorie p = new Categorie();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString(2));
                
                categories.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
        
    }
    

