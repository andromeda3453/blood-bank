package projectforoop;

import java.util.InputMismatchException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;

public class NewDonationController {
    @FXML
    TextField contactNumber;
    @FXML
    ComboBox<String> bloodType;
    
    
    private boolean fieldsEmpty(){
        if(contactNumber.getText().isEmpty() || bloodType.getSelectionModel().isEmpty()){
    
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Fields");
            alert.setHeaderText(null);
            alert.setContentText("All fields required");
            alert.showAndWait();
            return true;
            
        }
        else
            return false;
    }
    
    
    public void onClicked(){
        
        if(!fieldsEmpty()){
        
            if (contactNumber.getText().matches("[0-9]+")){
                
                try{
                String name = FXMLDocumentController.currentUser.getFirstName() + " " +FXMLDocumentController.currentUser.getLastName();
                Donor donor = new Donor(name,contactNumber.getText(),bloodType.getValue());
                DbManager.Insert(donor);
                
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Donation added");
                alert.showAndWait();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            
            }else{
                    
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Enter Correct Values");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
                
            
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
