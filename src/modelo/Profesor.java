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
public class Profesor extends Persona {

    public Profesor(int identificacion, String nombre, String apellidos, int edad, String direccion, String genero, String correo, int telefono) {
        super(identificacion, nombre, apellidos, edad, direccion, genero, correo, telefono);
    }

    public Profesor(String nombre, String apellidos, int edad, String direccion, String genero, String correo, int telefono) {
        super(nombre, apellidos, edad, direccion, genero, correo, telefono);
    }

    public Profesor(int identificacion) {
        super(identificacion);
    }
    
    
    
    
}
