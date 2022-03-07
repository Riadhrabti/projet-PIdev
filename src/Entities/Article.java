/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Riadh
 */
import java.sql.Date;

/**
 *
 * @author Riadh
 */
public class Article {
    public int id,id_proprietaire;
    public boolean disponibilite,boost,echange_cross_cat;
    public Date Date_publication;
    public String etat,Description,titre;
    
    public Article(){
    
    
    
}

    public Article(String Description, String titre) {
        this.Description = Description;
        this.titre = titre;
    }
    

    public Article(int id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public Article(int id, boolean disponibilite, String titre) {
        this.id = id;
        this.disponibilite = disponibilite;
        this.titre = titre;
    }

    public Article(int id, int id_proprietaire, boolean disponibilite, boolean boost, boolean echange_cross_cat, Date Date_publication, String etat, String Description, String titre) {
        this.id = id;
        this.id_proprietaire = id_proprietaire;
        this.disponibilite = disponibilite;
        this.boost = boost;
        this.echange_cross_cat = echange_cross_cat;
        this.Date_publication = Date_publication;
        this.etat = etat;
        this.Description = Description;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    public boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public boolean getBoost() {
        return boost;
    }

    public void setBoost(boolean boost) {
        this.boost = boost;
    }

    public boolean getEchange_cross_cat() {
        return echange_cross_cat;
    }

    public void setEchange_cross_cat(boolean echange_cross_cat) {
        this.echange_cross_cat = echange_cross_cat;
    }

    public Date getDate_publication() {
        return Date_publication;
    }

    public void setDate_publication(Date Date_publication) {
        this.Date_publication = Date_publication;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", id_proprietaire=" + id_proprietaire + ", disponibilite=" + disponibilite + ", boost=" + boost + ", echange_cross_cat=" + echange_cross_cat + ", Date_publication=" + Date_publication + ", etat=" + etat + ", Description=" + Description + ", titre=" + titre + '}';
    }

    void getTitre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void getDescription(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String disponibilite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
