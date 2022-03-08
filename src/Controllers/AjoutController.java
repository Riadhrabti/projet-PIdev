/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Button ret;
    @FXML
    private Button ajouter;
    @FXML
    private TextField nom;
    @FXML
    private DatePicker date;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private TextField adr;
    @FXML
    private TextField tel;
    @FXML
    private TextField sexe;

    @FXML
    private ImageView imgU;
    @FXML
    private Label ImageName;

    /**
     * Initializes the controller class.
     */
    
    UserService us=new UserService();
    @FXML
    private TextField urlimg;
    @FXML
    private Button Importer_img_Jeu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Retour(ActionEvent event) {
          try {
            Stage stage = (Stage) ret.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Gui/FXMLFirst.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            
            stage = new Stage();
            // stage.initStyle(StageStyle.TRANSPARENT); //Pour faire disparaitre la barre de fermeture basique de Windows
            
            stage.setScene(new Scene(root1));
            stage.getScene().setFill(Color.TRANSPARENT);
            stage.getScene().getStylesheets().setAll(getClass().getResource("/Gui/styles.css").toString());
            //Thread.sleep(5000); //Pour simuler un chargement pendant 'x' seconde(s)
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
Parent root;
     FXMLLoader fxmlLoader;
     Stage stage;
      private void GotoFXML(String vue, String title,ActionEvent event) throws Exception {
        
            String path = "/Gui/" ;
             fxmlLoader = new FXMLLoader(getClass().getResource(path+vue+".fxml"));
             root =  fxmlLoader.load();
             stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
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
    private void ajouter(ActionEvent event) throws Exception {
         UserService    sp = new UserService();
        if(!sp.checkLogin(login.getText())){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("change your username");
            alert.showAndWait();
            return;
        
        
    }
        
        
        
      if (login.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un login");
            alert.showAndWait();
            return;
        }
        if (mdp.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un password");
            alert.showAndWait();
            return;
        }
       
        if (email.getText().isEmpty() 
                        || !email.getText().contains("@") 
                        || !email.getText().contains(".") 
                       //|| email.getText().indexOf("@", 0) > email.getText().indexOf(".", 0) 
                        || email.getText().indexOf("#", 0) >= 0
                        || email.getText().indexOf("&", 0) >= 0
                        || email.getText().indexOf("(", 0) >= 0
                        //| email.getText().length() - email.getText().replace("@", "").length() > 1
                        //|| email.getText().length() - email.getText().replace(".", "").length() > 1
                        || email.getText().indexOf("Â§", 0) >= 0
                        || email.getText().indexOf("!", 0) >= 0
                        || email.getText().indexOf("Ã§", 0) >= 0
                        || email.getText().indexOf("Ã ", 0) >= 0
                        || email.getText().indexOf("Ã©", 0) >= 0
                        || email.getText().indexOf(")", 0) >= 0
                        || email.getText().indexOf("{", 0) >= 0
                        || email.getText().indexOf("}", 0) >= 0
                        || email.getText().indexOf("|", 0) >= 0
                        || email.getText().indexOf("$", 0) >= 0
                        || email.getText().indexOf("*", 0) >= 0
                        || email.getText().indexOf("â‚¬", 0) >= 0
                        || email.getText().indexOf("`", 0) >= 0
                        || email.getText().indexOf("\'", 0) >= 0
                        || email.getText().indexOf("\"", 0) >= 0
                        || email.getText().indexOf("%", 0) >= 0
                        || email.getText().indexOf("+", 0) >= 0
                        || email.getText().indexOf("=", 0) >= 0
                        || email.getText().indexOf("/", 0) >= 0
                        || email.getText().indexOf("\\", 0) >= 0
                        || email.getText().indexOf(":", 0) >= 0
                        || email.getText().indexOf(",", 0) >= 0
                        || email.getText().indexOf("?", 0) >= 0
                        || email.getText().indexOf(";", 0) >= 0
                        || email.getText().indexOf("Â°", 0) >= 0
                        || email.getText().indexOf("<", 0) >= 0
                        || email.getText().indexOf(">", 0) >= 0) 
                {
                    
                     Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Erreur");
                alert.setContentText("Vous devez saisir un mail valid");
                alert.showAndWait();
                return;
                }
        
         if (nom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un nom");
            alert.showAndWait();
            return;
        }
        if (prenom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un prenom");
            alert.showAndWait();
            return;
        }
        
        if (adr.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un pays");
            alert.showAndWait();
            return;
        }   
        
     if (!(tel.getText().matches("\\d{8}"))) {
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un numéro de telephone");
            alert.showAndWait();
            return;

     }
     
       if (sexe.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Vous devez selectionnez un pays");
            alert.showAndWait();
            return;
        } 
       
        String loginU = login.getText();
        String mdpU = mdp.getText();
        String mailU = email.getText();
        String nomU = nom.getText();
        String prenomU = prenom.getText();
        String adrU = adr.getText();
        String telU = tel.getText();
        Date dateBirth = java.sql.Date.valueOf(date.getValue());
        String sexeU = sexe.getText();
        String imageU=urlimg.getText();
        String roleU = "membre";
        User u = new User(nomU, prenomU,mailU, loginU, mdpU,adrU,telU,dateBirth,sexeU,roleU,imageU);
         if (us.add(u)) {
               
                AlertWindow("ForU", "Bienvenu " + prenomU, Alert.AlertType.INFORMATION);
            } else {
                AlertWindow("ForU", "Essayer une autre fois", Alert.AlertType.ERROR);
            }
         
         GotoFXML("ProfilFXML", "Dashbord Admin/Membre",event);
    }

    @FXML
   
    
  private String Importer_img_Jeu(ActionEvent event) {
        String idjeu=login.getText();
        Path to = null;
         String  m = null;
         String path = "src/Controllers";
         JFileChooser chooser = new JFileChooser();
       
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg","jpeg","PNG");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           m = chooser.getSelectedFile().getAbsolutePath();
//            System.out.println("You chose to open this file: " +m
//                    );
           
            if(chooser.getSelectedFile() != null){
               
               try {
                   Path from = Paths.get(chooser.getSelectedFile().toURI());
                    to = Paths.get(path+"\\"+idjeu+".png");
                       
                   CopyOption[] options = new CopyOption[]{
                       StandardCopyOption.REPLACE_EXISTING,
                       StandardCopyOption.COPY_ATTRIBUTES
                   };
                   Files.copy(from, to, options);
                   System.out.println("added");
//                saveSystem(selectedFile, )
               } catch (IOException ex) {
                   System.out.println();
               }
            }
             urlimg.setText(idjeu+".png");
       
    }
      return to.toString();  
    
}
}
