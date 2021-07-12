/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ComboBox;

/**
 *
 * @author polod
 */
public class Curso {
    
    private int codigo; 
    private String nombre;
    private int Cantidad; 
    private String nomProfesor;
    private int profesorID;
    
    private ComboBox ProfesorComboBox;

    //para mostrar 
    public Curso(int codigo, String nombre, int Cantidad, String nomProfesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.nomProfesor = nomProfesor;
    }
    
    //para insertar 
    public Curso(int codigo, String nombre, int Cantidad, int ProfesorID) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Cantidad = Cantidad;
        this.profesorID = profesorID;
    }

    
    
    //para actualizar
    public Curso(String nombre, int Cantidad, int ProfesorID) {
        this.nombre = nombre;
        this.Cantidad = Cantidad;
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
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
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
    
    
    
    
    
}
