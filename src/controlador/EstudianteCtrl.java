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
import javax.swing.JTextField;
import vista.ActualizarEstudiante;


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
       
       //Agrega los registros a la tabla de estudiantes
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
           
           //valida si los campos a ingresar estan vacios, pero solo los string, ya que los int ya se validan en el try de la vista.
           if(!e.getNombre().isEmpty() && !e.getApellidos().isEmpty() && !e.getDireccion().isEmpty() && !e.getCorreo().isEmpty() && !e.getNombreAcu().isEmpty()){
                Estudiante estu = new Estudiante(e.getIdentificacion(),e.getNombre(),e.getApellidos() , e.getEdad(), e.getDireccion(), e.getGenero(), e.getCorreo(), e.getTelefono(), e.getNombreAcu(), e.getTelfAcu(), profesor, curso);
                int registro = estudiantes.insertEstudiantes(estu);
                if(registro > 0 ) JOptionPane.showMessageDialog(null, "Datos del estudiante registrados satisfactoriamente." );
                else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );
           }
           else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
           
        
    }
    
    
    
    //Funciones para obtener los datos de actualizar del estudiante //
    
    //obtiene los datos de la tabla seleccionada 
    public Estudiante getUpdateDataEstudiantes(JTable tblEstudiantes){
        
        Estudiante estu;
        int fila = tblEstudiantes.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila"); 
        else {  
                
                String nombres = tblEstudiantes.getValueAt(fila, 1).toString();
                String apellidos = tblEstudiantes.getValueAt(fila, 2).toString();
                int edad = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 3).toString());
                String direccion = tblEstudiantes.getValueAt(fila, 4).toString();
                String genero = tblEstudiantes.getValueAt(fila, 5).toString();
                String correo = tblEstudiantes.getValueAt(fila, 6).toString();
                int telefono = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 7).toString());
                String acudiente = tblEstudiantes.getValueAt(fila, 8).toString();
                int telefonoAcu = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 9).toString());
                String profesor = tblEstudiantes.getValueAt(fila, 10).toString();
                String curso = tblEstudiantes.getValueAt(fila, 11).toString();
                
             estu = new Estudiante(0,nombres,apellidos,edad, direccion,genero, correo, telefono,acudiente, telefonoAcu, profesor, curso );
             return estu;                    
        }
        
      return null;    
    }
    
    //pasa los datos de la tabla a la vista de actualizar estudiante
    public void setUpdateData(JTable tblEstudiantes){
        
        Estudiante estu = this.getUpdateDataEstudiantes(tblEstudiantes);
        if(estu != null)
        {
            ActualizarEstudiante vistaUpdateEstu = new ActualizarEstudiante();
            vistaUpdateEstu.setVisible(true);
            vistaUpdateEstu.setUptadeData(estu);
            
        }    
    }
    
    
    //imprime los datos de la tabla en el formulario
     public void printDataUpdate(List<JTextField> txt, Estudiante e){
         txt.get(0).setText(e.getNombre());
         txt.get(1).setText(e.getApellidos());
         txt.get(2).setText(Integer.toString(e.getEdad()));
         txt.get(3).setText(e.getDireccion());
         txt.get(4).setText(e.getCorreo());
         txt.get(5).setText(Integer.toString(e.getTelefono()));
         txt.get(6).setText(e.getNombreAcu());
         txt.get(7).setText(Integer.toString(e.getTelfAcu()));
         
         
     }    
    
    
        
}

