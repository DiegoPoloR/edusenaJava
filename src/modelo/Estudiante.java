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
public class Estudiante extends Persona{
    
    private String nombreAcu; 
    private String telfAcu; 
    private String nomProfesor;
    private String nomCurso; 
    private int profesorID;
    private int cursoID;
    private JComboBox<String> profesorCMBX;
    private JComboBox<String> cursoCMBX;
    private ComboBox profesorCombox;
    private ComboBox cursosCombox;


    //para llevar datos de la vista al controlador para insertar
    public Estudiante(int identificacion, String nombre, String apellidos, int edad, String direccion, String genero, String correo, String telefono, String nombreAcu, String telfAcu, JComboBox<String> profesorCMBX, JComboBox<String> cursoCMBX, ComboBox profesorCombox, ComboBox cursosCombox) {    
        super(identificacion, nombre, apellidos, edad, direccion, genero, correo, telefono);
        this.nombreAcu = nombreAcu;
        this.telfAcu = telfAcu;
        this.profesorCMBX = profesorCMBX;
        this.cursoCMBX = cursoCMBX;
        this.profesorCombox = profesorCombox;
        this.cursosCombox = cursosCombox;
    }
    

    //para mostrar

    public Estudiante(int identificacion, String nombre, String apellidos, int edad, String direccion, String genero, String correo, String telefono, String nombreAcu, String telfAcu, String nomProfesor, String nomCurso) {
        super(identificacion, nombre, apellidos, edad, direccion, genero, correo, telefono);
        this.nombreAcu = nombreAcu;
        this.telfAcu = telfAcu;
        this.nomProfesor = nomProfesor;
        this.nomCurso = nomCurso;
    }
    
    //´para insertar
    public Estudiante(int identificacion, String nombre, String apellidos, int edad, String direccion, String genero, String correo, String telefono, String nombreAcu, String telfAcu, int profesorID, int cursoID) {    
        super(identificacion, nombre, apellidos, edad, direccion, genero, correo, telefono);
        this.nombreAcu = nombreAcu;
        this.telfAcu = telfAcu;
        this.profesorID = profesorID;
        this.cursoID = cursoID;
    }

    //para actualizar

    public Estudiante(String nombre, String apellidos, int edad, String direccion, String genero, String correo, String telefono, String nombreAcu, String telfAcu, int profesorID, int cursoID) {
        super(nombre, apellidos, edad, direccion, genero, correo, telefono);
        this.nombreAcu = nombreAcu;
        this.telfAcu = telfAcu;
        this.profesorID = profesorID;
        this.cursoID = cursoID;
    }
    

    //para elmimnar
    

    public Estudiante(int identificacion) {
        super(identificacion);
    }

    public String getNombreAcu() {
        return nombreAcu;
    }

    public void setNombreAcu(String nombreAcu) {
        this.nombreAcu = nombreAcu;
    }

    public String getTelfAcu() {
        return telfAcu;
    }

    public void setTelfAcu(String telfAcu) {
        this.telfAcu = telfAcu;
    }

    public String getProfesor() {
        return nomProfesor;
    }

    public void setProfesor(String profesor) {
        this.nomProfesor = profesor;
    }

    public String getCurso() {
        return nomCurso;
    }

    public void setCurso(String curso) {
        this.nomCurso = curso;
    }

    public int getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(int profesorID) {
        this.profesorID = profesorID;
    }

    public int getCursoID() {
        return cursoID;
    }

    public void setCursoID(int cursoID) {
        this.cursoID = cursoID;
    }

    public JComboBox<String> getProfesorCMBX() {
        return profesorCMBX;
    }

    public void setProfesorCMBX(JComboBox<String> profesorCMBX) {
        this.profesorCMBX = profesorCMBX;
    }

    public JComboBox<String> getCursoCMBX() {
        return cursoCMBX;
    }

    public void setCursoCMBX(JComboBox<String> cursoCMBX) {
        this.cursoCMBX = cursoCMBX;
    }

    public ComboBox getProfesorCombox() {
        return profesorCombox;
    }

    public ComboBox getCursosCombox() {
        return cursosCombox;
    }
    
}
