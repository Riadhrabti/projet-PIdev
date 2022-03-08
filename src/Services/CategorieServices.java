
package Services;

import Entities.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import Utils.MyConnection;

public class CategorieServices {
    Connection cn2;
    Statement st;
        public CategorieServices() {
        cn2 = MyConnection.getInstance().getCnx();
            
            }
    
         public void add_Categorie(Categorie c) {
        try {
            PreparedStatement pst;
            String requete1;
            requete1 = "INSERT INTO Categorie (Type_Categorie, Id_Categorie) VALUES (?,?)";
            pst = cn2.prepareStatement(requete1);
            pst.setInt(1, c.getId_cat());
            pst.setString(2, c.getType_cat());
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

        public ArrayList<Categorie> displayAll() {
        

        ArrayList<Categorie> list = new ArrayList<>();

        try {

            String requete3 = "SELECT * FROM boost ";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId_cat(rs.getInt("Id_Categorie"));
                c.setType_cat(rs.getString("Type_Categorie"));
               
                list.add(c);
       

            }

        } catch (SQLException ex) {
            System.out.println("erreur displayAllOffre_emploi" +ex.getMessage());
        }
        return list;

    }
        public void update(Categorie c, int id) {
        try {
            PreparedStatement pst;
            String reqUpdate = "UPDATE boost SET Type_boost=? ,Prix_boost=?  where Id_boost=? ";

            PreparedStatement preparedStatement = cn2.prepareStatement(reqUpdate);
            pst = cn2.prepareStatement(reqUpdate);
            
            pst.setString(1, c.getType_cat());
            pst.setFloat(2, c.getId_cat());
            pst.setInt(3, id);
           

        
            pst.executeUpdate();
            
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    
}


