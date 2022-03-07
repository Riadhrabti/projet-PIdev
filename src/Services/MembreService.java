/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Riadh
 */
import Utils.Database;
import Entities.Membre;
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
    mc=Database.getInstance().getCnx();
}
public void ajouterMembre(Membre m){
    String sql="INSERT INTO user( nom, prenom, email, login, mdp, adresse, phone, Date_naissance, sexe, rating, nb_art_ech, nb_art_pos) VALUES "
            + "(?,?,?,?,?,?,?,?,?,?,?,?)";
    try{
        ste=mc.prepareStatement(sql);
        ste.setString(1,m.getNom());
        ste.setString(2,m.getPrenom());
        ste.setString(3,m.getEmail());
        ste.setString(4,m.getLogin());
        ste.setString(5,m.getMdp());
        ste.setString(6,m.getAdresse());
        ste.setString(7,m.getNum_tel());
        ste.setDate(8,m.getDate_naissance());
        ste.setString(9,m.getSexe());
        ste.setFloat(10,m.getRating());
        ste.setInt(11,m.getNb_articles_posté());
        ste.setInt(12,m.getNb_articles_echangées());
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
        String sql="select * from Membre ";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Membre m = new Membre();
                m.setId(rs.getInt("id_membre"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
                m.setEmail(rs.getString("email"));
                m.setLogin(rs.getString("login"));
                m.setMdp(rs.getString("mdp"));
                m.setAdresse(rs.getString("adresse"));
                m.setNum_tel(rs.getString("num_tel"));
                m.setDate_naissance(rs.getDate("Date_naissance"));
                m.setSexe(rs.getString("Sexe"));
                m.setRating(rs.getFloat("rating"));
                m.setNb_articles_posté(rs.getInt("nb_articles_posté"));
                m.setNb_articles_echangées(rs.getInt("Nb_articles_echangées"));
                
                membres.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return membres;
    
}public void DeletePersonne(Membre m ){
        
        String sql ="delete from membre where id_membre = ?";
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

