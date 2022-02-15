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
public class MembreService {
    Connection mc;
    PreparedStatement ste;
    
public MembreService(){
    mc=ConnexionBD.getInstance().getCnx();
}
public void ajouterMembre(Membre m){
    String sql="insert into Membre(nom,prenom)values(?,?)";
    try{
        ste=mc.prepareStatement(sql);
        ste.setString(1,m.getNom());
        ste.setString(2,m.getPrenom());
        ste.executeUpdate();
        System.out.println("membre ajouté");
        
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    public void UpdateMembre(Membre m){
        String sql ="update membre set nom = ? , prenom = ? where id = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(3, m.getId());
            ste.setString(1, m.getNom());
            ste.setString(2, m.getPrenom());
            ste.executeUpdate();
            System.out.println("Membre modifier");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Membre> afficherMembre(){
        List<Membre> membres = new ArrayList<>();
        String sql="select * from Membre";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Membre m = new Membre();
                m.setId(rs.getInt("id"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                membres.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return membres;
    
}public void DeletePersonne(Membre m ){
        
        String sql ="delete from membre where id = ?";
        try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1, m.getId());
        ste.executeUpdate();
        System.out.println("membre supprimer");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
