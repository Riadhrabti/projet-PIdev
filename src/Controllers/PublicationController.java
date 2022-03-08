/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Categorie;
import Entities.Commentaire;
import Entities.Publication;
import Services.ServiceCategorie;
import Services.ServiceCommentaire;
import Services.ServicePublication;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableColumn<Publication, String> collDatePub;
    @FXML
    private TableColumn<Publication, Integer> collLike;
    @FXML
    private TableColumn<Publication, Integer> collDislike;
    @FXML
    private ComboBox<String> comboBoxCat;
    @FXML
    private Button btnLike;
    @FXML
    private Button btnDislike;
    @FXML
    private AnchorPane pagePub;
    private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private TableView<Commentaire> tableComm;
    @FXML
    private TextField textfieldCommentaire;
    @FXML
    private Button btnAjouterComm;
    @FXML
    private Button btnModifierComm;
    @FXML
    private Button btnSupprimeComm;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnFavoris;
    
    @FXML
    private TableColumn<Commentaire, String> collCommentaire;
    @FXML
    private TableColumn<Commentaire, String> collDateComm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServicePublication service = new ServicePublication();
        ObservableList<Publication> pub = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDatePub.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
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
        
        FilteredList<Publication> filtredData = new FilteredList<>(pub, b -> true);
        comboBoxCat.valueProperty().addListener(((observable, oldValue, newValue) -> {
            filtredData.setPredicate(event -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (event.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; 
                } 
                 else {
                    return false;
                }
            });

        }));
        SortedList<Publication> sortedData = new SortedList<>(filtredData);
        sortedData.comparatorProperty().bind(tablePub.comparatorProperty());
        tablePub.setItems(sortedData);
        
        
        
        // TODO
    }    

    
    

    @FXML
    private void onAjouterPub(ActionEvent event) {
        String titre = textFieldTitre_pub.getText();
        String description = textFieldDescription.getText();

        Publication pub = new Publication(titre,description);
        ServicePublication service = new ServicePublication();
        service.ajouter(pub);
        tablePub.refresh();
        
        
        
        ObservableList<Publication> pub1 = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDatePub.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
        collLike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("like"));
        collDislike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("dislike"));
        
        tablePub.setItems(pub1);
        
        }
        
        
        
     
        
        
    
    
    public void showPublications(){
        ServicePublication service = new ServicePublication();
        ObservableList<Publication> pub = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDatePub.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
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
        
        
        ObservableList<Publication> pub1 = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDatePub.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
        collLike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("like"));
        collDislike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("dislike"));
        
        tablePub.setItems(pub1);
        
        
    }

    @FXML
    private void onSupprimePub(ActionEvent event) {
        Publication pub=tablePub.getSelectionModel().getSelectedItem();
        
        

        
       
        ServicePublication service = new ServicePublication();
        service.delete(pub);
        tablePub.refresh();
        
        
        
        ObservableList<Publication> pub1 = service.readAll();
        
        
        
        collTitre.setCellValueFactory(new PropertyValueFactory<Publication,String>("titre"));
        collDescription.setCellValueFactory(new PropertyValueFactory<Publication,String>("description"));
        collDatePub.setCellValueFactory(new PropertyValueFactory<Publication,String>("date"));
        collLike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("like"));
        collDislike.setCellValueFactory(new PropertyValueFactory<Publication,Integer>("dislike"));
        
        tablePub.setItems(pub1);
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
    private void onLikePub(ActionEvent event) {
    }

    @FXML
    private void onDislikePub(ActionEvent event) {
    }

    

    

    @FXML
    private void onMouseClickedTablePub(MouseEvent event) {
        Publication pub = tablePub.getSelectionModel().getSelectedItem();
           textFieldTitre_pub.setText("" +pub.getTitre());
           textFieldDescription.setText("" +pub.getDescription());
           this.showCommentaire(pub.getId());
           
           
    }

    @FXML
    private void onMouseClickedTableComm(MouseEvent event) {
        Commentaire comm = tableComm.getSelectionModel().getSelectedItem();
           textfieldCommentaire.setText("" +comm.getCommentaire());
           
    }

    @FXML
    private void onAjouterComm(ActionEvent event) {
        String commentaire = textfieldCommentaire.getText();
        Publication pub = tablePub.getSelectionModel().getSelectedItem();
        

        Commentaire comm = new Commentaire(commentaire );
        ServiceCommentaire service = new ServiceCommentaire();
        service.ajouterCommentaire(comm,pub.getId());
        tableComm.refresh();
        ObservableList<Commentaire> comm1 = service.getAll(comm.getId_publication());
        
        
        
        
        collCommentaire.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("commentaire"));
        collDateComm.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("date"));
        
        
        tableComm.setItems(comm1);
        
        
        
        
    }

    @FXML
    private void onModifierComm(ActionEvent event) {
        Commentaire comm=tableComm.getSelectionModel().getSelectedItem();
        String commentaire = textfieldCommentaire.getText();
        

        comm.setCommentaire(commentaire);
        
        ServiceCommentaire service = new ServiceCommentaire();
        service.update(comm);
        tableComm.refresh();
        ObservableList<Commentaire> comm1 = service.getAll(comm.getId_publication());
        
        
        
        
        collCommentaire.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("commentaire"));
        collDateComm.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("date"));
        
        
        tableComm.setItems(comm1);
    }

    @FXML
    private void onSupprimeComm(ActionEvent event) {
        Commentaire comm=tableComm.getSelectionModel().getSelectedItem();
        
        

        
       
        ServiceCommentaire service = new ServiceCommentaire();
        service.delete(comm);
        tablePub.refresh();
        ObservableList<Commentaire> comm1 = service.getAll(comm.getId_publication());
        
        
        
        
        collCommentaire.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("commentaire"));
        collDateComm.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("date"));
        
        
        tableComm.setItems(comm1);
    }

    @FXML
    private void onRetour(ActionEvent event) {
    }
    
    
    private void showCommentaire(int id_publication) {
        
        ServiceCommentaire service = new ServiceCommentaire();
        ObservableList<Commentaire> comm = service.getAll(id_publication);
        
        
        
        
        collCommentaire.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("commentaire"));
        collDateComm.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("date"));
        
        
        tableComm.setItems(comm);
        
    }
}
