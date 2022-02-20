/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.gestion_echange;

import java.util.Date;

/**
 *
 * @author Riadh
 */
public class Membre {
    public int nb_articles_posté,nb_articles_echangées ,id;
    public String nom,prenom,email,login,mdp,adresse,num_tel;
    public float rating;
    public Date Date_naissance;
    
    
    public Membre(){
  
}

    public Membre(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Membre(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Membre(int nb_articles_posté, int nb_articles_echangées, int id, String nom, String prenom, String email, String login, String mdp, String adresse, String num_tel, float rating, Date Date_naissance) {
        this.nb_articles_posté = nb_articles_posté;
        this.nb_articles_echangées = nb_articles_echangées;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.rating = rating;
        this.Date_naissance = Date_naissance;
    }

    public int getNb_articles_posté() {
        return nb_articles_posté;
    }

    public void setNb_articles_posté(int nb_articles_posté) {
        this.nb_articles_posté = nb_articles_posté;
    }

    public int getNb_articles_echangées() {
        return nb_articles_echangées;
    }

    public void setNb_articles_echangées(int nb_articles_echangées) {
        this.nb_articles_echangées = nb_articles_echangées;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getDate_naissance() {
        return Date_naissance;
    }

    public void setDate_naissance(Date Date_naissance) {
        this.Date_naissance = Date_naissance;
    }

    @Override
    public String toString() {
        return "Membre{" + "nb_articles_post\u00e9=" + nb_articles_posté + ", nb_articles_echang\u00e9es=" + nb_articles_echangées + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", mdp=" + mdp + ", adresse=" + adresse + ", num_tel=" + num_tel + ", rating=" + rating + ", Date_naissance=" + Date_naissance + '}';
    }
    
    
}
