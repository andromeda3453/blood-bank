/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author sarim
 */
public class ActivitiesController implements Initializable {
    
    
    @FXML
    private void OnSignoutClicked (ActionEvent event) throws IOException
    {
        FXMLDocumentController.currentUser=null;
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }
    
     @FXML
    private void FeelingSickClicked (ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("DiseasePage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)event.getTarget()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
    
    public void onDonateClicked(ActionEvent event) throws IOException{
    
        Parent root = FXMLLoader.load(getClass().getResource("DonatePage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(((Node)event.getTarget()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    
    }
    
    public void onReceiveClicked(ActionEvent event) throws IOException{
    
        Parent root = FXMLLoader.load(getClass().getResource("ReceivePage.fxml"));
        
        Scene scene = new Scene(root);   
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(((Node)event.getTarget()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    
    }
    
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
