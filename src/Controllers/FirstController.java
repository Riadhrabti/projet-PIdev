/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FirstController implements Initializable {

    @FXML
    private VBox vbox;
    private Parent fxml;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         TranslateTransition t = new TranslateTransition(Duration.seconds(2), vbox);
        try {
            fxml = FXMLLoader.load(getClass().getResource("/Gui/Login.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {
           Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        t.setToX(255);
        t.play();
        t.setOnFinished((e) -> {
            
                
            
        });
    }    

    @FXML
    private void open_signup(ActionEvent event) {
         
         TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(-8);
        t.play();
        
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/Gui/SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
                t.setDuration(Duration.seconds(0.25));
                t.setToX(3);
                t.play();
                t.setOnFinished((e1) -> {
                    t.setToX(0);
                    t.play();
                    t.setOnFinished((e2) -> { t.stop();});
                });
            } catch (IOException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void open_login(ActionEvent event) {
         TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(vbox.getLayoutX() * 6.65);
        t.play();
        
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/Gui/Login.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
                t.setDuration(Duration.seconds(0.25));
                t.setToX(252);
                t.play();
                
                t.setOnFinished((e1) -> {
                    t.setToX(255);
                    t.play();
                    t.setOnFinished((e2) -> { t.stop();});
                });
            } catch (IOException ex) {
                Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    
    }
}

