/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Curso;
import modelo.CursoDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import vista.ActualizarCurso;
import vista.EliminarCurso;



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
     
    public DefaultTableModel getCursos(){
           
       List<Curso>cursosData;
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
       return model;
    }
    
    public boolean setCurso(Curso c){
        
        //Profesor Seleccionado 
        ComboBox cmbxProf =c.getComboxProfe();
        //devuelve el id de l profesor seleccionado
        int profesor = cmbxProf.SelecionComboBoxProfesor(c.getCMBOXProfe());
                    
        //valida si los campos a ingresar estan vacios, pero solo los string, ya que los int ya se validan en el try de la vista.
        if(!c.getNombre().isEmpty()){    
            Curso curso = new Curso(c.getCodigo(),c.getNombre(), profesor);
            int registro = cursos.insertCurso(curso);
            if(registro > 0 ){
                JOptionPane.showMessageDialog(null, "Datos del curso registrados satisfactoriamente." );
                return true;
            }else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );
        }
        else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
        return false;
    }
    
    //extrae los datos de la tabla seleccionada en listar cursos
     public Curso getUpdateDataCurso(JTable tblCurso){    
        Curso curso;
        int fila = tblCurso.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila"); 
        else {                 
            int codigo = Integer.parseInt((String)tblCurso.getValueAt(fila, 0).toString());
            String nombre = tblCurso.getValueAt(fila, 1).toString();
            int cantidad = Integer.parseInt((String)tblCurso.getValueAt(fila, 2).toString());
            String nombreProfe = tblCurso.getValueAt(fila, 3).toString();
            
            curso = new Curso(codigo, nombre, cantidad, nombreProfe);
            
            return curso;                  
        }
        
      return null;    
    }
    
    //toma los doatos de la ventana de listar estudiante 
    public void setUpdateData(JTable tblCurso, DefaultTableModel model){      
        Curso curso = this.getUpdateDataCurso(tblCurso);
        if(curso != null){
            ActualizarCurso vistaUpdateEstu = new ActualizarCurso();
            vistaUpdateEstu.setVisible(true);
            vistaUpdateEstu.setUptadeData(curso);
            vistaUpdateEstu.setModel(model);
            vistaUpdateEstu.setTabla(tblCurso);            
        }    
    }
       
    
    public void printDataUpdate(List<JTextField> txt, Curso c, JComboBox cmbx, ComboBox cmbxInstace){
        txt.get(0).setText(Integer.toString(c.getCodigo()));
        txt.get(0).setEditable(false);
         
        txt.get(1).setText(c.getNombre());
        txt.get(2).setText(Integer.toString(c.getCantidad()));
           
        cmbxInstace.getProfesoresComboBox();      
        cmbx.setSelectedItem(c.getNomProfesor());            
     } 
    
    public boolean updateCurso(Curso c){
         
        //Profesor Seleccionado 
        ComboBox cmbxProf =c.getComboxProfe();
        int profesor = cmbxProf.SelecionComboBoxProfesor(c.getCMBOXProfe());
           
        if(!c.getNombre().isEmpty()){
            
            Curso curso = new Curso(c.getCodigo(),c.getNombre(), c.getCantidad(),profesor);        
            int registro = cursos.updateCurso(curso);
            if(registro > 0 ){ 
                JOptionPane.showMessageDialog(null, "Datos del curso actualizados satisfactoriamente." );
                return true;
            }
            else 
                JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );    
        }
        else JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios."); 
        return false;
     }
     
    public void mostrarVentanaEliminar(JTable tblCurso, DefaultTableModel modelo){
        int fila = tblCurso.getSelectedRow();
        if(fila == -1)JOptionPane.showMessageDialog(null,"Selecione la fila");
        else{
            EliminarCurso eliminarEstu = new EliminarCurso();
            eliminarEstu.setVisible(true);
            eliminarEstu.setModel(modelo);
            eliminarEstu.setTabla(tblCurso);
        }
    }
    
    public boolean getDatosEliminarCurso(JTable tblCurso){  
        Curso curso;
        //trae las filas de la tabla estudiante
        int fila = tblCurso.getSelectedRow();
       
        //trae la 
        int codigo = Integer.parseInt((String)tblCurso.getValueAt(fila, 0).toString());
        curso = new Curso(codigo);
        System.out.println(curso.getCodigo());
        boolean elimninado = this.DeleteCurso(curso); 
        
        return elimninado;
    }
     
         //elimina curso de la base de datos
    public boolean DeleteCurso(Curso c){      
        int registro = cursos.DeleteCurso(c);
        if(registro > 0 )return true;                  
        else JOptionPane.showMessageDialog(null, "Alguno de los datos están puesto de forma repetida." );        
        
        return false;
    }
    
    public void filtrarPorProfesor(JTable tabla,DefaultTableModel model,  ComboBox cmbxProfesor, JComboBox<String> CMBXProfe){
        
        this.ActualizarDatosTabla(tabla, model);
        
        int idProfe = cmbxProfesor.SelecionComboBoxProfesor(CMBXProfe);
        List<Curso> cursosData =  cursos.filtarPorProfesor(idProfe);
      
        if(!cursosData.isEmpty()){
            
            DefaultTableModel modelo;
            Object[] RowsCursos = new Object[12];
            modelo = (DefaultTableModel)tabla.getModel();
            for(Curso c : cursosData){   
                RowsCursos[0]= c.getCodigo();
                RowsCursos[1]= c.getNombre();
                RowsCursos[2]= c.getCantidad();
                RowsCursos[3]= c.getNomProfesor();
        
                model.addRow(RowsCursos);   
            } 
            tabla.setModel(model);   
        }      
        else JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con este profesor" );           
    }
    
    public void ActualizarDatosTabla(JTable tabla, DefaultTableModel model){
        EstudianteCtrl tblEstu = new EstudianteCtrl(tabla);
        model.setRowCount(0);    
    }
  

    
    
}
