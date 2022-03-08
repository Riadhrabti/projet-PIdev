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
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class Payement implements Initializable {

    @FXML
    private Button ret;
    @FXML
    private TextField mail;
    
    @FXML
    private TextField adresse;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        FXMLLoader fxmlLoader;
     Stage stage;
     Parent root;
      private void GotoFXML(String vue, String title,ActionEvent event) throws Exception {
        
            String path = "/Gui/" ;
             fxmlLoader = new FXMLLoader(getClass().getResource(path+vue+".fxml"));
             root =  fxmlLoader.load();
             stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        
    }
    @FXML
    private void retour(ActionEvent event) {
    }



    @FXML
    private void stripeB(ActionEvent event) throws Exception {
                 System.out.println("test");
        try {
            GotoFXML("Stripe", "ForU", event);
        } catch (IOException ex) {
            Logger.getLogger(Payement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
