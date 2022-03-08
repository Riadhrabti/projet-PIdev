/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.User;
import Services.UserService;
import static alphapi.AlphaPi.Userconnected;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
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
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UserController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private TextField tfAdr;
    @FXML
    private TextField tftelephone;
    @FXML
    private DatePicker date;
    @FXML
    private TextField tfsexe;
    @FXML
    private Button btnmodif;
    @FXML
    private Button btndel;
    @FXML
    private ImageView imageU;
    @FXML
    private Label lbfullname;
    @FXML
    private ComboBox<String> cbrechpar;
    @FXML
    private TextField tfrecherche;
    @FXML
    private ComboBox<String> cbtri;
    @FXML
    private Button btntri;
    @FXML
    private RadioButton radtous;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton radadmin;
    @FXML
    private RadioButton radclient;
    @FXML
    private TableView<User> tableuser;
    @FXML
    private TableColumn<User, String> colnom;
    @FXML
    private TableColumn<User, String> colprenom;
    @FXML
    private TableColumn<User, String>colemail;
    @FXML
    private TableColumn<User, String> colLogin;
    @FXML
    private TableColumn<User, String> colpassword;
    @FXML
    private TableColumn<User, String> coladresse;
    @FXML
    private TableColumn<User, String> coltelephone;
    @FXML
    private TableColumn<User, Date> coldate;
    @FXML
    private TableColumn<User, String> colsexe;
    @FXML
    private TableColumn<User, Float> colRat;
    @FXML
    private TableColumn<User, Integer> colArtEch;
    @FXML
    private TableColumn<User, Integer>  colArtPos;
    @FXML
    private TableColumn<User, Integer> colrole;

    /**
     * Initializes the controller class.
     */
    UserService us = new UserService();
    @FXML
    private TextField tfimg;
    @FXML
    private TableColumn<User, String> colimg;
    @FXML
    private Button Pdf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbrechpar.setItems(FXCollections.observableArrayList("nom", "prenom", "email", "Telephone", "adresse"));
        cbtri.setItems(FXCollections.observableArrayList("nom", "prenom", "email"));
       updateTable();
        String photo  = Userconnected.getImage();
       Image image= new Image(getClass().getResourceAsStream(photo)) ;
       imageU.setImage(image);
    }    
public void init() {
        updateTable();
        tfnom.clear();
        tfprenom.clear();
        tfemail.clear();
        tfLogin.clear();
        tfpassword.clear();
        tftelephone.clear();
        tfAdr.clear();
        tfsexe.clear();
        date.setValue(null);
        
    }

  public void AlertWindow(String title, String contenu, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
   

   
    
    

 
    @FXML
    private void ConsProfile(ActionEvent event) throws Exception {
         GotoFXML("DetailUserGui", "ForU",event);
    }
 @FXML
    private void SearchUser(KeyEvent event) {
        String search = tfrecherche.getText();
        if (search == null) {
            updateTable();
        } else {
            String searchby = cbrechpar.getSelectionModel().getSelectedItem();
            ObservableList<User> users = us.recherche(searchby, search);
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
            colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            colRat.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colArtEch.setCellValueFactory(new PropertyValueFactory<>("nb_art_ech"));
            colArtPos.setCellValueFactory(new PropertyValueFactory<>("nb_art_pos"));
            colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableuser.setItems(users);
        }
    }

    @FXML
    private void preModSupp(MouseEvent event) {
        User u = tableuser.getSelectionModel().getSelectedItem();
        System.out.println(u.getId());

        tfnom.setText(u.getNom());
        tfprenom.setText(u.getPrenom());
        tfemail.setText(u.getEmail());
        tfLogin.setText(u.getLogin());
        tfpassword.setText(u.getMdp());
        tfAdr.setText(u.getAdr());
        tftelephone.setText((u.getPhone()));
        LocalDate d = Instant.ofEpochMilli(u.getDate_naiss().getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        date.setValue(d);
        tfsexe.setText(u.getSexe());
        tfimg.setText(u.getImage());
    }

    @FXML
    private void ModifUser(ActionEvent event) {
        
         User u = tableuser.getSelectionModel().getSelectedItem();

        String nom = tfnom.getText();
        String prenom = tfprenom.getText();
        String email = tfemail.getText();
        String login = tfLogin.getText();
        String password = tfpassword.getText();
        String adresse = tfAdr.getText();
        Date d = Date.valueOf(date.getValue());
        String tel = tftelephone.getText();
        String sexe=tfsexe.getText();
        String image=tfimg.getText();
        

        u.setNom(nom);
        u.setPrenom(prenom);
        u.setEmail(email);
        u.setLogin(login);
        u.setMdp(password);
        u.setAdr(adresse);
        u.setDate_naiss(d);
        u.setPhone(tel);
        u.setSexe(sexe);
        u.setImage(image);
        
        if (us.update(u)) {
            AlertWindow("Modifier " + role, " modificaition avec succés", Alert.AlertType.ERROR);
        } else {
            AlertWindow("Modifier " + role, role + " Echec de modification", Alert.AlertType.INFORMATION);
        }
        init();
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
    private void DeleteUser(ActionEvent event) {
        User u = tableuser.getSelectionModel().getSelectedItem();
        if (us.delete(u)) {
            AlertWindow("Supprimer " + u.getRole(), u.getRole() + " supprimé avec succés", Alert.AlertType.INFORMATION);
        } else {
            AlertWindow("Supprimer " + u.getRole(), "Echec de suppression", Alert.AlertType.ERROR);
        }
        init();
    }

    @FXML
    private void TriUsers(ActionEvent event) {
         String tri = cbtri.getSelectionModel().getSelectedItem();
        ObservableList<User> users = us.tri(tri);
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
            colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            colRat.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colArtEch.setCellValueFactory(new PropertyValueFactory<>("nb_art_ech"));
            colArtPos.setCellValueFactory(new PropertyValueFactory<>("nb_art_pos"));
           colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
           colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableuser.setItems(users);
    }

    @FXML
    private void getAdmins(ActionEvent event) {
         ObservableList<User> users = us.filterRole("admin");
         colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
            colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            colRat.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colArtEch.setCellValueFactory(new PropertyValueFactory<>("nb_art_ech"));
            colArtPos.setCellValueFactory(new PropertyValueFactory<>("nb_art_pos"));
           colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableuser.setItems(users);
    }

    @FXML
    private void getMembre(ActionEvent event) {
        
        ObservableList<User> users = us.filterRole("membre");
         colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
            colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            colRat.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colArtEch.setCellValueFactory(new PropertyValueFactory<>("nb_art_ech"));
            colArtPos.setCellValueFactory(new PropertyValueFactory<>("nb_art_pos"));
            colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
             colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableuser.setItems(users);
    }

    @FXML
    private void updateTable() {
         radtous.setSelected(true);
        ObservableList<User> users = us.read();
            colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("mdp"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            coltelephone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date_naiss"));
            colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
            colRat.setCellValueFactory(new PropertyValueFactory<>("rating"));
            colArtEch.setCellValueFactory(new PropertyValueFactory<>("nb_art_ech"));
            colArtPos.setCellValueFactory(new PropertyValueFactory<>("nb_art_pos"));
            colrole.setCellValueFactory(new PropertyValueFactory<>("role"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("image"));
            tableuser.setItems(users);
    }

    @FXML
    private void Pdf(ActionEvent event) {
        String path = "";

        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(j);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();

        }

        Document doc = new Document();
        try {
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(path + "/User.pdf"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();

            PdfPTable table = new PdfPTable(12);
            table.addCell("nom");
            table.addCell("prenom");
            table.addCell("email");
            table.addCell("login");
            table.addCell("mdp");
            table.addCell("adresse");
            table.addCell("phone");
            table.addCell("date_naiss");
            table.addCell("sexe");
            table.addCell("rating");
            table.addCell("nb_art_ech");
            table.addCell("nb_art_pos");
            table.addCell("role");
            table.addCell("image");

            UserService u = new UserService();
            for (int i = 0; i < u.rowUSER(); i++) {

                String Nom = tableuser.getColumns().get(0).getCellObservableValue(i).getValue().toString();
                String Prenom = tableuser.getColumns().get(1).getCellObservableValue(i).getValue().toString();
                String email = tableuser.getColumns().get(2).getCellObservableValue(i).getValue().toString();
                String login = tableuser.getColumns().get(3).getCellObservableValue(i).getValue().toString();
                String password = tableuser.getColumns().get(4).getCellObservableValue(i).getValue().toString();
                String Adresse = tableuser.getColumns().get(5).getCellObservableValue(i).getValue().toString();
                String num_tel = tableuser.getColumns().get(6).getCellObservableValue(i).getValue().toString();
                String Date = tableuser.getColumns().get(7).getCellObservableValue(i).getValue().toString();
                String sexe = tableuser.getColumns().get(8).getCellObservableValue(i).getValue().toString();
                String rat = tableuser.getColumns().get(9).getCellObservableValue(i).getValue().toString();
                String nb_a_ech = tableuser.getColumns().get(10).getCellObservableValue(i).getValue().toString();
                 String nb_a_pos = tableuser.getColumns().get(11).getCellObservableValue(i).getValue().toString();
                String role = tableuser.getColumns().get(13).getCellObservableValue(i).getValue().toString();
                String imageU = tableuser.getColumns().get(14).getCellObservableValue(i).getValue().toString();
                table.addCell(Nom);
            table.addCell(Prenom);
            table.addCell(email);
            table.addCell(login);
            table.addCell(password);
            table.addCell(Adresse);
            table.addCell(num_tel);
            table.addCell(Date);
            table.addCell(sexe);
            table.addCell(rat);
            table.addCell(nb_a_ech);
            table.addCell(nb_a_pos);
            table.addCell(role);
            table.addCell(imageU);

            }

            doc.add(table);

        } catch (DocumentException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);

        }

        doc.close();
    }
    

    @FXML
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.tableuser;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
            }
        }
    }
    
    

    @FXML
    private void gererUsr(ActionEvent event) throws Exception {
        GotoFXML("UserFXML", "ForU",event);
    }

    @FXML
    private void Réclamation(ActionEvent event) throws Exception {
         GotoFXML("Reclamation", "ForU",event);
    }
    
}
