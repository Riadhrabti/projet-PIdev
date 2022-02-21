/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_dev.services;

import pi_dev.entities.boost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pi_dev.utils.MyConnection;

/**
 *
 * @author Msi
 */
public class BoostService {
    
          Connection cn2;
    Statement st;
        public BoostService() {
        cn2 = MyConnection.getInstance().getCnx();
            
            }
    
         public void add_boost(boost b) {
        try {
            PreparedStatement pst;
            String requete1;
            requete1 = "INSERT INTO boost (Type_boost, Prix_boost) VALUES (?,?)";
            pst = cn2.prepareStatement(requete1);
            pst.setString(1, b.getType_boost());
            pst.setFloat(2, b.getPrix_boost());
            System.out.println(pst);

            

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("errreur dans l'ajout de l'offre_emploi "+ex.getMessage());
        }
         } 
           


         

public void delete_boost(int id) {
        try {

            String reqDel = "DELETE FROM boost WHERE Id_boost=? ";
            PreparedStatement pst = cn2.prepareStatement(reqDel);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
        

    }

        public ArrayList<boost> displayAll() {
        

        ArrayList<boost> list = new ArrayList<>();

        try {

            String requete3 = "SELECT * FROM boost ";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                boost o = new boost();
                o.setId_boost(rs.getInt("Id_boost"));
                o.setType_boost(rs.getString("Type_boost"));
                o.setPrix_boost(rs.getFloat("Prix_boost"));

                list.add(o);
       

            }

        } catch (SQLException ex) {
            System.out.println("erreur displayAllOffre_emploi" +ex.getMessage());
        }
        return list;

    }
        public void update(boost o, int id) {
        try {
            PreparedStatement pst;
            String reqUpdate = "UPDATE boost SET Type_boost=? ,Prix_boost=?  where Id_boost=? ";

            PreparedStatement preparedStatement = cn2.prepareStatement(reqUpdate);
            pst = cn2.prepareStatement(reqUpdate);
            
            pst.setString(1, o.getType_boost());
            pst.setFloat(2, o.getPrix_boost());
            pst.setInt(3, id);
           

        
            pst.executeUpdate();
            
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    
}
