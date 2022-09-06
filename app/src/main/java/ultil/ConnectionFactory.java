/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author revon
 */
public class ConnectionFactory {
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/task_list";
    public static final String USER = "postgres";
    public static final String PASS = "autocom2017@";
    
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
           
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception ex){
            
            throw new RuntimeException("Error in connecting with database: " + ex.getMessage());
            
        }
    }
    public static void closeConnection(Connection connection){
        
        try{
          if (connection != null){
              connection.close();
          }
        }
        catch(Exception ex){
            throw new RuntimeException("Erro in closes datebase: " + ex.getMessage());
        }
    
    }
    
  
    public static void closeConnection(Connection connection, PreparedStatement statement){
        
        try{
          if (connection != null){
              connection.close();
          }
          if(statement != null){
              statement.close();
          }
         
        }
        catch(Exception ex){
            throw new RuntimeException("Erro in closes datebase: " + ex.getMessage());
        }
    
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        
        try{
          if (connection != null){
              connection.close();
          }
          if(statement != null){
              statement.close();
          }
          if(resultSet != null){
              resultSet.close();
          }
        }
        catch(Exception ex){
            throw new RuntimeException("Erro in closes datebase: " + ex.getMessage());
        }
    
    }
}
