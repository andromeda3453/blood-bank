/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;
import java.sql.*;
/**
 *
 * @author sarim
 */
public class UserModel 
{
    private String firstName;
    private String lastName;
    private String gender;
    private String UserName;
    private String Password;
    
    
//    private DbManager dbManager;
    
    public UserModel( String firstName, String lastName,String gender,String UserName,String Password){
//        dbManager = db; 
        this.firstName = firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.UserName=UserName;
        this.Password=Password;
        
    }
    
    
    

    @Override
    public String toString() {
        return "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", UserName=" + UserName + ", Password=" + Password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    
}
