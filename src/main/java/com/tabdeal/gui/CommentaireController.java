/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.gui;

import com.tabdeal.Entite.Commentaire;
import com.tabdeal.Entite.Publication;
import com.tabdeal.Service.ServiceCommentaire;
import com.tabdeal.Service.ServicePublication;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class CommentaireController implements Initializable {

    @FXML
    private TextField textFieldTitre_pub;
    @FXML
    private TextField textFieldDescription;
    @FXML
    private AnchorPane pageComm;
    @FXML
    private TextField textfieldCommentaire;
    @FXML
    private TableView<Commentaire> tableComm;
    @FXML
    private TableColumn<Commentaire, String> collComm;
    @FXML
    private TableColumn<Commentaire, String> collDate;
    @FXML
    private Button btnModifierComm;
    @FXML
    private Button btnSupprimeComm;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnAjouterComm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //testgit
        //testgit2
        //testgit3
    }    

    @FXML
    private void onAjouterComm(ActionEvent event) {
        String commentaire = textfieldCommentaire.getText();
        

        Commentaire comm = new Commentaire(commentaire);
        ServiceCommentaire service = new ServiceCommentaire();
        service.ajouter(comm);
        tableComm.refresh();
    }

    @FXML
    private void onModifierComm(ActionEvent event) {
        Commentaire comm= tableComm.getSelectionModel().getSelectedItem();
        String commentaire = textfieldCommentaire.getText();
        

        comm.setCommentaire(commentaire);
        
        ServiceCommentaire service = new ServiceCommentaire();
        service.update(comm);
        tableComm.refresh();
    }

    @FXML
    private void onSupprimeComm(ActionEvent event) {
        Commentaire comm=tableComm.getSelectionModel().getSelectedItem();
        
        

        
       
        ServiceCommentaire service = new ServiceCommentaire();
        service.delete(comm);
        tableComm.refresh();
    }

    @FXML
    private void onRetour(ActionEvent event) throws MalformedURLException, IOException {
        Parent root;
            URL url= new File("./src/main/java/com/tabdeal/gui/Publication.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            pageComm.getChildren().setAll(root);
    }
    
}
