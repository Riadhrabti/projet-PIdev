/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.EchangeService;
import Entity.Echange;
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
public class EchangeFXMLController implements Initializable {

    @FXML
    private Button sub_btn;
    @FXML
    private Button refresh_btn;
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
    private TableView<Echange> tableview;
    @FXML
    private Button delete_btn;
    @FXML
    private Button update_btn;
    @FXML
    private TextField inp_idmembre2;
    @FXML
    private TextField inp_idarticle2;
    @FXML
    private TextField inp_idarticle1;
    @FXML
    private TextField inp_id;
    @FXML
    private TextField inp_idmembre1;
    @FXML
    private Button reclamer_btn;
    @FXML
    private Button reset_btn;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      show();
    }    

    @FXML
    private void Submitclick(ActionEvent event) {
        if (event.getSource()==sub_btn){
            String id_membre2 =inp_idmembre2.getText();
            String id_mem1 = inp_idmembre1.getText();
            String id_article1 =inp_idarticle1.getText();
            String id_article2 =inp_idarticle2.getText();
            int id_mem2= Integer.parseInt(id_membre2);
            int id_mem= Integer.parseInt(id_mem1);
            int id_art1= Integer.parseInt(id_article1);
            int id_art2= Integer.parseInt(id_article2);
            if (id_mem==id_mem2){
                 Image img = new Image("/decline.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("Modification refusé veuillez chosir un id different que ta mienne ")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
        notificationBuilder.darkStyle();
       notificationBuilder.show();
            }else if (id_art1==id_art2){
                Image img = new Image("/decline.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("Modification refusé veuillez chosir un id de produit different que ta mienne ")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
        notificationBuilder.darkStyle();
       notificationBuilder.show();
            }
       else{
                
            
            Echange E=new Echange(5, id_mem,id_mem2 , id_art1, id_art2,0);
            EchangeService es=new EchangeService();
            es.ajouterEchange(E);
            
            
             Image img = new Image("/Accept.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("demande envoyé")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    
            
            
            System.out.println("demande envoyé");
        }
        }
    }

    @FXML
    private void refreshclick(ActionEvent event) {
        {
        EchangeService es = new EchangeService();
       
            ObservableList<Echange> echanges = es.afficherEchange();
            echanges.clear();
            show();
        System.out.println("cleared");
    }
    
}

    @FXML
    private void deleteclick(ActionEvent event) {
     String id=inp_id.getText();
        int id1=Integer.parseInt(id);
        Echange e1= new Echange(id1);
        EchangeService echanges= new EchangeService();
        echanges.DeleteEchange(e1);
        show();
         Image img = new Image("/Accept.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("demande supprimé")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    
    }

    @FXML
    private void updateclick(ActionEvent event) {
       
        String id = inp_id.getText();
        String id_mem1 = inp_idmembre1.getText();
        String id_mem2 = inp_idmembre2.getText();
        
        String id_article1 = inp_idarticle1.getText();
        String id_article2 = inp_idarticle2.getText();
        

        int id1 = Integer.parseInt(id);
        int id_membre1 = Integer.parseInt(id_mem1);
        int id_membre2 = Integer.parseInt(id_mem2);
        int id_art1 = Integer.parseInt(id_article1);
        int id_art2 = Integer.parseInt(id_article2);

        Echange E = new Echange(id1,id_membre1,id_membre2,id_art1,id_art2,0);
        EchangeService es = new EchangeService();
        es.UpdateEchange(E);
        show();
        Image img = new Image("/Accept.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Echange")
                .text("demande modifié")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    

        
    }
    public void show(){
         EchangeService es=new EchangeService();
            ObservableList<Echange> echanges= es.afficherEchange();
            colIDechange.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_echange") );
            colIDmembre1.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_membre1") );
            colIDmembre2.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_membre2") );
            colIDarticleaechanger.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_article1") );
            colIDarticlesouhaitée.setCellValueFactory(new PropertyValueFactory<Echange,Integer>("id_article2") );
            tableview.setItems(echanges);
           
}
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Echange s = tableview.getSelectionModel().getSelectedItem();
            inp_id.setText(""+s.getId_echange());
            inp_idmembre1.setText(""+s.getId_membre1());
            inp_idmembre2.setText(""+s.getId_membre2());
            inp_idarticle1.setText(""+s.getId_article1());
            inp_idarticle2.setText(""+s.getId_article2());
            
    }

    @FXML
    private void resetclick(ActionEvent event) {
         inp_id.setText(null);
            inp_idmembre1.setText(null);
            inp_idmembre2.setText(null);
            inp_idarticle1.setText(null);
            inp_idarticle2.setText(null);
        
        
    }
    private void GotoFXML(String vue, String title, Event aEvent) {
        try {
            Event event;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(vue + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) aEvent.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EchangeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reclamerclick(ActionEvent event) {
        GotoFXML("ReclamationFXML","", event);
        
    }
    
    
    
}
