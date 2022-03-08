/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import Utils.MydataBase;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class listeFavoris extends Application{
Stage stage =new Stage();
    @Override
    public void start(Stage primarystage) throws Exception {
        BorderPane root = new BorderPane();  
        Scene scene = new Scene(root,200,400);
        stage.setScene(scene);
        VBox v= new VBox();
        v.setAlignment(Pos.CENTER);
        v.setStyle("-fx-background-color:  linear-gradient(#662D91, #00C4FF);");
        HBox h = new HBox();
        root.setTop(h);
        h.setStyle("-fx-background-color:#662D91");
        Label lbl =new Label("liste Favoris");
        //lbl.setFont(new Font("Arial Black",18));
                
        
        h.getChildren().add(lbl);
        root.setCenter(v);
        FiltreFavoris(3,v);
        stage.show();
        
    
    
    }
    
    
   public static void main(String[] args) {
        launch(args);
    }    
    
    private Connection conn ;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst ;
          
public void FiltreFavoris (int id,VBox v) {
    conn = MydataBase.getInstance().getCnx(); 
    String req = "SELECT favoris_article.id_utilisateur ,favoris_article.id_article , article.titre ,  article.image\n" +
"FROM `favoris_article`\n" +
"INNER join `article`\n" +
"on article.id=favoris_article.id_article where id_utilisateur=" +id ;
   
        try {
            
            ste = conn.createStatement();
            rst=ste.executeQuery(req);
            
            
            while (rst.next()){
            System.out.print(rst.getString("titre"));
            System.out.print(rst.getString("image"));
            Button btn = new Button(rst.getString("titre"));
            btn.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event)   {
           try {
            Parent root = FXMLLoader.load(getClass().getResource("consulter article.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
           }catch(IOException e ){}
            
            
}
});
    
            btn.setStyle("-fx-background-radius: 30;-fx-background-color: #d6ecef;");
   // btn.setPrefWidth(200);
   
     
     
    Image image = new Image(getClass().getResourceAsStream(rst.getString("image")));
    ImageView iview = new ImageView(image);
    btn.setGraphic(iview);
    v.getChildren().add(btn);
            
            }
            
        } catch (SQLException ex) {
            System.out.print("message"+ex.getMessage());
        }
    
    
} 
    
    
    
    
    
}
