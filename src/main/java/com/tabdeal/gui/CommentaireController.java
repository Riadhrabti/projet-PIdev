/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableView<?> tableComm;
    @FXML
    private TableColumn<?, ?> collComm;
    @FXML
    private TableColumn<?, ?> collDate;
    @FXML
    private Button btnAjouterBtn;
    @FXML
    private Button btnModifierComm;
    @FXML
    private Button btnSupprimeComm;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
