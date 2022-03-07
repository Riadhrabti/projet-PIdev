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
public class Echange {
    public int id_echange,id_membre1,id_membre2,id_article1,id_article2,etat;

    public Echange() {
    }

    public Echange(int id_echange, int id_membre1, int id_membre2, int id_article1, int id_article2,int etat) {
        this.id_echange = id_echange;
        this.id_membre1 = id_membre1;
        this.id_membre2 = id_membre2;
        this.id_article1 = id_article1;
        this.id_article2 = id_article2;
        this.etat = etat;
    }

    public Echange(int id_echange, int etat) {
        this.id_echange = id_echange;
        this.etat = etat;
    }
    

    public int getId_echange() {
        return id_echange;
    }

    public void setId_echange(int id_echange) {
        this.id_echange = id_echange;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId_membre1() {
        return id_membre1;
    }

    public void setId_membre1(int id_membre1) {
        this.id_membre1 = id_membre1;
    }

    public int getId_membre2() {
        return id_membre2;
    }

    public void setId_membre2(int id_membre2) {
        this.id_membre2 = id_membre2;
    }

    public int getId_article1() {
        return id_article1;
    }

    public void setId_article1(int id_article1) {
        this.id_article1 = id_article1;
    }

    public int getId_article2() {
        return id_article2;
    }

    public void setId_article2(int id_article2) {
        this.id_article2 = id_article2;
    }

    @Override
    public String toString() {
        return "Echange{" + "id_echange=" + id_echange + ", id_membre1=" + id_membre1 + ", id_membre2=" + id_membre2 + ", id_article1=" + id_article1 + ", id_article2=" + id_article2 + ", etat=" + etat + '}';
    }

   

    public Echange(int id_membre1, int id_membre2, int id_article1, int id_article2) {
        this.id_membre1 = id_membre1;
        this.id_membre2 = id_membre2;
        this.id_article1 = id_article1;
        this.id_article2 = id_article2;
       
    }

    
    public Echange(int id_echange) {
        this.id_echange = id_echange;
    }

    
    
    
}

    
    
    


