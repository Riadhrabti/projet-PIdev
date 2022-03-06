/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Riadh
 */
public class Reclamation {
    
    public int id,id_membre,id_echange;
    public String titre,Description;
    public Date Date_rec;
    public int etat;

    public Reclamation(int id, String titre, String Description) {
        this.id = id;
        this.titre = titre;
        this.Description = Description;
    }

    public Reclamation(int id) {
        this.id = id;
    }
    

    public Reclamation() {
    }

    public Reclamation(int id, int id_membre, int id_echange, String titre, String Description, Date Date_rec, int etat) {
        this.id = id;
        this.id_membre = id_membre;
        this.id_echange = id_echange;
        this.titre = titre;
        this.Description = Description;
        this.Date_rec = Date_rec;
        this.etat = etat;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public int getId_echange() {
        return id_echange;
    }

    public void setId_echange(int id_echange) {
        this.id_echange = id_echange;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDate_rec() {
        return Date_rec;
    }

    public void setDate_rec(Date Date_rec) {
        this.Date_rec = Date_rec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", id_membre=" + id_membre + ", id_echange=" + id_echange + ", titre=" + titre + ", Description=" + Description + ", Date_rec=" + Date_rec + ", etat=" + etat + '}';
    }

    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Reclamation(int id, int etat) {
        this.id = id;
        this.etat = etat;
    }

    public Reclamation(int id, String titre, int etat) {
        this.id = id;
        this.titre = titre;
        this.etat = etat;
    }
    
    
}
