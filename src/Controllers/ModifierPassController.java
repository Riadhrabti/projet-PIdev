/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.UserService;
import static alphapi.AlphaPi.Userconnected;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ModifierPassController implements Initializable {

    @FXML
    private TextField pass1;
    @FXML
    private TextField pass2;
    @FXML
    private TextField pass3;
    @FXML
    private Button conf;
    @FXML
    private ImageView imageviewlogo;
    @FXML
    private ImageView imageU;
    @FXML
    private Label lbfullname;

    /**
     * Initializes the controller class.
     */
    UserService us = new UserService();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbfullname.setText(Userconnected.getPrenom()+" "+Userconnected.getNom());
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
    private void ConsultProf(ActionEvent event) throws Exception {
        GotoFXML("DetailUserGui", "ForU",event);
    }

    @FXML
    private void upDate(ActionEvent event) throws Exception {
        GotoFXML("ProfilFXML", "ForU", event);
    }

    @FXML
    private void ResetPass(ActionEvent event) throws Exception {
        GotoFXML("ModifierPass", "ForU",event);
    }

    @FXML
    private void DeleteUsr(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Suppression ");
        alert.setContentText("Voulez-vous vraiment supprimer Votre compte ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (us.delete(Userconnected)) {
                FXMLLoader LOADER = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
                try {
                    Parent root = LOADER.load();
                    Scene sc = new Scene(root);
                    LoginController cntr = LOADER.getController();
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(sc);
                    window.show();
                } catch (IOException ex) {

                }
            }

        }
    }
    
}
