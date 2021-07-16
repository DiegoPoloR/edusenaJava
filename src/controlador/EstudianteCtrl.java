/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Estudiante;
import modelo.EstudiantesDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import vista.ActualizarEstudiante;
import javax.swing.JComboBox;
import vista.EliminarEstudiante;
import vista.FiltrarEstuPorCurso;
import vista.FiltrarEstuPorProfesor;


/**
 *
 * @author polod
 */
public class EstudianteCtrl {
    
    private final EstudiantesDAO estudiantes = new EstudiantesDAO(); 
    private JTable table; 

    public EstudianteCtrl(){
    }

    public EstudianteCtrl(JTable table) {
        this.table = table;
    }
    
    public DefaultTableModel getEstudiantes(){        
       List<Estudiante>estudiantesData;
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
       return model;
    }
    
    
    public boolean setEstudiantes(Estudiante e){
        
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
            if(registro > 0 ){
                JOptionPane.showMessageDialog(null, "Datos del estudiante registrados satisfactoriamente." );
                return true;
            }          
            else 
                JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );
        }
        else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
        return false;
    }
    
    public boolean updateEstudiantes(Estudiante e){
         
        //Profesor Seleccionado 
        ComboBox cmbxProf =e.getProfesorCombox();
        int profesor = cmbxProf.SelecionComboBoxProfesor(e.getProfesorCMBX());
           
        //Curso Seleccionado 
        ComboBox cmbxCursos =e.getCursosCombox();
        int curso = cmbxCursos.SelecionComboBoxCurso(e.getCursoCMBX());
        
        if(!e.getNombre().isEmpty() && !e.getApellidos().isEmpty() && !e.getDireccion().isEmpty() && !e.getCorreo().isEmpty() && !e.getNombreAcu().isEmpty()){
            
            Estudiante estudiante = new Estudiante(e.getIdentificacion(),e.getNombre(), e.getApellidos(), e.getEdad(), e.getDireccion(), e.getGenero(), e.getCorreo(), e.getTelefono(),e.getNombreAcu() , e.getTelfAcu(), profesor,curso);        
            int registro = estudiantes.updateEstudiantes(estudiante);
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
    
    //Funciones para obtener los datos de actualizar del estudiante 
     
    //obtiene los datos de la tabla seleccionada 
    public Estudiante getUpdateDataEstudiantes(JTable tblEstudiantes){
        
        Estudiante estu;
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
            String acudiente = tblEstudiantes.getValueAt(fila, 8).toString();
            int telefonoAcu = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 9).toString());
            String profesor = tblEstudiantes.getValueAt(fila, 10).toString();
            String curso = tblEstudiantes.getValueAt(fila, 11).toString();
                
            estu = new Estudiante(identificacion,nombres,apellidos,edad, direccion,genero, correo, telefono,acudiente, telefonoAcu, profesor, curso );
            return estu;                    
        }
        
      return null;    
    }
    
    //pasa los datos de la tabla a la vista de actualizar estudiante
    public void setUpdateData(JTable tblEstudiantes, DefaultTableModel model){      
        Estudiante estu = this.getUpdateDataEstudiantes(tblEstudiantes);
        if(estu != null){
            ActualizarEstudiante vistaUpdateEstu = new ActualizarEstudiante();
            vistaUpdateEstu.setVisible(true);
            vistaUpdateEstu.setUptadeData(estu);
            vistaUpdateEstu.setModel(model);
            vistaUpdateEstu.setTabla(tblEstudiantes);            
        }    
    }
       
    //imprime los datos de la tabla en el formulario
    public void printDataUpdate(List<JTextField> txt, Estudiante e, List<JComboBox> cmbx, List<ComboBox> cmbxInstace){
        txt.get(0).setText(Integer.toString(e.getIdentificacion()));
        txt.get(0).setEditable(false);
         
        txt.get(1).setText(e.getNombre());
        txt.get(2).setText(e.getApellidos());
        txt.get(3).setText(Integer.toString(e.getEdad()));
        txt.get(4).setText(e.getDireccion());
        txt.get(5).setText(e.getCorreo());
        txt.get(6).setText(Integer.toString(e.getTelefono()));
        txt.get(7).setText(e.getNombreAcu());
        txt.get(8).setText(Integer.toString(e.getTelfAcu()));
         
        
        cmbxInstace.get(0).getProfesoresComboBox();     
        cmbxInstace.get(1).getCursosComboBox();  
        
        cmbx.get(0).setSelectedItem(e.getProfesor());
        cmbx.get(1).setSelectedItem(e.getCurso());
        cmbx.get(2).setSelectedItem(e.getGenero());
               
     }   
    
   public void mostrarVentanaEliminar(JTable tblEstudiantes, DefaultTableModel modelo){
        int fila = tblEstudiantes.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila");
        else{
            EliminarEstudiante eliminarEstu = new EliminarEstudiante();
            eliminarEstu.setVisible(true);
            eliminarEstu.setModel(modelo);
            eliminarEstu.setTabla(tblEstudiantes);
        } 
    }
        
    //obtiene los datos a eliminar del estudiante y los manda a funcion a eliminar 
    public boolean getDataDeleteEstudiante(JTable tblEstudiantes){  
        Estudiante estu;
        //trae las filas de la tabla estudiante
        int fila = tblEstudiantes.getSelectedRow();
       
        //trae la 
        int identificacion = Integer.parseInt((String)tblEstudiantes.getValueAt(fila, 0).toString());
        estu = new Estudiante(identificacion);
        boolean elimninado = this.DeleteEstudiante(estu);     
        
       
        return elimninado;
    }
    
    //elimina a los estudiantes
    public boolean DeleteEstudiante(Estudiante e){      
        int registro = estudiantes.DeleteEstudiante(e);
        if(registro > 0 )return true;                  
        else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );        
        
        return false;
    }
   
    public void seleccionDeFiltro(JTable tabla, DefaultTableModel model, JComboBox<String> cmbx){  
       String seleccion = (String)cmbx.getSelectedItem();
       if(seleccion.equals("Profesor"))
          this.VentanaFiltrarPorProfesor(tabla, model); 
       else if(seleccion.equals("Curso"))
          this.VentanaFiltrarPorCurso(tabla, model);       
     }        
            
    public void VentanaFiltrarPorCurso(JTable tabla, DefaultTableModel model){  
        FiltrarEstuPorCurso filtrarCurso = new FiltrarEstuPorCurso();
        filtrarCurso.setVisible(true); 
        filtrarCurso.setTabla(tabla);
        filtrarCurso.setModel(model);
        
     }
     
    public void VentanaFiltrarPorProfesor(JTable tabla, DefaultTableModel model ){  
        FiltrarEstuPorProfesor filtrarProfe = new FiltrarEstuPorProfesor();
        filtrarProfe.setVisible(true); 
        filtrarProfe.setTabla(tabla);
        filtrarProfe.setModel(model);
     }
    
    public void filtrarPorCurso(JTable tabla,DefaultTableModel model,  ComboBox cmbxCurso, JComboBox<String> CMBXcurso){
        
        this.ActualizarDatosTabla(tabla, model);
        
        int idCurso = cmbxCurso.SelecionComboBoxCurso(CMBXcurso);
        List<Estudiante> estudiantesData =  estudiantes.filtarPorCurso(idCurso);
      
        if(!estudiantesData.isEmpty()){
            
            DefaultTableModel modelo;
            Object[] RowsEstudiantes = new Object[12];
            modelo = (DefaultTableModel)tabla.getModel();
            
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
                
                modelo.addRow(RowsEstudiantes);         
            }
          tabla.setModel(modelo);          
       }else JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con este curso" );      
    }
    
    public void filtrarPorProfesor(JTable tabla,DefaultTableModel model,  ComboBox cmbxProfesor, JComboBox<String> CMBXProfe){
        
        this.ActualizarDatosTabla(tabla, model);
        
        int idProfe = cmbxProfesor.SelecionComboBoxProfesor(CMBXProfe);
        List<Estudiante> estudiantesData =  estudiantes.filtarPorProfesor(idProfe);
      
        if(!estudiantesData.isEmpty()){
            
            DefaultTableModel modelo;
            Object[] RowsEstudiantes = new Object[12];
            modelo = (DefaultTableModel)tabla.getModel();
            
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
                
                modelo.addRow(RowsEstudiantes);         
            }
          tabla.setModel(modelo);          
       } 
        
        else JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con este profesor" );      
       
    }
    
    
    public void ActualizarDatosTabla(JTable tabla, DefaultTableModel model){
        EstudianteCtrl tblEstu = new EstudianteCtrl(tabla);
        model.setRowCount(0);
       
        
    }
    
    
    
    
     
     
  }
    
 

