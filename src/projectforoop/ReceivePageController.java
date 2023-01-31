package projectforoop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ReceivePageController {
    @FXML
    TableView<Donor> donorTable;   
    @FXML
    Button requestButton;
    @FXML
    Button backButton;
    @FXML
    ObservableList<Donor> donorList;
    @FXML
    Button closeButton;


    public void initialize(){
        
    
      donorList  = FXCollections.observableArrayList(
    
                    DbManager.fetchDonors()
    );
        
        donorTable.getItems().addAll(donorList);
    
    
    }
    
    public void onClicked(ActionEvent event){
        
        Parent root;
        Stage stage = new Stage();
    
        if(event.getTarget().equals(backButton)) {
            try {
                ((Node) event.getSource()).getScene().getWindow().hide();
        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (event.getTarget().equals(requestButton)){
    
            try {
                root = FXMLLoader.load(getClass().getResource("NewRequest.fxml"));
                stage.setTitle("New Request");
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
