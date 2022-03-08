/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author SBS
 */
public class Publication {
    private int id;
    private int like;
    private int dislike;
    private int id_categorie;
    private int id_user; 
    private String description;
    private String date;
    private String titre;

    public Publication(int id_categorie ,String description, String date, String titre) {
        
        this.description = description;
        this.date = date;
        this.titre = titre;
        this.like = 0;
        this.dislike = 0;
        this.id_categorie= id_categorie;
                
    }

    public Publication(String description, String titre) {
        this.titre= titre;
        this.description=description;
        this.like = 0;
        this.dislike = 0;
        
        
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Publication() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", like=" + like + ", dislike=" + dislike + ", description=" + description + ", date=" + date + ", titre=" + titre + '}';
    }
   
    
    
    
}
