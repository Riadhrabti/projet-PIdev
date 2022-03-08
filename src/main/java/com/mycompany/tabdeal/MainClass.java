/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tabdeal;

import Entities.Categorie;
import Entities.Publication;
import Services.ServiceCategorie;
import Services.ServiceFavoris;
import Services.ServicePublication;

/**
 *
 * @author SBS
 */
public class MainClass {
    public static void main(String[] args) {
        
        ServiceCategorie cat = new ServiceCategorie();
      ServicePublication publicationService = new ServicePublication();
      
      Publication p = new Publication("fuck","tt");
      Publication p2 = new Publication("not","tt");
      
      publicationService.ajouter(p);
        
        
        
    }
    
    
    
}
    

