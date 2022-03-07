/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Gestion_Echange;

import Utils.Database;
import Services.ReclamationService;
import Entities.Reclamation;
import java.util.Calendar;

/**
 *
 * @author Riadh
 */
public class ReclamationTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Database m = Database.getInstance();
        
        
        ReclamationService rs =new ReclamationService();
        java.util.Date date = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Reclamation r = new Reclamation(44,5,4,"hh","gg",sqlDate,1);
        Reclamation r1 = new Reclamation(8);
        //Reclamation r1 = new Reclamation(3,1);
        //rs.ajouterReclamation(r);
        //rs.ajouterReclamation(r1);
        //rs.UpdateArticle(r1);
        //System.out.println(rs.afficherReclamation());
        rs.DeleteReclamation(r1);
        System.out.println(rs.afficherReclamation());
        
    }
    
    
}
