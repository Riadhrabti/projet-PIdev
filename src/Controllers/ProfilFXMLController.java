/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ProfilFXMLController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfphone;
    @FXML
    private Button btnmodif;
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
        tfnom.setText(Userconnected.getNom());
        tfprenom.setText(Userconnected.getPrenom());
        tfadresse.setText(Userconnected.getAdr());
        tfphone.setText(Userconnected.getPhone());
      
       lbfullname.setText(Userconnected.getPrenom()+" "+Userconnected.getNom());
        String photo  = Userconnected.getImage();
       Image image= new Image(getClass().getResourceAsStream(photo)) ;
       imageU.setImage(image);
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
    private void ModifUser(ActionEvent event) {
         User u = new User(Userconnected.getId(), tfnom.getText(), tfprenom.getText(),tfadresse.getText(),tfphone.getText());
        Userconnected.setNom(tfnom.getText());
        Userconnected.setPrenom(tfprenom.getText());
        Userconnected.setAdr(tfadresse.getText());
        Userconnected.setPhone(tfphone.getText());
        if (us.update(Userconnected)) {
            lbfullname.setText(Userconnected.getPrenom()+" "+Userconnected.getNom());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Mr/Mme"+ lbfullname.getText()+ " "+ " Vos donnés personelles sont modifiés !", ButtonType.CLOSE);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, " il ya un petit probleme ressayer plus tard !", ButtonType.CLOSE);
                alert.show();
        }
    }

    @FXML
    private void ConsultProf(ActionEvent event) throws Exception {
         GotoFXML("DetailUserGui", "ForU",event);
        
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

    @FXML
    private void upDate(ActionEvent event) throws Exception {
         GotoFXML("ProfilFXML", "ForU",event);
    }
    }



    
        
   
    

