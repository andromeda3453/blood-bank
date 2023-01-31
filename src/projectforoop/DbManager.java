/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.concurrent.Task;

/**
 *
 * @author sarim
 */
public class DbManager extends Task{
    
    private static Connection connector;
    public static void Initialize()
    {
        try {
//            Class.forName("org.sqlite.JDBC");
//            Connection conn=DriverManager.getConnection("jdbc:sqlite:UserDb.db");
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12372352", "sql12372352",
                     "GCqgjeB7xP");
             
            connector= conn;
            System.out.println("Connection: " + connector);     
        }
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Connection Failed...");
            connector= null;
        }
    }
    
    
    
    
    public static UserModel getCurrentUser(String username,String password){
        UserModel user = null;
        
        try{
        
        Statement statement = connector.createStatement();
        ResultSet rslt = statement.executeQuery("Select FirstName,LastName,Gender"
                                                 + " From User"
                                                 + " Where UserName = '" + username + "'");
        
        
        while(rslt.next()){
        
            user =new UserModel(rslt.getString("FirstName"),rslt.getString("LastName"),
                                rslt.getString("Gender"),username,password);
        
        }
        }catch(SQLException e){
            
            return null;
        }
        return user;
    }
    
    
    
    public static ArrayList<Receiver> fetchReceivers() {
    
        ArrayList<Receiver> receivers = new ArrayList<>();
       
        try{
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT FirstName,LastName,contactnumber,quantity,bloodtype" +
                " FROM User, Receiver" +
                " WHERE User.userid = Receiver.userid");
        
        while (resultSet.next()){
        
            String name = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
            receivers.add(new Receiver(name,resultSet.getString("contactnumber"),resultSet.getString("bloodtype"),
                                        resultSet.getInt("quantity")));
        
        }
    
        }catch(SQLException e){
            
            
        }
        return receivers;      
    }
     
     
     public static ArrayList<Donor> fetchDonors() {
    
        ArrayList<Donor> donors = new ArrayList<>();
       
        try{
        Statement statement = connector.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT FirstName,LastName,contactnumber,bloodtype" +
                " FROM User, Donor" +
                " WHERE User.userid = Donor.userid");
        
        while (resultSet.next()){
        
            String name = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
            donors.add(new Donor(name,resultSet.getString("contactnumber"),resultSet.getString("bloodtype")));
        
        }
        
       
        }catch(SQLException e){
            
        }
        
        
        return donors;
        
    }
    
    
    public static void Insert(UserModel user) throws SQLException
    {
        //String query = "Insert into User(Id,FirstName,LastName,Gender,UserName,Password) VALUES(" + "0," + user.firstName + "," +
          //      user.lastName + "," + user.gender + "," + user.UserName + "," + user.Password + ")";
        String query = "Insert into User(FirstName,LastName,Gender,UserName,Password) VALUES(?,?,?,?,?)";
        System.out.println(query);
        try (PreparedStatement pstmt = connector.prepareStatement(query)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getGender());
            pstmt.setString(4, user.getUserName());
            pstmt.setString(5, user.getPassword());
            int isInserted = pstmt.executeUpdate();
            System.out.println(isInserted == 1 ? "Entry Inserted!!" : "Entry not Inserted");
            connector.close();
        }
    }
    
     
    
    public static void Insert(Donor donor) throws SQLException{
    
        String query = "Insert into Donor(contactnumber,bloodtype,userid) VALUES(?,?,?)";
        System.out.println(query);
         PreparedStatement pstmt = connector.prepareStatement(query);
         pstmt.setString(1, donor.getContactNumber());
         pstmt.setString(2, donor.getBloodType());
         pstmt.setInt(3, DbManager.getUserID(FXMLDocumentController.currentUser));
         int isInserted = pstmt.executeUpdate();
         System.out.println(isInserted == 1 ? "Entry Inserted!!" : "Entry not Inserted");
    
    }
    
    public static void Insert(Receiver receiver) throws SQLException{
    
        String query = "Insert into Receiver(contactnumber,bloodtype,quantity,userid) VALUES(?,?,?,?)";
        System.out.println(query);
         PreparedStatement pstmt = connector.prepareStatement(query);
         pstmt.setString(1, receiver.getContactNumber());
         pstmt.setString(2, receiver.getBloodType());
         pstmt.setInt(3,receiver.getQuantity());
         pstmt.setInt(4, DbManager.getUserID(FXMLDocumentController.currentUser));
         int isInserted = pstmt.executeUpdate();
         System.out.println(isInserted == 1 ? "Entry Inserted!!" : "Entry not Inserted");
    
    }
    
    
    
    
    public static int getUserID(UserModel user) throws SQLException{
    
        Statement statement = connector.createStatement();
        ResultSet resultset = statement.executeQuery("Select userid"
                                                    + " From User"
                                                    + " Where UserName='" + user.getUserName() + "'" );
        while(resultset.next()){
            return resultset.getInt("userid");
        }
        
        return -1;
    }
    
    
    
     public static boolean Contains(String username, String password) throws SQLException
     {
         
         String query= "Select UserName,Password from User";
         PreparedStatement pstmt = connector.prepareStatement(query);
         ResultSet rs= pstmt.executeQuery();
         while(rs.next())
         {
             if(rs.getString("UserName").equals(username) && rs.getString("Password").equals(password))
                 return true;
         }
         
         return false;
     }
     
     
     public static ResultSet getUsers(String tableName) throws SQLException
     {
         String query= "Select UserName from " + tableName;
         PreparedStatement pstmt = connector.prepareStatement(query);
         ResultSet rs= pstmt.executeQuery();
         return rs;
     }

    @Override
    protected Object call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

