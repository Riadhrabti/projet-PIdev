package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import Entities.Categorie;
import Utils.MyConnection;

/**
 *
 * @author Msi
 */
public class likeDislike {

    Connection cn2;
    Statement st;
            public likeDislike() {
            cn2 = MyConnection.getInstance().getCnx();
            
            }

    public void addAppreciation(int Id_user, int Id_article) {
        cn2 = MyConnection.getInstance().getCnx();
        try {
            
            PreparedStatement pst;
            String requete1;
            requete1 = "INSERT INTO `like` (like.Id_user, like.Id_article) VALUES (?,?)";
            pst = cn2.prepareStatement(requete1);
            pst.setInt(1,Id_user);
            pst.setInt(2, Id_article);
            System.out.println(pst);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger("errreur dans l'ajout du like " + ex.getMessage());
        }

    }

    public void removeLike(int Id_user, int Id_article) {
        try {

            String reqDel = "DELETE FROM apprecier WHERE Id_user=? AND Id_article=?";
            PreparedStatement pst = cn2.prepareStatement(reqDel);
            pst.setInt(1, Id_user);
            pst.setInt(2, Id_article);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }



    public int countLike(int Id_article) {

        int result = 0;
        try {

            String requete3 = "SELECT COUNT(*) FROM `like` WHERE like.Id_article="+Id_article;
            Statement pst2 = cn2.createStatement();
            
            ResultSet rs = pst2.executeQuery(requete3);
            while(rs.next()){
            result = rs.getInt(1);
            
           // System.out.print(result);
            }
        } catch (SQLException ex) {
            System.out.println("erreur count likes" + ex.getMessage());
        }
       return result ; 

    }

}