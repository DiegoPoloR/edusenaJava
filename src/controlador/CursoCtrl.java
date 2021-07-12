/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Curso;
import modelo.CursoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author polod
 */
public class CursoCtrl {
    
    private CursoDAO cursos = new CursoDAO();
    private JTable table; 

  
    public CursoCtrl() {
    }

    public CursoCtrl(JTable table) {
        this.table = table;
    }
     
   
    public void getCursos(){
           
       List<Curso>cursosData = new ArrayList<>();
       cursosData = cursos.selectCursos(); 
           
       DefaultTableModel model;
       
       Object[] RowsCursos = new Object[4];
       model = (DefaultTableModel)table.getModel();
       
       for(Curso c : cursosData){   
           RowsCursos[0]= c.getCodigo();
           RowsCursos[1]= c.getNombre();
           RowsCursos[2]= c.getCantidad();
           RowsCursos[3]= c.getNomProfesor();

             
           model.addRow(RowsCursos);   
       } 
       table.setModel(model);                   
    }

    
    
}
