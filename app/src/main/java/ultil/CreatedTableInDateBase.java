/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CreatedTableInDateBase {
    
    public static void CreatedTables() {
        
        
        String sql = "create table if not exists projects("
            + "id SERIAL PRIMARY KEY,"
            + "name char(55) NOT NULL,"
            + "description CHAR(55),"
            + "created_task_list TIMESTAMP,"
            + "update_task_list TIMESTAMP"
            + ");"
      
            + "create table if not exists task("
            + "id SERIAL PRIMARY KEY,"
            + "id_project INT REFERENCES projects(id),"
            + "name char(55) NOT NULL,"
            + "description CHAR(55),"
            + "status BOOLEAN NOT NULL,"
            + "nodes TEXT,"
            + "deadLine DATE,"
            + "created_task_list TIMESTAMP,"
            + "update_task_list TIMESTAMP"
            + ");";
       
            
        Connection connection = null;
        PreparedStatement statement = null;
       
    try{    
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(sql);
        ///Executa a sql para inser��o dos dados
        statement.execute();
           
           
           
       } 
       catch (SQLException ex) {
            
            throw new RuntimeException("Error  : " + ex.getMessage());
            
        }
       // fecha a conexão com banco de dados
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
    }
}
