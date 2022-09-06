/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author revon
 */
public class TaskTableModel extends AbstractTableModel{
    
    
    String[] columns = {"Nome", "Drescrição", "Prazo", "Tarefa Concluida", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
       return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
        return columnIndex == 3 ? true : false;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return tasks.isEmpty() ? Object.class : this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
         switch(columnIndex){
             case 0:
                 return tasks.get(rowIndex).getName();
       
             case 1:
                 return tasks.get(rowIndex).getDescription();
                 
             case 2:
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                 return sdf.format(tasks.get(rowIndex).getDeadLine());
      
             case 3:
                 return tasks.get(rowIndex).getStatus();
                 
             case 4:
                 return "";
                 
             case 5:
                 return "";
                 
             default:    
                 return "Dado não encontrado";
         }
    }
    
    @Override
    public void setValueAt(Object avalue, int rowIndex, int columnIndex){
       tasks.get(rowIndex).setStatus((boolean) avalue);
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    
    

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
