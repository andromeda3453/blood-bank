package projectforoop;

import projectforoop.Donor;
import projectforoop.Receiver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

public class DonatePageController {
    
    @FXML
    TableView<Receiver> receiverTable;
    @FXML
    Button donateButton;
    @FXML
    Button backButton;
    @FXML
    Button closeButton;
    
    @FXML
    ObservableList<Receiver> receiverList; 
    
       
    
    
    public void initialize() throws SQLException {
        
         receiverList = FXCollections.observableArrayList(
    
                DbManager.fetchReceivers()
    
    );
        
        
        receiverTable.getItems().addAll(receiverList);

        
    }
    
    
    
    public void onClicked(ActionEvent event){
        
        Parent root;
        Stage stage = new Stage();
        
        if(event.getTarget().equals(backButton)) {
            try {
                ((Node) event.getSource()).getScene().getWindow().hide();        
            } catch (Exception e) {
                
                
            }
        }else if(event.getTarget().equals(donateButton)){
    
            try {
                root = FXMLLoader.load(getClass().getResource("NewDonation.fxml"));
                stage.setTitle("New Donation");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initOwner(((Node)event.getTarget()).getScene().getWindow());
                stage.show();
        
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
    
    public void onCloseClicked(ActionEvent event){
    
        ((Node)event.getSource()).getScene().getWindow().hide();
    
    }
    
    public void onMouseEntered(MouseEvent event){
    
        
        ((Node)event.getSource()).setEffect(new Bloom(0.35));
    }
    
    @FXML
    public void onMouseExited(MouseEvent event){
    
        ((Node)event.getSource()).setEffect(null);
    
    }




}
