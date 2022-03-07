/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.Database;
import Entities.Echange;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Riadh
 */
public class EchangeService {
     Connection mc;
    PreparedStatement ste;
    PreparedStatement ste1;
    
    public EchangeService(){
    mc=Database.getInstance().getCnx();
}
    
    public void ajouterEchange(Echange e){
    String sql="insert into echange(id_membre1,id_membre2,id_article1,id_article2,etat)values(?,?,?,?,?)";
    try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1,e.getId_membre1());
         ste.setInt(2,e.getId_membre2());
          ste.setInt(3,e.getId_article1());
          ste.setInt(4,e.getId_article2());
          ste.setInt(5,e.getEtat());
        ste.executeUpdate();
        System.out.println("echange  ajouté");
        
    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }
}
    public void UpdateEchange(Echange e ){
        String sql ="update Echange set id_membre1=? ,id_membre2=?,id_article1=?,id_article2=?,etat=? where id_echange = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(6,e.getId_echange());
        ste.setInt(1,e.getId_membre1());
         ste.setInt(2,e.getId_membre2());
          ste.setInt(3,e.getId_article1());
          ste.setInt(4,e.getId_article2());
          ste.setInt(5,e.getEtat());
            ste.executeUpdate();
            System.out.println("echange modifie");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void UpdateEchange1(Echange e ){
        String sql ="update Echange set etat=? where id_echange = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(2,e.getId_echange());
          ste.setInt(1,e.getEtat());
            ste.executeUpdate();
            System.out.println("echange modifie");
            ste.close();
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
        
        ResultSet rst ;
        public void UpdateEchange2(int i){
        String req1 ="SELECT * FROM `echange` WHERE id_echange = "+i;
        //String req1 ="update Echange set etat=? where id_echange = ? ";
        int idArticle1 =0;
        int idArticle2=0;
        int idprop1=0;
        int idprop2=0;
        try {
            ste=mc.prepareStatement(req1);
            rst = ste.executeQuery();
            while (rst.next()){
            idArticle1=rst.getInt("id_article1");
            idArticle2= rst.getInt("id_article2");
            System.out.print(idArticle1);
            System.out.print(idArticle2);
            }
            String req2="SELECT * FROM `article` WHERE article.id="+idArticle1;
            ste=mc.prepareStatement(req2);
            rst = ste.executeQuery();
             while (rst.next()){
            idprop1=rst.getInt("id_proprietaire");
            System.out.print(idprop1);
            }
            
            
            String req3="SELECT * FROM `article` WHERE article.id="+idArticle2;
             ste=mc.prepareStatement(req3);
            rst = ste.executeQuery();
             while (rst.next()){
            idprop2=rst.getInt("id_proprietaire");
            System.out.print(idprop2);
            }
            
            String req4="update `article` set article.id_proprietaire=? WHERE article.id=? ";
            ste=mc.prepareStatement(req4);
            ste.setInt(2,idArticle2);
            ste.setInt(1,idprop1);
            ste.executeUpdate();
            
            String req5="update `article` set article.id_proprietaire=? WHERE article.id=? ";
            ste1=mc.prepareStatement(req5);
            ste1.setInt(1,idprop2);
            ste1.setInt(2,idArticle1);
            ste1.executeUpdate();
            
            
             
            
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                
    }
        
        
     public ObservableList<Echange> afficherEchange(){
        ObservableList<Echange> echanges = FXCollections.observableArrayList();
        String sql = "select * from Echange";
        try {
            ste = mc.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                Echange e = new Echange();
                e.setId_echange(rs.getInt("id_echange"));
                e.setId_membre1(rs.getInt("id_membre1"));
                e.setId_membre2(rs.getInt("id_membre2"));
                e.setId_article1(rs.getInt("id_article1"));
                e.setId_article2(rs.getInt("id_article2"));
                e.setEtat(rs.getInt("etat"));
                
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
