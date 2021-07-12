/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Estudiante;
import modelo.EstudiantesDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author polod
 */
public class EstudianteCtrl {
    
    private final EstudiantesDAO estudiantes = new EstudiantesDAO(); 
   private JTable table; 

    public EstudianteCtrl() {
    }

    public EstudianteCtrl(JTable table) {
        this.table = table;
    }
     
   
    public void getEstudiantes(){
           
       List<Estudiante>estudiantesData = new ArrayList<>();
       estudiantesData = estudiantes.selectEstudiantes(); 
           
       
       DefaultTableModel model;
       
       Object[] RowsEstudiantes = new Object[12];
       model = (DefaultTableModel)table.getModel();
       
       for(Estudiante e : estudiantesData){   
           RowsEstudiantes[0]= e.getIdentificacion();
           RowsEstudiantes[1]= e.getNombre();
           RowsEstudiantes[2]= e.getApellidos();
           RowsEstudiantes[3]= e.getEdad();
           RowsEstudiantes[4]= e.getDireccion();
           RowsEstudiantes[5]= e.getGenero();
           RowsEstudiantes[6]= e.getCorreo();
           RowsEstudiantes[7]= e.getTelefono();
           RowsEstudiantes[8]= e.getNombreAcu();
           RowsEstudiantes[9]= e.getTelfAcu();
           RowsEstudiantes[10]= e.getProfesor();
           RowsEstudiantes[11]= e.getCurso();
                
           model.addRow(RowsEstudiantes);   
       } 
       table.setModel(model);                   
    }
    
    
    public void setEstudiantes(Estudiante e){
        
           //Profesor Seleccionado 
           ComboBox cmbxProf =e.getProfesorCombox();
           int profesor = cmbxProf.SelecionComboBoxProfesor(e.getProfesorCMBX());
           
           //Curso Seleccionado 
           ComboBox cmbxCursos =e.getCursosCombox();
           int curso = cmbxCursos.SelecionComboBoxCurso(e.getCursoCMBX());
           
           Estudiante estu = new Estudiante(e.getIdentificacion(), e.getNombre(), e.getApellidos(), e.getEdad(), e.getDireccion(), e.getGenero(), e.getCorreo(), e.getTelefono(), e.getNombreAcu(), e.getTelfAcu(), profesor, curso);
           int registro = estudiantes.insertEstudiantes(estu);
           if(registro > 0 ) JOptionPane.showMessageDialog(null, "Datos del estudiante registrados satisfactoriamente." );
           else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );
           
        
         
        
        
       }
    
}
