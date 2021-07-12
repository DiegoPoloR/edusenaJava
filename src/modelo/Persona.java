/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author polod
 */
public class Persona {
 
    
    private int identificacion; 
    private String nombre; 
    private String apellidos; 
    private int edad; 
    private String direccion; 
    private String genero; 
    private String correo; 
    private int telefono; 

    public Persona(int identificacion, String nombre, String apellidos, int edad, String direccion, String genero, String correo, int telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellidos, int edad, String direccion, String genero, String correo, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
    } 

    public Persona(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
    
    
    
    
    
}
