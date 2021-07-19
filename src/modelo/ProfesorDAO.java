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
    private static final String SQL_SELECT = "SELECT * FROM Profesores ORDER BY nombres_prof;";
    private static final String SQL_INSERT = "INSERT INTO Profesores(identificacion_prof,nombres_prof, apellidos_prof, edad_prof, direccion_prof, genero_prof, correo_prof, telefono_prof) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE Profesores SET nombres_prof= ?, apellidos_prof = ?, edad_prof = ?, direccion_prof = ?, genero_prof = ?, correo_prof= ?, telefono_prof= ? WHERE identificacion_prof = ?";
    private static final String SQL_DELETE = "DELETE FROM Profesores WHERE identificacion_prof = ?";


    
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
                String telefono = rs.getString("telefono_prof");                          
            
               

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
    
    
    public int insertProfesor(Profesor p){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;
        /*Estudiante(int codigo, String nombre, String apellidos, int edad, String direccion, 
        int identificacion, String genero, String correo, int telefono, String nombreAcu, 
        int telfAcu, String profesor, String curso)
        */
        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_INSERT);
            
            pstm.setInt   (1, p.getIdentificacion()); 
            pstm.setString(2, p.getNombre());        
            pstm.setString(3, p.getApellidos()); 
            pstm.setInt   (4, p.getEdad());
            pstm.setString(5, p.getDireccion());  
            pstm.setString(6, p.getGenero());
            pstm.setString(7, p.getCorreo()); 
            pstm.setString   (8, p.getTelefono());
                  
          //Nos regresa el numero de registros afectados.
            registro = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
        
    }
    
         public int updateProfesor(Profesor profesor){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;
        /*Estudiante(int codigo, String nombre, String apellidos, int edad, String direccion, 
        int identificacion, String genero, String correo, int telefono, String nombreAcu, 
        int telfAcu, String profesor, String curso)
        */
        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_UPDATE);
            
            pstm.setString(1, profesor.getNombre());      
            pstm.setString(2, profesor.getApellidos());   
            pstm.setInt(3, profesor.getEdad());              
            pstm.setString(4, profesor.getDireccion());    
            pstm.setString(5, profesor.getGenero());         
            pstm.setString(6, profesor.getCorreo());          
            pstm.setString(7, profesor.getTelefono());           
            pstm.setInt(8, profesor.getIdentificacion()); 
       
            //Nos regresa el numero de registros afectados.
            registro = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
    }
         
         
    public int DeleteProfesor(Profesor profesor){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, profesor.getIdentificacion());

            //Nos regresa el numero de registros afectados.
            registro = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registro;
    }
    

    
    
   
}





