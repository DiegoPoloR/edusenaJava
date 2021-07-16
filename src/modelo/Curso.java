/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ComboBox;
import javax.swing.JComboBox;

/**
 *
 * @author polod
 */
public class Curso {
    
    private int codigo; 
    private String nombre;
    private int cantidad; 
    private String nomProfesor;
    private int profesorID;
    private JComboBox<String> CMBOXProfe;  
    private ComboBox comboxProfe;
    
    
    //para pasar datos del vista al controlador de agregar curso
    public Curso(int codigo, String nombre, JComboBox<String> CMBOXProfe, ComboBox comboxProfe) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nomProfesor = nomProfesor;
        this.CMBOXProfe = CMBOXProfe;
        this.comboxProfe = comboxProfe;
    }
    
   //para pasar datos del vista al controlador de actualizar curso 
   public Curso(int codigo, String nombre, int Cantidad, JComboBox<String> CMBOXProfe, ComboBox comboxProfe) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = Cantidad;
        this.nomProfesor = nomProfesor;
        this.CMBOXProfe = CMBOXProfe;
        this.comboxProfe = comboxProfe;
      
    }
    
    
    //para mostrar 
    public Curso(int codigo, String nombre, int Cantidad, String nomProfesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = Cantidad;
        this.nomProfesor = nomProfesor;
    }
    
    //para insertar 
    public Curso(int codigo, String nombre, int profesorID) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesorID = profesorID;
    }

    
    
    //para actualizar
    public Curso(int codigo, String nombre, int Cantidad, int ProfesorID) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = Cantidad;
        this.profesorID = ProfesorID;
    }


    //para eliminar
    public Curso(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public int getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }

    public JComboBox<String> getCMBOXProfe() {
        return CMBOXProfe;
    }

    public void setCMBOXProfe(JComboBox<String> CMBOXProfe) {
        this.CMBOXProfe = CMBOXProfe;
    }

    public ComboBox getComboxProfe() {
        return comboxProfe;
    }

    public void setComboxProfe(ComboBox comboxProfe) {
        this.comboxProfe = comboxProfe;
    }
    
    
    
    
    
}
