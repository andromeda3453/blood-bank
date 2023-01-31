/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author sarim
 */
public class UserSignupController implements Initializable {
    
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastName;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private ToggleGroup gender;
    
   
    
   

    private boolean UserEmptyFields()
    {
         if (username.getText().isEmpty() || password.getText().isEmpty() || firstname.getText().isEmpty() || lastName.getText().isEmpty() || male.getText().isEmpty() || female.getText().isEmpty())
         {
             Alert alert=new Alert(AlertType.WARNING);
             alert.setTitle("Empty Fields");
             alert.setHeaderText(null);
             alert.setContentText("All the required fields must be filled.");
             alert.showAndWait();
             return false;
             
         }
             return true;
       
    }
   
    @FXML
    private void OnRegisterButtonClicked(ActionEvent event) throws SQLException
    {

        
        if (UserEmptyFields())
        {
        String first = firstname.getText();
        String last = lastName.getText();
        String userName = username.getText();
        String pass = password.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        
        if(isAlreadyExist(userName))
        {
            Alert alert=new Alert(AlertType.INFORMATION);
             alert.setTitle("Alert");
             alert.setHeaderText(null);
             alert.setContentText("This username is already taken.");
             alert.showAndWait();
        }
        else
        {
            
        DbManager.Initialize();

        UserModel user = new UserModel(first, last, gender, userName, pass);
        DbManager.Insert(user);
        
         Alert alert=new Alert(AlertType.INFORMATION);
             alert.setTitle("Welcome");
             alert.setHeaderText(null);
             alert.setContentText("Your account has been registered");
             alert.showAndWait();
             
             ((Node)event.getSource()).getScene().getWindow().hide();
        }
             
    }
        
        
    }
    
    private boolean isAlreadyExist(String username) throws SQLException
    {
        ResultSet Users=DbManager.getUsers("User");
       
        
        while(Users.next())
        {
            String name = Users.getString("UserName");
            if(name.equals(username))
                return true;
        }
        return false;
    }
    
    @FXML
    private void OnCancelButtonClicked(ActionEvent event) throws IOException
    {
       Parent root = FXMLLoader.load(getClass().getResource("CancelButton.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initOwner(((Node)(event.getTarget())).getScene().getWindow());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.resizableProperty().set(false);
        stage.setScene(scene);
        stage.show(); 
    }
    
    
    
    @FXML
    private void CancelPressed(ActionEvent event)
    {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    
    
    @FXML 
    private void OkPressed(ActionEvent event) throws IOException
    {
         Stage parent = (Stage)(((Node)event.getSource()).getScene().getWindow());
         Window Parent = parent.getOwner();
         Parent.hide();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        

}
    

}
