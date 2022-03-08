package Entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class user {
    private int id_utilisateur ; 
    private String nom ; 
    private String prenom ; 

    public user(int id_utilisateur, String nom, String prenom) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public user(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
       
}