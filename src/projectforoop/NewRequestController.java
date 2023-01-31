package projectforoop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;

public class NewRequestController {
    @FXML
    TextField contactNumber;
    @FXML
    TextField quantity;
    @FXML
    ComboBox<String> bloodType;
    
    public boolean fieldsEmpty(){
    
        if(contactNumber.getText().isEmpty() || bloodType.getSelectionModel().isEmpty() || quantity.getText().isEmpty()){
        
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setWidth(200);
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
            
            if (contactNumber.getText().matches("[0-9]+") && quantity.getText().matches("[0-9]+")){
                
                try{
                String name = FXMLDocumentController.currentUser.getFirstName() + " " +FXMLDocumentController.currentUser.getLastName();
                Receiver receiver = new Receiver(name,contactNumber.getText(),bloodType.getValue(),Integer.parseInt(quantity.getText()));
                DbManager.Insert(receiver);
                
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
