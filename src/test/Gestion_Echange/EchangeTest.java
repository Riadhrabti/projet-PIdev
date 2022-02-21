/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Gestion_Echange;

import Config.Database;
import Controller.EchangeService;
import Entity.Echange;

/**
 *
 * @author Riadh
 */
public class EchangeTest {
    public static void main(String[] args) {
        Database m = Database.getInstance();
        
        Echange e =new Echange(6,5,2,1);
        Echange e1 =new Echange(4,5,6,1,2);
        Echange e2 =new Echange(3);
        EchangeService echanges =new EchangeService();
        //echanges.ajouterEchange(e);
        //echanges.DeleteEchange(e2);
        echanges.UpdateEchange(e1);
        //echanges.DeleteEchange(e1);
        
}
}
