/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabdeal.gui;

import com.tabdeal.Entite.Categorie;
import com.tabdeal.Entite.Publication;
import com.tabdeal.Service.ServiceCategorie;
import com.tabdeal.Service.ServicePublication;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Publication> tablePub;
    @FXML
    private TableColumn<Publication, String> collTitre;
    @FXML
    private TableColumn<Publication, String> collDescription;
    @FXML
    private TableColumn<Publication, String> collDate;
    @FXML
    private TableColumn<Publication, Integer> collLike;
    @FXML
    private TableColumn<Publication, Integer> collDislike;
    @FXML
    private ComboBox<String> comboBoxCat;
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
        ServicePublication service = new ServicePublication();
        ObservableList<Publication> pub = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDate.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
        collLike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("like"));
        collDislike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("dislike"));
        
        tablePub.setItems(pub);
        
        ServiceCategorie service1 = new ServiceCategorie();
         List<Categorie> cat = service1.readAll();
        ObservableList<String> listCat= FXCollections.observableArrayList();
        for (int i = 0; i < cat.size(); i++) {
    listCat.add(cat.get(i).getNom());
    
    
    }
        
        comboBoxCat.setItems(listCat);
        
        
        
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
        String titre = textFieldTitre_pub.getText();
        String description = textFieldDescription.getText();

        Publication pub = new Publication(5,titre,"test",description);
        ServicePublication service = new ServicePublication();
        service.ajouter(pub);
        tablePub.refresh();
        
        }
        
        
        
     
        
        
    
    
    public void showPublications(){
        ServicePublication service = new ServicePublication();
        ObservableList<Publication> pub = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDate.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
        collLike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("like"));
        collDislike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("dislike"));
        
        tablePub.setItems(pub);
    }

    @FXML
    private void onModifierPub(ActionEvent event) {
        
        Publication pub=tablePub.getSelectionModel().getSelectedItem();
        String titre = textFieldTitre_pub.getText();
        String description = textFieldDescription.getText();

        pub.setTitre(titre);
        pub.setDescription(description);
        ServicePublication service = new ServicePublication();
        service.update(pub);
        tablePub.refresh();
        
        
    }

    @FXML
    private void onSupprimePub(ActionEvent event) {
        Publication pub=tablePub.getSelectionModel().getSelectedItem();
        
        

        
       
        ServicePublication service = new ServicePublication();
        service.delete(pub);
        tablePub.refresh();
    }

    @FXML
    private void onChoixCategorie(ActionEvent event) {
        ServiceCategorie service = new ServiceCategorie();
        List<Categorie> cat = service.readAll();
        ObservableList<String> listCat= FXCollections.observableArrayList();
        for (int i = 0; i < cat.size(); i++) {
    listCat.add(cat.get(i).getNom());
    
    
    }
        
        comboBoxCat.setItems(listCat);
        
        
    }

    @FXML
    private void onCommenter(ActionEvent event) throws IOException {
        
                        //AnchorPane pane = (AnchorPane) loader.load();
                        //CommentaireController uc = loader.getController();
                       // uc.getData(rowData);
                        
        Parent root;
            URL url= new File("./src/main/java/com/tabdeal/gui/Commentaire.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            pagePub.getChildren().setAll(root);
    }

    @FXML
    private void onLikePub(ActionEvent event) {
    }

    @FXML
    private void onDislikePub(ActionEvent event) {
    }
    
}
