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
public class Favoris {
    private int id ;
    private int id_user;
    private int id_categorie;

    public Favoris(int id, int id_user, int id_categorie) {
        this.id = id;
        this.id_user = id_user;
        this.id_categorie = id_categorie;
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

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "Favoris{" + "id=" + id + ", id_user=" + id_user + ", id_categorie=" + id_categorie + '}';
    }
    
    
    
}
