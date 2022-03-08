/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.paiement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.MyConnection;

/**
 *
 * @author Msi
 */
public class BoostService {
    
          Connection cn2;
    Statement st;
        public BoostService() {
        cn2 = MyConnection.getInstance().getCnx();
            
            }

    private static class paiement {

        public paiement() {
        }
    }
        public class paiementService {
    private Connection con;
    private Statement ste;
    private PreparedStatement pste;
    private ResultSet rst;

    public paiementService() {
        con = MyConnection.getInstance().getCnx();
    }

       }
        }

    


