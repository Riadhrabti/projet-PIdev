
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Services.Filtre ;
import Services.likeDislike;
import Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class FillActualité implements Initializable {

    @FXML   
    private Label type;
    @FXML
    private Label username;
    @FXML
    private Button home1;
    @FXML
    private ImageView muteicon;
    @FXML
    private Button mute;
    @FXML
    private ImageView Profile_pic1;
    
    @FXML
    private Hyperlink help;
    @FXML
    private Button home;
    @FXML
    private Button add_and_event;
    @FXML
    private ImageView pic1;
    @FXML
    private Button Add_Camps;
    @FXML
    private TextField text_search;
    @FXML
    private Button btn_search;
    @FXML
    private ComboBox<?> box_categorie;
    @FXML
    private ComboBox  box_lieu;
    @FXML
    private Button btn_boost;
    @FXML
    private ScrollPane Sp;

        /**
         * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list_lieu();
        Afficher();
    }    

    @FXML
    private void Show_Home(ActionEvent event) {
    }

    @FXML
    private void mute(ActionEvent event) {
    }

    @FXML
    private void gotohelp(ActionEvent event) {
    }

    @FXML
    private void logoutbutton(ActionEvent event) {
    }

    @FXML
    private void Add_an_event(ActionEvent event) {
    }

    @FXML
    private void Add_Camps(ActionEvent event) {
    }


    @FXML
    private void Search(ActionEvent event) {
        String mots= text_search.getText() ;
        Filtre f =new Filtre ();
        f.Chercher_Article(mots);
        
          
        
    }

    @FXML
    
    private void list_lieu() {
        
        ObservableList <String> list1=FXCollections.observableArrayList(); 
  list1.addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");
   box_lieu.setItems(list1);

    }
    
   FXMLLoader fxmlLoader;
     Stage stage;
     Parent root;
      private void GotoFXML(String vue, String title,ActionEvent event) throws Exception {
        
            String path = "/Gui/" ;
             fxmlLoader = new FXMLLoader(getClass().getResource(path+vue+".fxml"));
             root =  fxmlLoader.load();
             stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        
    }

    @FXML
    private void boost(ActionEvent event) throws Exception  {
        GotoFXML("Payement", "ForU", event);

    }
    private Connection con;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst;

       public void Afficher(){
       con = MyConnection.getInstance().getCnx();
       
       String sql  = "SELECT * FROM  `article`";
       VBox v=new VBox();
       v.setPrefSize(700, 700);
       v.setAlignment(Pos.CENTER);
       
       Sp.setContent(v);
       try{
       PreparedStatement pst = con.prepareStatement(sql);
       rst=pst.executeQuery(sql);
       while(rst.next()){
       System.out.print(rst.getString("titre"));
           Image image = new Image(getClass().getResourceAsStream("télécharger.png"));
           
       ImageView iview = new ImageView(image);
       iview.setFitHeight(200);
       iview.setFitWidth(200);
       iview.setStyle("-fx-background-radius: 80;");
       
       Image image1 = new Image(getClass().getResourceAsStream("like.png"));   
       ImageView iview1 = new ImageView(image1);
       iview1.setFitHeight(20);
       iview1.setFitWidth(20);
       iview1.setStyle("-fx-background-radius: 80;");
       Button Like =new Button("like");
       Like.setGraphic(iview1);
       
       
       
       
       int j =rst.getInt(1);
       
       Image image2 = new Image(getClass().getResourceAsStream("dislike.png"));   
       ImageView iview2 = new ImageView(image2);
       iview2.setFitHeight(20);
       iview2.setFitWidth(20);
       iview2.setStyle("-fx-background-radius: 80;");
       Button Dislike =new Button("Dislike");
       Dislike.setGraphic(iview2);
       Like.setTextFill(Color.WHITE);
       Dislike.setTextFill(Color.WHITE);
        likeDislike a =new likeDislike();
       Like.setStyle("-fx-background-color: #3D5586;-fx-background-radius: 80;");
       Dislike.setStyle("-fx-background-color: #3D5586;-fx-background-radius: 80;");
       Like.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event)   {
                a.addAppreciation(5, j);
                       Like.setDisable(true);

           
}
});

       
       
       
       HBox H=new HBox(); 
       Button btn=new Button("consulter");
       btn.setStyle("-fx-background-color: #3D5586;-fx-background-radius: 80;");
       btn.setTextFill(Color.WHITE);
       String s=rst.getString("titre");
       Label lbl=new Label(s); 
       lbl.setTextFill(Color.PURPLE);
       lbl.setFont(new Font("Cambria",38));
       Label lbl2=new Label(rst.getString("Description"));
       H.setStyle(" -fx-background-color: #d6ecef;-fx-background-radius: 30;");
       H.getChildren().add(iview);
       VBox v1 = new VBox();
       v1.setStyle(" -fx-background-color: #d6ecef;-fx-background-radius: 30;");
       v1.getChildren().add(lbl);
       v1.getChildren().add(lbl2);
       v1.setAlignment(Pos.CENTER);
       
       H.setMargin(v1, new Insets(10,10,10,10));
       H.getChildren().add(v1);
       H.getChildren().add(btn);
       H.setMargin(Like, new Insets(10,10,10,10));
       H.getChildren().add(Like);
       H.getChildren().add(Dislike);

       
       
       H.setAlignment(Pos.CENTER);
       

       v.setMargin(H, new Insets(10,10,10,10));
       v.getChildren().add(H);
       
       
       
       
       
       
       }
       
       
       
       
       } catch (SQLException e){}
        
   
    

       
       
       }
       
    
    }
 
    
    
