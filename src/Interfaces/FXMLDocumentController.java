/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.net.URL ;
import java.util.ResourceBundle ;
import javafx.event.ActionEvent ;
import javafx.fxml.FXML ;
import javafx.fxml.Initializable ;
import javafx.scene.control.Button ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField ;
import Services.CRUD_Article ;
import Utils.MydataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;



/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Remplir();
            // TODO
        } catch (SQLException ex) {
            
        }
    }    




  @FXML private TextField  titre ; 
  @FXML private Button consulterannonce ; 
   
  private Connection conn ;
   private ComboBox com ;
   private Statement ste;
   private PreparedStatement pste;
   ResultSet rst; 
     public void consulter (ActionEvent event) {
       /*CRUD_Article c ; 
       c=new CRUD_Article();
       String r = c.getTitle(14);
       titre.setText(r);*/
    }

     public void Remplir() throws SQLException{

    conn = MydataBase.getInstance().getCnx();
String req="SELECT * FROM categorie";
 pste = conn.prepareStatement(req);
   rst = pste.executeQuery();
   while (rst.next()){
com.getItems().add(rst.getString("nom_categorie"));
        }
    }
    
}
    
