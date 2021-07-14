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

/**
 *
 * @author polod
 */
public class EstudiantesDAO {
 
    private static final String SQL_SELECT = "SELECT  estu.identificacion_estu, estu.nombres_estu, estu.apellidos_estu, estu.edad_estu, estu.direccion_estu, estu.genero_estu, estu.correo_estu, estu.telefono_estu, estu.nombre_acu_estu, estu.telefono_acu_estu, prof.nombres_prof, prof.apellidos_prof, cur.nombre_curso FROM estudiantes estu INNER JOIN profesores prof ON estu.id_prof_estu  = prof.identificacion_prof INNER JOIN cursos cur ON estu.codigo_curso_estu = cur.codigo_curso ORDER BY estu.nombres_estu;";
    private static final String SQL_INSERT = "INSERT INTO estudiantes(identificacion_estu,nombres_estu, apellidos_estu, edad_estu, direccion_estu, genero_estu, correo_estu, telefono_estu,nombre_acu_estu, telefono_acu_estu, id_prof_estu, codigo_curso_estu) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE estudiantes SET nombres_estu = ?, apellidos_estu = ?, edad_estu = ?, direccion_estu = ?, genero_estu = ?, correo_estu = ?, telefono_estu = ?, nombre_acu_estu = ?, telefono_acu_estu = ?, id_prof_estu = ?, codigo_curso_estu = ? WHERE identificacion_estu = ?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE identificacion_estu = ?";

    public List<Estudiante> selectEstudiantes() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // Instancio la entidad Estudiantes.
        Estudiante estudiante = null;

        List<Estudiante> estudiantes = new ArrayList<>();

        try {
            //Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            //Mandamos con el método prepareStatement(sql) 
            pstm = conn.prepareStatement(SQL_SELECT);
            // Ejecuta la consulta
            rs = pstm.executeQuery();

            while ( rs.next() ) {
                int identificacionEstudiante = rs.getInt("identificacion_estu");
                String nombreEstudiante = rs.getString("nombres_estu");
                String apellidoEstudiante = rs.getString("apellidos_estu");
                int edadEstudiante = rs.getInt("edad_estu");
                String direccionEstudiante = rs.getString("direccion_estu");                       
                String generoEstudiante = rs.getString("genero_estu"); 
                String correoEstudiante = rs.getString("correo_estu");
                int telefonoEstudiante = rs.getInt("telefono_estu");                          
                String nombreAcudiente = rs.getString("nombre_acu_estu");
                int telefonoAcudiente = rs.getInt("telefono_acu_estu");
                String nombreCurso = rs.getString("nombre_curso");
                String nombreProfesor = rs.getString("nombres_prof") + " " +rs.getString("apellidos_prof") ;
                
                System.out.println(direccionEstudiante);

                //Llamamos al constructor Estudiantes de la entidad
                estudiante =  new Estudiante(identificacionEstudiante, nombreEstudiante, apellidoEstudiante, edadEstudiante, direccionEstudiante, generoEstudiante, correoEstudiante, telefonoEstudiante, nombreAcudiente, telefonoAcudiente , nombreProfesor, nombreCurso);
                //Agrego la entidad (un estudiante) a un ArrayList<>();
                estudiantes.add(estudiante);
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
        return estudiantes;
    }
  
    public int insertEstudiantes(Estudiante estudiante){
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
            
            System.out.println(estudiante.getEdad());
            pstm.setInt(1, estudiante.getIdentificacion()); 
            pstm.setString(2, estudiante.getNombre());      
            pstm.setString(3, estudiante.getApellidos());   
            pstm.setInt(4, estudiante.getEdad());              
            pstm.setString(5, estudiante.getDireccion());    
            pstm.setString(6, estudiante.getGenero());         
            pstm.setString(7, estudiante.getCorreo());          
            pstm.setInt(8, estudiante.getTelefono());           
            pstm.setString(9, estudiante.getNombreAcu());       
            pstm.setInt(10, estudiante.getTelfAcu());           
            pstm.setInt(11, estudiante.getProfesorID());
            pstm.setInt(12, estudiante.getCursoID());
            
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
    
    public int updateEstudiantes(Estudiante estudiante){
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
            
            pstm.setString(1, estudiante.getNombre());      
            pstm.setString(2, estudiante.getApellidos());   
            pstm.setInt(3, estudiante.getEdad());              
            pstm.setString(4, estudiante.getDireccion());    
            pstm.setString(5, estudiante.getGenero());         
            pstm.setString(6, estudiante.getCorreo());          
            pstm.setInt(7, estudiante.getTelefono());           
            pstm.setString(8, estudiante.getNombreAcu());       
            pstm.setInt(9, estudiante.getTelfAcu());           
            pstm.setInt(10, estudiante.getProfesorID());
            pstm.setInt(11, estudiante.getCursoID());
            pstm.setInt(12, estudiante.getIdentificacion()); 
            
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

    


    public int DeleteEstudiante(Estudiante estudiante){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, estudiante.getIdentificacion());

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
