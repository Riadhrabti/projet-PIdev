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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField txt_Url_image;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
           Remplir();
           
           
 
    }    
    
        
    
    
   
   private Connection conn ;
   @FXML
   private ComboBox com ;
   @FXML
   private ComboBox com1 ;
   private Statement ste;
   private PreparedStatement pste;
   ResultSet rst; 

   public void Remplir() {
try {
    conn = MydataBase.getInstance().getCnx();
String req="SELECT * FROM `categorie_article`";
 pste = conn.prepareStatement(req);
   rst = pste.executeQuery();
  ObservableList<String> list=FXCollections.observableArrayList();
  System.out.print(list);
  ObservableList <String> list1=FXCollections.observableArrayList(); 
  list1.addAll("Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Le Kef","Mahdia","La Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan");
  
  
  while (rst.next()){
       list.add(rst.getString("type_categorie"));
//com.getItems().add(rst.getString("nom_categorie"));
        }
   com.setItems(list);
   com1.setItems(list1);
   
    }
        catch (SQLException ex) {
            
    }











}
@FXML 
TextField etat ;

@FXML 
TextField titre ;

@FXML 
TextField description ;

public int getId_Categroie(String s){
 int i=0 ;
    try{
    conn = MydataBase.getInstance().getCnx();
String req="SELECT * FROM  `categorie_article` WHERE type_categorie=?";
 pste = conn.prepareStatement(req);
 pste.setString(1,s);
 rst = pste.executeQuery();
while (rst.next()){
i=rst.getInt(1);
}
 
 }
 catch(SQLException ex){}
return i ;
}

public int getId_Gouvernorat(String s){
 int i=0 ;
    try{
    conn = MydataBase.getInstance().getCnx();
String req="SELECT * FROM `gouvernorat` WHERE nom=?";
pste = conn.prepareStatement(req);
pste.setString(1,s);
 rst = pste.executeQuery();
while (rst.next()){
i=rst.getInt(1);
}
 
 }
 catch(SQLException ex){}
return i ;
}
 

@FXML
Button publier ; 

    @FXML 
    public void publier(){ 
try{
String Cat=com.getSelectionModel().getSelectedItem().toString();
String gouv =com1.getSelectionModel().getSelectedItem().toString();
CRUD_Article a = new CRUD_Article(); 

a.ajouter(titre.getText(),getId_Categroie(Cat),1,getId_Gouvernorat(gouv),description.getText(),1,etat.getText(),txt_Url_image.getText());
CodeQr();

}catch(Exception e){}
Stage stage=new Stage();
stage.setTitle("Ok");
BorderPane root =new BorderPane(); 
Scene scene = new Scene(root,150,150);
stage.setScene(scene);
Label lbl =new Label("votre article est bien ajouté"); 
VBox vbox=new VBox();
root.setCenter(vbox);
vbox.getChildren().add(lbl); 

Image image = new Image(getClass().getResourceAsStream("src/Ressources/tick.png"));
ImageView iview= new ImageView(image);
Button btn =new Button("ok");
btn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event)   {
            stage.close();
}
});

vbox.getChildren().add(iview);
vbox.getChildren().add(btn);
vbox.setAlignment(Pos.CENTER);
stage.show();






}  
   
   
   
   
    @FXML
  private String Importer_img_Jeu(ActionEvent event) {
        String idjeu= titre.getText();
        Path to = null;
         String  m = null;
         String path = "src/javafxapplication5";
         JFileChooser chooser = new JFileChooser();
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg","jpeg","PNG");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           m = chooser.getSelectedFile().getAbsolutePath();
//            System.out.println("You chose to open this file: " +m
//                    );
            
            if(chooser.getSelectedFile() != null){
                
               try {
                   Path from = Paths.get(chooser.getSelectedFile().toURI());
                    to = Paths.get(path+"\\"+idjeu+".png");
                       
                   CopyOption[] options = new CopyOption[]{
                       StandardCopyOption.REPLACE_EXISTING,
                       StandardCopyOption.COPY_ATTRIBUTES
                   };
                   Files.copy(from, to, options);
                   System.out.println("added");
//                saveSystem(selectedFile, )
               } catch (IOException ex) {
                   System.out.println();
               }
            }
             txt_Url_image.setText(idjeu+".png");
        
    }
      return to.toString();  
   

   
   
   
}
  @FXML private Button scanner ; 
  
  private void CodeQr() {
       
 String titr = titre.getText();
        
        String desc =  description.getText(); 
        String cat  = com.getSelectionModel().getSelectedItem().toString()  ;
        String Qrtext = titr + " "+desc +" "+ cat ;
        ByteArrayOutputStream out = QRCode.from(Qrtext)
                .to(ImageType.PNG).stream();
        String f_name = titr;
        String Path_name = new File("src/QrCode/").getAbsolutePath();
        try {
            FileOutputStream fout = new FileOutputStream(new File(Path_name + "/" + (f_name + ".PNG")));
            fout.write(out.toByteArray());
            fout.flush();
            System.out.println(Path_name);

        } catch (Exception e) {
            System.out.println(e);

        }

        
    }
  


  
  
  
}