/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Riadh
 */
public class NotifictionFXMLController implements Initializable {

    @FXML
    private Button sub_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sub_click(ActionEvent event) {
        Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Reclamation")
                .text("Recalamation ajouté")
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(4))
                .onAction((ActionEvent event1) -> {
                    System.out.println("Click on notification");
                });
          
         notificationBuilder.darkStyle();
       notificationBuilder.show();
                
    }
    
}
