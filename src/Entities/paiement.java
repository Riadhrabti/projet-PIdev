/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Msi
 */
public class paiement {
    int id_paiement;
    int id_article ;
    int id_user ;
    String type_carte ;
    Date date_expiration ;
    int nbre_jours;
    int id_carte ;

    @Override
    public String toString() {
        return "paiement{" + "id_paiement=" + id_paiement + ", id_article=" + id_article + ", id_user=" + id_user + ", type_carte=" + type_carte + ", date_expiration=" + date_expiration + ", nbre_jours=" + nbre_jours + ", id_carte=" + id_carte + '}';
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setType_carte(String type_carte) {
        this.type_carte = type_carte;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public void setNbre_jours(int nbre_jours) {
        this.nbre_jours = nbre_jours;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public int getId_paiement() {
        return id_paiement;
    }

    public int getId_article() {
        return id_article;
    }

    public int getId_user() {
        return id_user;
    }

    public String getType_carte() {
        return type_carte;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public int getNbre_jours() {
        return nbre_jours;
    }

    public int getId_carte() {
        return id_carte;
    }
    
    
    
    
}
