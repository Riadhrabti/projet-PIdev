/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.EchangeService;
import Entities.Echange;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Riadh
 */
public class ListdemandeechangeFXMLController implements Initializable {

    @FXML
    private TableView<Echange> tableview;
    @FXML
    private TableColumn<Echange, Integer> colIDechange;
    @FXML
    private TableColumn<Echange, Integer> colIDmembre1;
    @FXML
    private TableColumn<Echange, Integer> colIDmembre2;
    @FXML
    private TableColumn<Echange, Integer> colIDarticleaechanger;
    @FXML
    private TableColumn<Echange, Integer> colIDarticlesouhaitée;
    @FXML
    private TextField id_etat;
    @FXML
    private Button btn_refuser;
    @FXML
    private Button btn_accepter;
    @FXML
    private Button btn_Reclamer;
    @FXML
    private TextField id_ech;
    @FXML
    private TableColumn<Echange,Integer> coletat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        {
        show();
    }  
    }
    
public void show(){
         EchangeService es=new EchangeService();
            ObservableList<Echange> echanges= es.afficherEchange();
            colIDechange.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_echange") );
            colIDmembre1.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_membre1") );
            colIDmembre2.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_membre2") );
            colIDarticleaechanger.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_article1") );
            colIDarticlesouhaitée.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_article2") );
            coletat.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("etat") );
            
            tableview.setItems(echanges);
           
}
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Echange s = tableview.getSelectionModel().getSelectedItem();
            id_etat.setText(""+s.getEtat());
            id_ech.setText(""+s.getId_echange());
}
   
    
     @FXML
    private void Accepterclick(ActionEvent event) {
        {
         String et =id_etat.getText();
         String id = id_ech.getText();

           
            int et1= Integer.parseInt(et);
            int id1= Integer.parseInt(id);
            et1=2;
            
            
          
            Echange e=new Echange(id1,et1);
            EchangeService echanges=new EchangeService();
            echanges.UpdateEchange1(e);
            
            echanges.UpdateEchange2(id1);
            
    }
            
    show();
            Image img = new Image("/Ressources/Accept.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("demande Accepté")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    
        show(); 
       
    }


    @FXML
    private void Refuserclick(ActionEvent event) {
        String et =id_etat.getText();
         String id = id_ech.getText();

           
            int et1= Integer.parseInt(et);
            int id1= Integer.parseInt(id);
            et1=1;
          
            Echange e=new Echange(id1,et1);
            EchangeService echanges=new EchangeService();
            echanges.UpdateEchange1(e);
            
            show();
            Image img = new Image("/Ressources/Accept.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("demande Refusé")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
        
    }
    private void GotoFXML(String vue, String title, Event aEvent) {
        try {
             String path = "/GUI/" ;
            Event event;
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path+vue + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ListdemandeechangeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Reclamerclick(ActionEvent event) {
        GotoFXML("ReclamationFXML","", event);
    }
}

