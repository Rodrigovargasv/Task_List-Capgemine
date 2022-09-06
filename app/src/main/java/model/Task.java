/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author revon
 */
public class Task {
    private int id;
    private int id_project;
    private String name;
    private String description;
    private boolean status;
    private String nodes;
    private Date deadLine;
    private Date created_task_list;
    private Date update_task_list;
    
    /**
     *
     */
    
    
   
    
    public Task() {
        this.deadLine = new Date();
        this.created_task_list = new Date();
        this.update_task_list = new Date();
    }
    

    public Task(int id, int id_project, String name, String description, boolean status, String nodes, Date deadLine, Date created_task, Date update_task) {
        this.id = id;
        this.id_project = id_project;
        this.name = name;
        this.description = description;
        this.status = status;
        this.nodes = nodes;
        this.deadLine = deadLine;
        this.created_task_list = created_task;
        this.update_task_list = 
        this.update_task_list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Date getCreated_task() {
        return created_task_list;
    }

    public void setCreated_task(Date created_task) {
        this.created_task_list = created_task;
    }

    public Date getUpdate_task() {
        return update_task_list;
    }

    public void setUpdate_task(Date update_task) {
        this.update_task_list = update_task;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
    
    
    
}
