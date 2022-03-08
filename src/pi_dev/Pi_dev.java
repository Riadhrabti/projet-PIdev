package pi_dev;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Services.likeDislike;



public class Pi_dev extends Application {

    public void start(Stage primaryStage) throws Exception {
       
        Parent root;
    
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Gui/FillActualité.fxml"));
            
            Scene scene = new Scene(root);
        
            primaryStage.setTitle("Inscription");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        
       

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         launch(args);
        
        }
}