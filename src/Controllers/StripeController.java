/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;


/**
 * FXML Controller class
 *
 * @author Msi
 */
public class StripeController implements Initializable {

    @FXML
    private WebView idWebView;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WebEngine webEngine = idWebView.getEngine();

        webEngine.load("http://127.0.0.1:5500/elements-examples/index.html");
        webEngine.setJavaScriptEnabled(true);
        // TODO
    }    
    
}
