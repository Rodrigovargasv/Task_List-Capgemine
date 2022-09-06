/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import ultil.ConnectionFactory;

/**
 *
 * @author revon
 */
public class ProjectController{
    
    
    public void save(Project project) {
       String saveTask = "INSERT INTO projects (name, "
               + "description, "
               + "created_task_list, "
               + "update_task_list ) VALUES (?, ?, ?, ?)";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       // Cria uma conexao com o banco de dados
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(saveTask);
           
           statement.setString(1, project.getName());
           statement.setString(2, project.getDescription());
           statement.setDate(3, new Date(project.getCreated_task_list().getTime()));
           statement.setDate(4, new Date(project.getUpdate_task_list().getTime()));
           
           //Executa a sql para inserir o dados no banco
           statement.execute();
           
           
       } catch (SQLException e) {
            
                throw new RuntimeException("Error when salve project : " + e.getMessage());
                
            
        }
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
    }

   
    public void upadate(Project project) {
       String sql = "UPDATE projects SET "
               + "name = ?, "
               + "description = ?, "
               + "created_task_list = ?, "
               + "update_task_list = ? "
               + "WHERE id = ?";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       // Cria uma conexao com o banco de dados
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setString(1, project.getName());
           statement.setString(2, project.getDescription());
           statement.setDate(3, new Date(project.getCreated_task_list().getTime()));
           statement.setDate(4, new Date(project.getUpdate_task_list().getTime()));
           statement.setInt(5, project.getId());
           
           // //Executa a sql para inserir o dados no banco
           statement.execute();
           
           
       }
      
       catch (SQLException ex) {
           
               throw new RuntimeException("Error when delete project : " + ex.getMessage());
           
        }
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
               
    }

   
    public void removeById(int idProject) {
        String sql = "DELETE FROM projects WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
        }
        catch(SQLException e){
            
                throw new RuntimeException("Error when delete project : " + e.getMessage());
            
        }
        finally{
            ConnectionFactory.closeConnection(connection,statement);
            
                
            }
    
        }

 
    public List<Project> getALL() {
        String sql = "SELECT * FROM projects";
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<>();
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
   
            resultSet = statement.executeQuery();
            
            //Enquanto existir dados no banco de dados, faça
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreated_task_list(resultSet.getDate("created_task_list"));
                project.setUpdate_task_list(resultSet.getDate("update_task_list"));
                
                ////Adiciono o contato recuperado, a lista de contatos
                projects.add(project);
                
            }     
            
        }
        
        catch(SQLException ex){
          
                throw new RuntimeException("Error : " + ex.getMessage());
            
        }
        
        finally{
            ConnectionFactory.closeConnection(connection,statement, resultSet);
                  
           }
        return projects;
    
        
    }

   

}
