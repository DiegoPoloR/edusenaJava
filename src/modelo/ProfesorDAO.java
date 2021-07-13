/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProfesorDAO {
 
    //Querys del crud
    private static final String SQL_SELECT = "SELECT * FROM Profesores;";
    private static final String SQL_INSERT = "INSERT INTO estudiantes(identificacion, nombre_estudiantes, apellido_estudiantes, nombre_acudiente, direccion_estudiantes, telefono_acudiente, nombre_cursos) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE estudiantes SET nombre_estudiantes = ?, apellido_estudiantes = ?, nombre_acudiente = ?, direccion_estudiantes = ?, telefono_acudiente = ?, nombre_cursos = ? WHERE identificacion = ?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE identificacion = ?";
    
    //Querys de filtro 
    private static final String FILTER_NOMBRE = "SELECT * FROM Profesores WHERE nombres_prof = ?"; //filtra al profesor por nombre
    

    public List<Profesor> selectProfesores() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // Instancio la entidad Estudiantes.
        Profesor profesor = null;

        List<Profesor> profesores = new ArrayList<>();

        try {
            //Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            //Mandamos con el método prepareStatement(sql) 
            pstm = conn.prepareStatement(SQL_SELECT);
            // Ejecuta la consulta
            rs = pstm.executeQuery();

            while ( rs.next() ) {
               int identificacion = rs.getInt("identificacion_prof");
                String nombre = rs.getString("nombres_prof");
                String apellido = rs.getString("apellidos_prof");
                int edad= rs.getInt("edad_prof");
                String direccion = rs.getString("direccion_prof");          
                String genero = rs.getString("genero_prof"); 
                String correo = rs.getString("correo_prof");
                int telefono = rs.getInt("telefono_prof");                          
            
               

                //Llamamos al constructor Estudiantes de la entidad
                profesor =  new Profesor(identificacion, nombre, apellido, edad, direccion, genero, correo, telefono);
                //Agrego la entidad (un estudiante) a un ArrayList<>();
                profesores.add(profesor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return profesores;
    }
    
    
   
}





