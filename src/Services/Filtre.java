package Services;

import Utils.MyConnection;
import java.sql.*;
import java.util.ArrayList;

public class Filtre {

    private Connection conn;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst;

    public Filtre() {
        conn = MyConnection.getInstance().getCnx();
    }

    public ArrayList<String> FiltreLieu(int id) {
        ArrayList<String> liste = new ArrayList<String>();
        String req = "SELECT nom_lieu , article.id_lieu  ,article.titre\n"
                + "FROM article \n"
                + "INNER JOIN article \n"
                + "on categorie.id_lieu=article.id_lieu \n"
                + "WHERE article.id_lieu=" + id;

        try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            while (rst.next()) {
                liste.add("titre : " + rst.getString("titre") + " " + "lieu : " + rst.getString("nom_lieu"));
                
            }

        } catch (SQLException ex) {
            System.out.print("message" + ex.getMessage());
        }
      return liste;
    }
    public ArrayList<String> Chercher_Article(String ch) {
       ArrayList<String> liste = new ArrayList<String>();  
       String req = "SELECT id , Titre FROM article where Titre like ' "+ch+"'" ;
       try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            while (rst.next()) {
                liste.add("id : " + rst.getString("id") + " " + "libelle : " + rst.getString("libelle"));
                
            }

        } catch (SQLException ex) {
            System.out.print("message" + ex.getMessage());
        }
      return liste;
    }
}