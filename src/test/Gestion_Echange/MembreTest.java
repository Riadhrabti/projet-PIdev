/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Gestion_Echange;

import Config.Database;
import Controller.MembreService;
import Entity.Membre;
import java.util.Calendar;

/**
 *
 * @author Riadh
 */
public class MembreTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database m = Database.getInstance();
        
        
        MembreService ms =new MembreService();
        java.util.Date date = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        Membre m1= new Membre(1, 2,4, "zz", "ee", "dd", "hh", "kk", "mm","xx", "MM",5.1f, sqlDate);
        //System.out.print(m1);
        Membre m2 = new Membre(1);
        //ms.ajouterMembre(m1);
        ms.DeletePersonne(m2);
                System.out.println(ms.afficherMembre());

       
    }
    
}
