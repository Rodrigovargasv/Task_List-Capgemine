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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;
import ultil.ConnectionFactory;

/**
 *
 * @author revon
 */
public class TaskController {

    

   
    public void save(Task task) {
       String saveTask = "INSERT INTO task (id_project, "
               + "name, "
               + "description, "
               + "status, "
               + "nodes, "
               + "deadLine,"
               + "created_task_list, "
               + "update_task_list ) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       //Cria uma conex�o com o banco
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(saveTask);
           statement.setInt(1, task.getId_project());
           statement.setString(2, task.getName());
           statement.setString(3, task.getDescription());
           statement.setBoolean(4, task.getStatus());
           statement.setString(5, task.getNodes());
           statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
           statement.setDate(7, new java.sql.Date(task.getCreated_task().getTime()));
           statement.setDate(8, new java.sql.Date(task.getUpdate_task().getTime()));
           
           //Executa a sql para inser��o dos dados
           statement.execute();
           
           
           
       } 
       catch (SQLException ex) {
            
            throw new RuntimeException("Error when delete task : " + ex.getMessage());
            
        }
       // fecha a conexão com banco de dados
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
    }


    public void update(Task task) {
       String sql = "UPDATE task SET id_project = ?,"
               + "name = ?, "
               + "description = ?, "
               + "status = ?,"
               + "nodes = ?,"
               + "deadline = ?, "
               + "created_task_list = ?, "
               + "update_task_list = ? WHERE id = ?";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setInt(1, task.getId_project());
           statement.setString(2, task.getName());
           statement.setString(3, task.getDescription());
           statement.setBoolean(4, task.getStatus());
           statement.setString(5, task.getNodes());
           statement.setDate(6, new Date(task.getDeadLine().getTime()));
           statement.setDate(7, new Date(task.getCreated_task().getTime()));
           statement.setDate(8, new Date(task.getUpdate_task().getTime()));
           statement.setInt(9, task.getId());
           statement.execute();
           
           
       }
      
       catch (SQLException ex) {
           
            throw new RuntimeException("Error: " + ex.getMessage());
           
        }
       finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
               
    }

   
    public void removeById(int taskId) {
        String sql = "DELETE FROM TASK WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }
        catch(SQLException ex){
            
            throw new RuntimeException("Error when delete task : " + ex.getMessage());
            
        }
        finally{
            ConnectionFactory.closeConnection(connection,statement);
            
                
            }
    
        }


    public List<Task> getALL(int idProject) {
        String sql = "SELECT * FROM task";

        Connection connection = null;
        PreparedStatement statement = null;
        List<Task> tasks = new ArrayList<>();
        
        ResultSet resultSet = null;
         
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Task task = new Task();
                
                task.setId(resultSet.getInt("id"));
                task.setId_project(resultSet.getInt("id_project"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNodes(resultSet.getString("nodes"));
                task.setStatus(resultSet.getBoolean("status"));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setCreated_task(resultSet.getDate("created_task_list"));
                task.setUpdate_task(resultSet.getDate("update_task_list"));
                
                
                tasks.add(task);
                
            }     
            
        }
        
        catch(SQLException ex){
            
            throw new RuntimeException("Error : " + ex.getMessage());
            
        }
        
        finally{
            ConnectionFactory.closeConnection(connection,statement, resultSet);
                  
           }
        return tasks;
    
        
    }
    public List<Task> getByProjectId(int id) {
        String sql = "SELECT * FROM task where id_Project = ?";

        List<Task> tasks = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            rset = stmt.executeQuery();

            //Enquanto existir dados no banco de dados, fa�a
            while (rset.next()) {

                Task task = new Task();

                task.setId(rset.getInt("id"));
                task.setId_project(rset.getInt("id_Project"));
                task.setName(rset.getString("name"));
                task.setDescription(rset.getString("description"));
                task.setStatus(rset.getBoolean("status"));
                task.setNodes(rset.getString("nodes"));
                task.setDeadLine(rset.getDate("deadline"));
                task.setCreated_task(rset.getDate("created_task_list"));
                task.setUpdate_task(rset.getDate("update_task_list"));

                //Adiciono o contato recuperado, a lista de contatos
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas", ex);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
        return tasks;
        
    
    }
}
