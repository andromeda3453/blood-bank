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
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
/**
 *
 * @author sarim
 */



public class FXMLDocumentController implements Initializable {
    

    @FXML
    private TextField username;
    @FXML
    private PasswordField Password;
    @FXML
//    private Button closeButton;
    
    static double xOffset;
    static double yOffset;
    
    
    
    public static UserModel currentUser;

           
    
    @FXML
    private void OnSignupClicked(ActionEvent event) throws IOException
    {
        
       Parent root = FXMLLoader.load(getClass().getResource("UserSignup.fxml"));
        
        Scene scene = new Scene(root);
       
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        
    }
    
   
    
    
    @FXML
    private void OnLoginClicked (ActionEvent actionEvent) throws SQLException, IOException
    {
        DbManager.Initialize();
       if(DbManager.Contains(username.getText(), Password.getText()))
       {
           
           currentUser = DbManager.getCurrentUser(username.getText(), Password.getText());
           
           System.out.println(currentUser.toString());

            // login successful
            ((Node)actionEvent.getSource()).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Activities.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
       }
       else
       {
           // login unsuccessful
          
             Alert alert=new Alert(AlertType.WARNING);
             alert.setTitle("Try Again");
             alert.setHeaderText(null);
             alert.setContentText("Login unsuccessful.");
             alert.showAndWait();
       }
       
        
    
     }
    
    @FXML
    public void onCloseClicked(){
    
        System.exit(0);
    
    }
    
    @FXML
    public void onMouseEntered(MouseEvent event){
    
        
        ((Node)event.getSource()).setEffect(new Bloom(0.35));
    }
    
    @FXML
    public void onMouseExited(MouseEvent event){
    
        ((Node)event.getSource()).setEffect(null);
    
    }
     
    @FXML
    public void onMousePressed(MouseEvent event){
    
        xOffset = ((Node)event.getSource()).getScene().getWindow().getX() - event.getScreenX();
        yOffset = ((Node)event.getSource()).getScene().getWindow().getY() - event.getScreenY();
    }
    
    public void onMouseDragged(MouseEvent event){
    
        ((Node)event.getSource()).getScene().getWindow().setX(event.getScreenX() + xOffset);
        ((Node)event.getSource()).getScene().getWindow().setY(event.getScreenY() + yOffset);
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //DbManager.Initialize();
        // TODO
    }    
    
}
