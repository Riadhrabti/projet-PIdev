/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;
import Utils.MydataBase;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Services.CRUD_Article; 
import Services.Filtre;
import Services.Vu;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author DELL
 */
public class ControllerConsulter implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label type;
    @FXML
    private Label username;
    @FXML
    private Button home;
    @FXML
    private ImageView titre;
    @FXML
    private Button ajouter_annonce;
    @FXML
    private Button home11;
    @FXML
    private Button home12;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private ImageView iview10;
    @FXML
    private ImageView iview11;
    @FXML
    private ImageView iview12;
 Image image10 =new Image(getClass().getResourceAsStream("10.png"));
 Image image11 =new Image(getClass().getResourceAsStream("11.png"));
 Image image12 = new Image(getClass().getResourceAsStream("12.png"));
 Image image13 = new Image(getClass().getResourceAsStream("+.png"));
 Image image14 = new Image(getClass().getResourceAsStream("user.png"));
 Image image15 = new Image(getClass().getResourceAsStream("vu.png"));
 Image image16 = new Image(getClass().getResourceAsStream("coeur.png"));

    @FXML
    private ImageView iview13;
    @FXML
    private ImageView iview14;
    @FXML
    private ImageView iview15;
    @FXML
    private Label label15;
    @FXML
    private ImageView Qr;
   // private ImageView iview16;
 
 @Override
 public void initialize(URL location, ResourceBundle resources) {
       ConsulterAnnonce(26);
       iview10.setImage(image10);
       iview11.setImage(image11);
       iview12.setImage(image12);
       iview13.setImage(image13);
       iview14.setImage(image14);
       iview15.setImage(image15);
       //iview16.setImage(image16);
       vuCounter(2 ,26);
       affichImage();
    }
    

@FXML 
Label titre1 ;
@FXML 
Label date_publication ;
@FXML 
Label type_categorie;
@FXML 
Label emplacement_article ;
@FXML 
Label etat1 ;
@FXML
Label description1;
@FXML 
ImageView iview ;
   private Connection conn ;
   private Statement ste;
   private PreparedStatement pste;
   ResultSet rst; 
    public void ConsulterAnnonce(int idArticle){

    String Req= "SELECT article.id ,article.Date_publication,article.etat,article.Description,article.titre,article.image , categorie_article.type_categorie,\n" +
"gouvernorat.nom\n" +
"FROM `article` \n" +
"INNER join`gouvernorat`\n" +
"on article.id_Gouvernorat=gouvernorat.id_Gouvernorat\n" +
"INNER join `categorie_article`\n" +
"on article.id_categorie=categorie_article.id\n" +
"WHERE article.id="+idArticle;
    try{ 
    conn = MydataBase.getInstance().getCnx();
    pste = conn.prepareStatement(Req);
    rst = pste.executeQuery();
    while (rst.next()){
    titre1.setText(rst.getString("titre"));
    date_publication.setText( rst.getString("Date_publication"));
    type_categorie.setText(rst.getString("type_categorie"));
    emplacement_article.setText(rst.getString("nom"));
    etat1.setText(rst.getString("etat"));
    description1.setText(rst.getString("Description"));
        
        Image image = new Image(getClass().getResourceAsStream(rst.getString("image")));
        iview.setImage(image);
    
    }
    
    
    }catch(SQLException e){
    }
    







} 

    @FXML
    private void Show_Home(ActionEvent event) {
    }

    @FXML
    private void ajouter(ActionEvent event) {
    try{ 
        Stage stage = new Stage(); 
        stage.setTitle("ajouter une Annonce");
        Parent root = FXMLLoader.load(getClass().getResource("ajout article.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    
    
    }catch(IOException e){}
    
    
    
    }
  
public void vuCounter(int user ,int article){
Vu v=new Vu(); 
v.consulter(user, article);
int i=v.VuArticleCount(article);
String s =""+i;
label15.setText(s);


}   

  

    @FXML
    private void favoris(ActionEvent event) {
          Filtre f = new Filtre(); 
   f.Favoris(3, 21);
       
    }
    public void affichImage(){
        String Id_stat = titre1.getText();
        String f_name = Id_stat;
        String Path_name = new File("src/QrCode/").getAbsolutePath();
        String image = Path_name+ "\\" + Id_stat + ".PNG";
        System.out.println(image);
        ImageView i = new ImageView();
        File f =  new File (image);
        Image im =new Image(f.toURI().toString());
        Qr.setImage(im);
    }
    
}
