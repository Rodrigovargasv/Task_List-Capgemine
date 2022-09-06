/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author revon
 */
public class Project {
    private int id;
    private String name;
    private String description;
    private List<Task> tasks;
    private Date created_task_list;
    private Date update_task_list;

    

    public Project(int id, String name, String description, List<Task> tasks, Date created_task_list, Date update_task_list) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.created_task_list = created_task_list;
        this.update_task_list = update_task_list;
    }

    public Project() {
        this.created_task_list = new Date();
        this.update_task_list = new Date();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Date getCreated_task_list() {
        return created_task_list;
    }

    public void setCreated_task_list(Date created_task_list) {
        this.created_task_list = created_task_list;
    }

    public Date getUpdate_task_list() {
        return update_task_list;
    }

    public void setUpdate_task_list(Date update_task_list) {
        this.update_task_list = update_task_list;
    }
    
    


    @Override
    public String toString() {
        return this.name;
    }

    
    
    
    
 
    
}
