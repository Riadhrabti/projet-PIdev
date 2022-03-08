/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.UserService;
import static alphapi.AlphaPi.Userconnected;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button button_login;

    /**
     * Initializes the controller class.
     */
    
     UserService us = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   private void GotoFXML(String vue, String title,ActionEvent event) throws Exception {
            String path = "/Gui/" ;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path+vue + ".fxml"));
            Parent root =  fxmlLoader.load();
            Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow() ;
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        
    }
   
    public void AlertWindow(String title, String contenu, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception {
        
         Userconnected = us.getUserbyLoginPass(username.getText(), mdp.getText());
        if (Userconnected.getId() != 0) {
            Userconnected.setId(Userconnected.getId());
            Userconnected.setLogin(Userconnected.getLogin());
            Userconnected.setMdp(Userconnected.getMdp());
            AlertWindow("Connexion avec succées", "On vous souhaite la bienvenue Mr/Mme " + Userconnected.getNom() + ",\nInterface " + Userconnected.getRole(), Alert.AlertType.INFORMATION);
            if ("Admin".equals(Userconnected.getRole())) {
                GotoFXML("UserFXML", "Dashbord Admin",event);
            } else {
             GotoFXML("ProfilFXML", "ForU",event);
            }
        } else {
            AlertWindow("Connexion echouée", "Login ou mot de pass invalid!!", Alert.AlertType.ERROR);
        }
    
    }
    }
    
