/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Profesor;
import modelo.ProfesorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author polod
 */
public class ProfesorCtrl {
 
   private final ProfesorDAO profesores = new ProfesorDAO(); 
   private JTable table; 

 
    public ProfesorCtrl() {
    }

    public ProfesorCtrl(JTable table) {
        this.table = table;
    }
     
   
    public void getProfesores(){
           
       List<Profesor>profesoresData = new ArrayList<>();
       profesoresData = profesores.selectProfesores(); 
           
       DefaultTableModel model;
       
       Object[] RowsProfesores = new Object[8];
       model = (DefaultTableModel)table.getModel();
       
       for(Profesor e : profesoresData){   
           RowsProfesores[0]= e.getIdentificacion();
           RowsProfesores[1]= e.getNombre();
           RowsProfesores[2]= e.getApellidos();
           RowsProfesores[3]= e.getEdad();
           RowsProfesores[4]= e.getDireccion();
           RowsProfesores[5]= e.getGenero();
           RowsProfesores[6]= e.getCorreo();
           RowsProfesores[7]= e.getTelefono();
             
           model.addRow(RowsProfesores);   
       } 
       table.setModel(model);                   
    }

    
}
