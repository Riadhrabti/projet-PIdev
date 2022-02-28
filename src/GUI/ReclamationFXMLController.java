/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controller.ReclamationService;
import Entity.Reclamation;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


/**
 * FXML Controller class
 *
 * @author Riadh
 */
public class ReclamationFXMLController implements Initializable {

    @FXML
    private Button sub_btn;
    @FXML
    private TextField inp_idmembre;
    @FXML
    private TextField inp_idechange;
    @FXML
    private TextField inp_titre;
    @FXML
    private TextField inp_Description;
    
    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<Reclamation,Integer> colidrec;
     @FXML
    private TableColumn<Reclamation,Integer> colidmembre;
     @FXML
    private TableColumn<Reclamation,Integer> colidechange;
    @FXML
    private TableColumn<Reclamation,String> coltitre;
    @FXML
    private TableColumn<Reclamation, String> colDescription;
    @FXML
    private Button Delete_btn;
    @FXML
    private Button update_btn;
    @FXML
    private TextField inp_idmembre1;
    @FXML
    private Button refresh_btn;
    @FXML
    private TableColumn<Reclamation, Integer> coletat;
    @FXML
    private TextField inp_id;
    @FXML
    private TextField inp_etat;
    @FXML
    private Button rec;
   

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
            
            String id_membre1 =inp_idmembre.getText();
            String id_membre2= inp_idmembre1.getText();
            String id_echange= inp_idechange.getText();
            String titre= inp_titre.getText();
            String Description= inp_Description.getText();
       
            int id_mem1= Integer.parseInt(id_membre1);
            int id_mem2= Integer.parseInt(id_membre2);
            int id_ech= Integer.parseInt(id_echange);
            
            java.util.Date date = Calendar.getInstance().getTime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            Reclamation R=new Reclamation(44,id_mem1,id_ech,titre,Description,sqlDate,1);
            ReclamationService rc=new ReclamationService();
            rc.ajouterReclamation(R);
            Image img = new Image("/confirm.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Reclamation")
                .text("Recalamation ajouté")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    }
            show();
            
            
            
            
            
            
            System.out.println("reclamation envoyé");
        }

    
    

    @FXML
    private void Deleteclick(ActionEvent event) {
        String id_rec=inp_id.getText();
        int id_rec1=Integer.parseInt(id_rec);
        Reclamation r1= new Reclamation(id_rec1);
        ReclamationService reclamations= new ReclamationService();
        reclamations.DeleteReclamation(r1);
        show();
        Image img = new Image("/confirm.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Reclamation")
                .text("Recalamation supprimé")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    
        
    }

    @FXML
    private void updateclick(ActionEvent event) {
           String id_rec =inp_id.getText();

           
                   String etat= inp_etat.getText();

           
            int id= Integer.parseInt(id_rec);
            int et= Integer.parseInt(etat);

          
            Reclamation R=new Reclamation(id,et);
            ReclamationService rc=new ReclamationService();
            rc.UpdateReclamation(R);
         show();
          Image img = new Image("/confirm.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Reclamation")
                .text("Recalamation modifié")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    
    }
    public void show(){
        ReclamationService rs=new ReclamationService();
            ObservableList<Reclamation> reclamations= rs.afficherReclamation();
            colidrec.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("id") );
            colidmembre.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("id_membre") );
            colidechange.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("id_echange") );
            coltitre.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("titre") );
            colDescription.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Description") );
            coletat.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("etat") );
            tableview.setItems(reclamations);
            
    }

    @FXML
    private void refreshclick(ActionEvent event) {
        {
        ReclamationService rs = new ReclamationService();
       
            ObservableList<Reclamation> reclamations = rs.afficherReclamation();
            reclamations.clear();
            show();
        System.out.println("cleared");
    }
    }
    @FXML
    private void handleMouseAction(MouseEvent event) {
        Reclamation s = tableview.getSelectionModel().getSelectedItem();
            inp_id.setText(""+s.getId());
            inp_idmembre.setText(""+s.getId_membre());
            inp_idmembre1.setText(""+s.getId_membre());
            inp_idechange.setText(""+s.getId_echange());
            inp_titre.setText(""+s.getTitre());
            inp_Description.setText(""+s.getDescription());
             inp_etat.setText(""+s.getEtat());
    }

    @FXML
    private void sub_click(ActionEvent event) {
         Image img = new Image("/confirm.png");
        Notifications notificationBuilder;
        
        notificationBuilder = Notifications.create()
                .title("Reclamation")
                .text("Recalamation ajouté")
                .graphic(new ImageView(img))
                .position(Pos.BOTTOM_RIGHT)
                .hideAfter(Duration.seconds(4));
                
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
    }
    
}

