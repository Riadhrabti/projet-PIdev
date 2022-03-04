/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tabdeal;

import com.tabdeal.Entite.Categorie;
import com.tabdeal.Entite.Publication;
import com.tabdeal.Service.ServiceCategorie;
import com.tabdeal.Service.ServiceFavoris;
import com.tabdeal.Service.ServicePublication;

/**
 *
 * @author SBS
 */
public class MainClass {
    public static void main(String[] args) {
        
        ServiceCategorie cat = new ServiceCategorie();
      ServicePublication publicationService = new ServicePublication();
      
      Publication p = new Publication("fuck","Zzab");
      Publication p2 = new Publication("not","Zzab");
      
      publicationService.ajouter(p);
        
        
        
    }
    
    
    
}
    

