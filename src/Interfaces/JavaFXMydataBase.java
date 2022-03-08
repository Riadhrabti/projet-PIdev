/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Services.Vu ;
import Services.Filtre ; 
import Services.CRUD_Article  ; 
import Entities.Article  ; 
/**
 *
 * @author DELL
 */
public class JavaFXMydataBase extends Application {
  
    @Override
   public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Ajouter article.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

   
    public static void main(String[] args) {
  
        
        launch(args);
    
    
    }
}
   
    
    /*
    public static void main(String[] args) {
//        Vu v; 
//        v=new Vu(); 
////        System.out.print (v.VuArticleCount(16));
////        System.out.print (v.VuVerif(3,14));
//        
//        v.consulter(1, 17);
        
        
        
        
        
        
        
        Filtre F ; 
        F = new Filtre () ;
        F.FiltreCategorie(2) ; 
        
        
        
      
        
        
      
        
      
        
     }
    
        
        
    
}
*/