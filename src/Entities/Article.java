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
import java.util.Date;


public class Article {
    private int id ;
    private int id_utilisateur ; 
    private int id_categorie ; 
    private String Titre ;
    private String Description; 
    private String gouvernorat ; 
    private int Boost; 

    public Article(int id, int id_utilisateur, int id_categorie, String Titre, String Description, String gouvernorat, int Boost) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.id_categorie = id_categorie;
        this.Titre = Titre;
        this.Description = Description;
        this.gouvernorat = gouvernorat;
        this.Boost = Boost;
    }

    public Article(int id_utilisateur, int id_categorie, String Titre, String Description, String gouvernorat, int Boost) {
        this.id_utilisateur = id_utilisateur;
        this.id_categorie = id_categorie;
        this.Titre = Titre;
        this.Description = Description;
        this.gouvernorat = gouvernorat;
        this.Boost = Boost;
    }

    public Article() {
    }
    

    public int getId() {
        return id;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getTitre() {
        return Titre;
    }

    public String getDescription() {
        return Description;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public int getBoost() {
        return Boost;
    }

   
    
}
