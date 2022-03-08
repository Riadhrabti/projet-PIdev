/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static alphapi.AlphaPi.Userconnected;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DetailUserGuiController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Button CancelButton;
    @FXML
    private Label lb_id;
    @FXML
    private Label lb_nom;
    @FXML
    private Label lb_pr;
    @FXML
    private Label lb_mail;
    @FXML
    private Label lb_login;
    @FXML
    private Label lb_mdp;
    @FXML
    private Label lb_adr;
    @FXML
    private Label lb_tel;
    @FXML
    private Label lb_date;
    @FXML
    private Label lb_sexe;
    @FXML
    private Label lb_role;
    @FXML
    private Label lb_Rating;
    @FXML
    private Label lb_éch;
    @FXML
    private Label lb_pos;
    @FXML
    private ImageView imgUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         lb_nom.setText(Userconnected.getNom());
        lb_pr.setText(Userconnected.getPrenom());
        lb_mail.setText(Userconnected.getEmail());
        lb_login.setText(Userconnected.getLogin());
        lb_mdp.setText(Userconnected.getMdp());
        lb_adr.setText(Userconnected.getAdr());
        lb_tel.setText(Userconnected.getPhone());
        lb_date.setText(String.valueOf(Userconnected.getDate_naiss()));
        lb_sexe.setText(Userconnected.getSexe());
        lb_Rating.setText(String.valueOf(Userconnected.getRating()));
        lb_éch.setText(String.valueOf(Userconnected.getNb_art_ech()));
        lb_pos.setText(String.valueOf(Userconnected.getNb_art_pos()));
        lb_role.setText((Userconnected.getRole()));
        //imgUser.setImage(Userconnected.getImage())
       String photo  = Userconnected.getImage();
       System.out.print(photo);
       Image image= new Image(getClass().getResourceAsStream(photo)) ;
       imgUser.setImage(image);
    }    

    @FXML
    private void annuler(ActionEvent event) {
         Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
        
    }
    
}
