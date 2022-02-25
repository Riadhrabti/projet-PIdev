/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.Entite;

/**
 *
 * @author SBS
 */
public class Commentaire {

    private int id;

    private int id_user;
    private int id_publication;

    private String commentaire;
    private String date;

    public Commentaire(int id, int id_user, int id_publication, String commentaire, String date) {
        this.id = id;
        this.id_user = id_user;
        this.id_publication = id_publication;
        this.commentaire = commentaire;
        this.date = date;
    }

    public Commentaire() {
        
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_publication() {
        return id_publication;
    }

    public void setId_publication(int id_publication) {
        this.id_publication = id_publication;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    
    
    
}
