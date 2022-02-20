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
public class EchangeService {
     Connection mc;
    PreparedStatement ste;
    
    public EchangeService(){
    mc=ConnexionBD.getInstance().getCnx();
}
    
    public void ajouterEchange(Echange e){
    String sql="insert into Echange(id_echange,id_membre1,id_membre2,id_article1,id_article2)values(?,?,?,?,?)";
    try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1,e.getId_echange());
        ste.setInt(2,e.getId_membre1());
         ste.setInt(3,e.getId_membre2());
          ste.setInt(4,e.getId_article1());
          ste.setInt(5,e.getId_article2());
        ste.executeUpdate();
        System.out.println("echange  ajouté");
        
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    public void UpdateEchange(Echange e ){
        String sql ="update Echange set id_membre1=? ,id_membre2=?,id_article1=?,id_article2=? where id_echange = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(5,e.getId_echange());
        ste.setInt(1,e.getId_membre1());
         ste.setInt(2,e.getId_membre2());
          ste.setInt(3,e.getId_article1());
          ste.setInt(4,e.getId_article2());
            ste.executeUpdate();
            System.out.println("echange modifie");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public List<Echange> afficherEchange(){
        List<Echange> echanges = new ArrayList<>();
        String sql = "select * from Echange";
        try {
            ste = mc.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Echange e = new Echange();
                e.setId_echange(rs.getInt("1"));
                e.setId_membre1(rs.getInt("2"));
                e.setId_membre2(rs.getInt("3"));
                e.setId_article1(rs.getInt("4"));
                e.setId_article2(rs.getInt("5"));
                
                echanges.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return echanges;

        
    }
        public void DeleteEchange(Echange e ){
        
        String sql ="delete from Echange where id_echange = ?";
        try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1, e.getId_echange());
        ste.executeUpdate();
        System.out.println("echange supprime");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
}
