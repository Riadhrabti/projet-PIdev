/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author User
 */
public class User {
   private int id ;
   private String nom;
   private String prenom;
   private String email;
   private String login;
   private String mdp;
   private String adr;
   private String phone;
   private Date date_naiss;
   private String sexe;
   private String role;
   private String image;
   private float rating;
   private int nb_art_ech;
   private int nb_art_pos;
   
   
    public User() {
    }

    public User(int id, String nom, String prenom, String adr, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adr = adr;
        this.phone = phone;
    }

    public User(int id, String nom, String prenom, String email, String login, String mdp, String adr, String phone, Date date_naiss, String sexe, float rating, int nb_art_ech, int nb_art_pos, String role, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.adr = adr;
        this.phone = phone;
        this.date_naiss = date_naiss;
        this.sexe = sexe;
        this.rating = rating;
        this.nb_art_ech = nb_art_ech;
        this.nb_art_pos = nb_art_pos;
        this.role = role;
        this.image = image;
    }

    public User(int id) {
        this.id = id;
    }


    public User(int id, String nom, String prenom, String email, String login, String mdp, String adr, String phone, Date date_naiss, String sexe, String role, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.adr = adr;
        this.phone = phone;
        this.date_naiss = date_naiss;
        this.sexe = sexe;
        this.role = role;
        this.image = image;
    }

    public User(int id, String nom, String prenom, String email, String login, String mdp, String adr, String phone, Date date_naiss, String sexe, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.adr = adr;
        this.phone = phone;
        this.date_naiss = date_naiss;
        this.sexe = sexe;
        this.image = image;
    }

    public User(int id, String nom, String prenom, String adr) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adr = adr;
    }

    public User(String nom, String prenom, String email, String login, String mdp, String adr, String phone, Date date_naiss, String sexe, String role, String image) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.adr = adr;
        this.phone = phone;
        this.date_naiss = date_naiss;
        this.sexe = sexe;
        this.role = role;
        this.image = image;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNb_art_ech() {
        return nb_art_ech;
    }

    public void setNb_art_ech(int nb_art_ech) {
        this.nb_art_ech = nb_art_ech;
    }

    public int getNb_art_pos() {
        return nb_art_pos;
    }

    public void setNb_art_pos(int nb_art_pos) {
        this.nb_art_pos = nb_art_pos;
    }

   
    @Override
    public String toString() {
        String user="";
        System.out.println("******************");
        user+="l'identifiant de user est "+id ;
        user+="\n le nom de user est  "+nom;
        user+="\n le prenom "+prenom;
        user+="\n l'email "+email;
        user+="\n le login "+login;
        user+="\n le mdp  "+mdp;
        user+="\n l'adresse "+adr;
        user+="\n le numéro de téléphone "+phone;
        user+="\n la date de naissance "+date_naiss;
        user+="\n le sexe  "+sexe;
         user+="\n le sexe  "+rating;
          user+="\n le sexe  "+nb_art_ech;
           user+="\n le sexe  "+nb_art_pos;
        user+="\n le role de l'utilisateur "+role;
         user+="\n le sexe  "+image;

        return user;
        
    }
   
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
        
   
   
}
