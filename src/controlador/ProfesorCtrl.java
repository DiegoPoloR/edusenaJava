/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Profesor;
import modelo.ProfesorDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import vista.ActualizarProfesor;
import vista.EliminarProfesor;

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
     
   
    public DefaultTableModel getProfesores(){
           
       List<Profesor>profesoresData;
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
       
       return model;
    }
    
    public boolean setEstudiantes(Profesor p){
               
        //valida si los campos a ingresar estan vacios, pero solo los string, ya que los int ya se validan en el try de la vista.
        if(!p.getNombre().isEmpty() && !p.getApellidos().isEmpty() && !p.getDireccion().isEmpty() && !p.getCorreo().isEmpty()){
               
            Profesor prof = new Profesor(p.getIdentificacion(),p.getNombre(),p.getApellidos() , p.getEdad(), p.getDireccion(), p.getGenero(), p.getCorreo(), p.getTelefono());
            int registro = profesores.insertProfesor(prof);
            if(registro > 0 ){
                JOptionPane.showMessageDialog(null, "Datos del profesor registrados satisfactoriamente." );
                return true;
            }          
            else 
                JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );
        }
        else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
        return false;
    }

    public Profesor getUpdateDataProfesor(JTable tblEstudiantes){
        
        Profesor profe;
        int fila = tblEstudiantes.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila"); 
        else {                 
            int identificacion = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 0).toString());
            String nombres = tblEstudiantes.getValueAt(fila, 1).toString();
            String apellidos = tblEstudiantes.getValueAt(fila, 2).toString();
            int edad = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 3).toString());
            String direccion = tblEstudiantes.getValueAt(fila, 4).toString();
            String genero = tblEstudiantes.getValueAt(fila, 5).toString();
            String correo = tblEstudiantes.getValueAt(fila, 6).toString();
            int telefono = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 7).toString());

                
            profe = new Profesor(identificacion,nombres,apellidos,edad, direccion,genero, correo, telefono);
            return profe;                    
        }
        
      return null;    
    }
    
    //pasa los datos de la tabla a la vista de actualizar estudiante
    public void setUpdateData(JTable tblEstudiantes, DefaultTableModel model){      
        Profesor prof = this.getUpdateDataProfesor(tblEstudiantes);
        if(prof != null){
            ActualizarProfesor vistaUpdateProfe = new ActualizarProfesor();
            vistaUpdateProfe.setVisible(true);
            vistaUpdateProfe.setUptadeData(prof);
            vistaUpdateProfe.setModel(model);
            vistaUpdateProfe.setTabla(tblEstudiantes);            
        }    
    }
    
    
     public void printDataUpdate(List<JTextField> txt, Profesor p, JComboBox cmbx){
        txt.get(0).setText(Integer.toString(p.getIdentificacion()));
        txt.get(0).setEditable(false);
         
        txt.get(1).setText(p.getNombre());
        txt.get(2).setText(p.getApellidos());
        txt.get(3).setText(Integer.toString(p.getEdad()));
        txt.get(4).setText(p.getDireccion());
        txt.get(5).setText(p.getCorreo());
        txt.get(6).setText(Integer.toString(p.getTelefono()));
    
        cmbx.setSelectedItem(p.getGenero());              
     }   
     
     
    public boolean updateProfesor(Profesor p){
        
        if(!p.getNombre().isEmpty() && !p.getApellidos().isEmpty() && !p.getDireccion().isEmpty() && !p.getCorreo().isEmpty()){
            
            Profesor profesor = new Profesor(p.getIdentificacion(),p.getNombre(), p.getApellidos(), p.getEdad(), p.getDireccion(), p.getGenero(), p.getCorreo(),p.getTelefono());        
            int registro = profesores.updateProfesor(profesor);
            if(registro > 0 ){ 
                JOptionPane.showMessageDialog(null, "Datos del estudiante actualizados satisfactoriamente." );
                return true;
            }
            else 
                JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );    
        }
        else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
        return false;
        
     
     }
    
     public void mostrarVentanaEliminar(JTable tblEstudiantes, DefaultTableModel modelo){
        int fila = tblEstudiantes.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila");
        else{
            EliminarProfesor eliminarProf = new EliminarProfesor();
            eliminarProf.setVisible(true);
            eliminarProf.setModel(modelo);
            eliminarProf.setTabla(tblEstudiantes);
        }
    
    }
     
      //obtiene los datos a eliminar del estudiante y los manda a funcion a eliminar 
    public boolean getDataDeleteProfesor(JTable tblProfesor){  
        Profesor profe;
        //trae las filas de la tabla estudiante
        int fila = tblProfesor.getSelectedRow();
       
        //trae la 
        int identificacion = Integer.parseInt((String)tblProfesor.getValueAt(fila, 0).toString());
        profe = new Profesor(identificacion);
        boolean elimninado = this.DeleteEstudiante(profe);   
        
       
        return elimninado;
    }
    
 
    public boolean DeleteEstudiante(Profesor p){      
        int registro = profesores.DeleteProfesor(p);
        if(registro > 0 )return true;                  
        else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );        
        
        return false;
    }
   
     
    
    
    
}
