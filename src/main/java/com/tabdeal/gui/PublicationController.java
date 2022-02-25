/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class PublicationController implements Initializable {

    @FXML
    private TextField textFieldTitre_pub;
    @FXML
    private TextField textFieldDescription;
    @FXML
    private Button btnAjouterPub;
    @FXML
    private Button btnModifierPub;
    @FXML
    private Button btnSupprimePub;
    @FXML
    private TableView<?> tablePub;
    @FXML
    private TableColumn<?, ?> collTitre;
    @FXML
    private TableColumn<?, ?> collDescription;
    @FXML
    private TableColumn<?, ?> collDate;
    @FXML
    private TableColumn<?, ?> collLike;
    @FXML
    private TableColumn<?, ?> collDislike;
    @FXML
    private ComboBox<?> comboBoxCat;
    @FXML
    private Button btnCommenter;
    @FXML
    private Button btnLike;
    @FXML
    private Button btnDislike;
    @FXML
    private AnchorPane pagePub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NavigatePub_Comm(MouseEvent event) throws IOException {
        //EventEntity rowData = row.getItem();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("./com/tabdeal/gui/Commentaire.fxml"));
                        AnchorPane pane = (AnchorPane) loader.load();
                        CommentaireController uc = loader.getController();
                       // uc.getData(rowData);
                        pagePub.getChildren().setAll(pane);
    }

    @FXML
    private void onAjouterPub(ActionEvent event) {
    }

    @FXML
    private void onModifierPub(ActionEvent event) {
    }

    @FXML
    private void onSupprimePub(ActionEvent event) {
    }

    @FXML
    private void onChoixCategorie(ActionEvent event) {
    }

    @FXML
    private void onCommenter(ActionEvent event) {
    }

    @FXML
    private void onLikePub(ActionEvent event) {
    }

    @FXML
    private void onDislikePub(ActionEvent event) {
    }
    
}
