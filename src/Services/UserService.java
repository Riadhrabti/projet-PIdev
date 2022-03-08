/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.MD5Utils;
import Entities.User;
import Utils.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class UserService implements IService<User>{
 private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rst ;
    
    public UserService() {
        conn = Database.getInstance().getConn();
    }

    
    
    public void ajouterUersonne(User u) {
        String req = "insert into user (nom,prenom) values ('" + u.getNom() + "','" + u.getPrenom() + "')";

        try {
            ste = conn.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public boolean add(User t) {
        String req = "insert into user(nom,prenom,email,login,mdp,adresse,phone,date_naiss,sexe,role,image)values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(req);
            //donner les données
		
		pst.setString(1,t.getNom());
		pst.setString(2,t.getPrenom());
                pst.setString(3,t.getEmail());
		pst.setString(4,t.getLogin());
                pst.setString(5,MD5Utils.cryptage(t.getMdp()));
                pst.setString(6,t.getAdr());
                pst.setString(7,t.getPhone());
                pst.setDate(8, (Date) t.getDate_naiss());
                pst.setString(9,t.getSexe());
		pst.setString(10, t.getRole());
                pst.setString(11, t.getImage());
		pst.executeUpdate();
                 return true;
                  } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    @Override
    public ObservableList<User> read() {
        ObservableList<User> users = FXCollections.observableArrayList();
        
        String req = "SELECT * FROM user";
        
        try {
            
            ste = conn.createStatement();
             rst = ste.executeQuery(req);
            
            while(rst.next()){
            User u= new User();
                u.setId(rst.getInt("id_user"));
                u.setNom(rst.getString(2));
                u.setPrenom(rst.getString(3));
                u.setEmail(rst.getString(4));
		u.setLogin(rst.getString(5));
                u.setMdp(rst.getString(6));
                u.setAdr(rst.getString(7));
                u.setPhone(rst.getString(8));
                u.setDate_naiss(rst.getDate(9));
                u.setSexe(rst.getString(10));
                u.setRating(rst.getFloat(11));
                u.setNb_art_ech(rst.getInt(12));
                u.setNb_art_pos(rst.getInt(13));
                u.setRole(rst.getString(14));
                u.setImage(rst.getString(15));

		
                users.add(u);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }

    @Override
    public boolean update(User t) {
        String req="update user set  nom=?, prenom=?, email=? ,login=? ,mdp=?, adresse=?, phone=?, date_naiss=?, sexe=?,image=? where id_user=?;";
        try {
        //creer un Prepared statement
		pst = conn.prepareStatement(req);
                pst.setString(1,t.getNom());
                pst.setString(2,t.getPrenom());
                pst.setString(3,t.getEmail());
		pst.setString(4,t.getLogin());
                pst.setString(5,MD5Utils.cryptage(t.getMdp()));
                pst.setString(6,t.getAdr());
                pst.setString(7,t.getPhone());
                pst.setDate(8, (Date) t.getDate_naiss());
                pst.setString(9,t.getSexe());
		
                pst.setString(10, t.getImage());
                pst.setInt(11, t.getId());
                   pst.executeUpdate();
             return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(User t) {
        String req = "delete from user where id_user = ?;";
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("ok");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
     public boolean checkLogin(String login) {
        try {
            String requete3 = "SELECT * FROM user WHERE login=? ";
            pst = conn.prepareStatement(requete3);
            pst.setString(1, login);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("login already used");
                   return false;
            }
        } catch (SQLException ex) {
            System.out.println("probleme checklogin"+ex.getMessage());
        }
         return true;
    }
    
     
     public User getUserbyLoginPass(String login, String pass) {

        String req = "select * from user where login = '" + login + "' and mdp = '" + MD5Utils.cryptage(pass) + "'";

        User u = new User();
        try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            if (rst.first()) {
                u = new User(rst.getInt("id_user"), rst.getString("nom"), rst.getString("prenom"), rst.getString("email"),rst.getString("login"), rst.getString("mdp"),rst.getString("adresse"),rst.getString("phone"), rst.getDate("date_naiss"),rst.getString("sexe"),rst.getString("role"),rst.getString("image"));
            }
            System.out.println(u);

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
     public ObservableList<User> recherche(String searchby, String value) {
        String req = "select * from user where " + searchby + " like '%" + value + "%'";

        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            while (rst.next()) {//parcourir le resultset
                list.add(new User(rst.getInt("id_user"), rst.getString("nom"), rst.getString("prenom"), rst.getString("email"),rst.getString("login"), rst.getString("mdp"),rst.getString("adresse"),rst.getString("phone"), rst.getDate("date_naiss"),rst.getString("sexe"),rst.getString("role"),rst.getString("image")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

     
     public ObservableList<User> tri(String value) {
        String req = "select * from user order by " + value;

        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            while (rst.next()) {//parcourir le resultset
                list.add(new User(rst.getInt("id_user"), rst.getString("nom"), rst.getString("prenom"), rst.getString("email"),rst.getString("login"), rst.getString("mdp"),rst.getString("adresse"),rst.getString("phone"), rst.getDate("date_naiss"),rst.getString("sexe"),rst.getString("role"),rst.getString("image")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

     
 public ObservableList<User> filterRole(String value) {
        String req = "select * from user where role = '" + value + "'";

        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            while (rst.next()) {//parcourir le resultset
               list.add(new User(rst.getInt("id_user"), rst.getString("nom"), rst.getString("prenom"), rst.getString("email"),rst.getString("login"), rst.getString("mdp"),rst.getString("adresse"),rst.getString("phone"), rst.getDate("date_naiss"),rst.getString("sexe"),rst.getString("role"),rst.getString("image")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int rowUSER(){
        ObservableList<User> liste = FXCollections.observableArrayList();
        String req = "SELECT * FROM user";
        int i=0;
        
        try {
            
            ste = conn.createStatement();
            rst = ste.executeQuery(req);
            User user1;
            while (rst.next()){
               i=i+1;
            }
            
            
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
    if (rst != null) {
        try {
            rst.close();
        } catch (SQLException e) { /* Ignored */}
    }
    if (ste != null) {
        try {
            ste.close();
        } catch (SQLException e) { /* Ignored */}
    }
    }
        return i;
        
}
    
    
    
    
     public boolean ResetPassword(String pass, int id) throws SQLException {
        String sql = "UPDATE user SET password=? WHERE id_user=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, MD5Utils.cryptage(pass));
            pst.setInt(2, id);

            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    
}
