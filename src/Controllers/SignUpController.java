/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignUpController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private Button inscrUsr;
 
    Parent root;
     FXMLLoader fxmlLoader;
     Stage stage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
 private void GotoFXML(String vue, String title, ActionEvent event) throws IOException {
        
            String path = "/Gui/" ;
             fxmlLoader = new FXMLLoader(getClass().getResource(path+vue+".fxml"));
             root =  fxmlLoader.load();
             stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
       }
    @FXML
    private void inscriUser(ActionEvent event) throws IOException {
        
          GotoFXML("AjoutUser", "ForU", event);
    
    }
    
}
