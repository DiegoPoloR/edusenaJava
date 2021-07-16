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


public class CursoDAO {
    
    private static final String SQL_SELECT = "SELECT  cur.codigo_curso, cur.nombre_curso, cur.cant_estu_curso, prof.nombres_prof, prof.apellidos_prof FROM cursos cur INNER JOIN profesores prof ON cur.id_prof_curso  = prof.identificacion_prof;";
    private static final String SQL_INSERT = "INSERT INTO cursos(codigo_curso,nombre_curso, cant_estu_curso, id_prof_curso) VALUES(?, ?, 0, ?);";
    private static final String SQL_UPDATE = "UPDATE cursos SET nombre_curso = ?, cant_estu_curso = ?, id_prof_curso = ? WHERE codigo_curso = ?";
    private static final String SQL_DELETE = "DELETE FROM cursos WHERE codigo_curso = ?";
    private static final String FILTER_PROFE = "SELECT  cur.codigo_curso, cur.nombre_curso, cur.cant_estu_curso, prof.nombres_prof, prof.apellidos_prof FROM cursos cur INNER JOIN profesores prof ON cur.id_prof_curso  = prof.identificacion_prof WHERE id_prof_curso = ?  ORDER BY nombre_curso;";


    
    public List<Curso> selectCursos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // Instancio la entidad Estudiantes.
        Curso curso = null;

        List<Curso> cursos = new ArrayList<>();

        try {
            //Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            //Mandamos con el método prepareStatement(sql) 
            pstm = conn.prepareStatement(SQL_SELECT);
            // Ejecuta la consulta
            rs = pstm.executeQuery();

            while ( rs.next() ) {
                int codigo = rs.getInt("codigo_curso");
                String nombre = rs.getString("nombre_Curso");
                int cantidad = rs.getInt("cant_estu_curso");
                String nomProfesor = rs.getString("nombres_prof") + " " + rs.getString("apellidos_prof");
                //Llamamos al constructor Estudiantes de la entidad
                curso =  new Curso(codigo, nombre, cantidad, nomProfesor);
                //Agrego la entidad (un estudiante) a un ArrayList<>();
                cursos.add(curso);
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
        return cursos;
    }
    
    
    public int insertCurso(Curso c){
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
            
            pstm.setInt(1, c.getCodigo()); 
            pstm.setString(2, c.getNombre());        
            pstm.setInt(3, c.getProfesorID());              
                     
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
    
     public int updateCurso(Curso curso){
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
            
            pstm.setString(1, curso.getNombre());   
            pstm.setInt(2, curso.getCantidad()); 
            pstm.setInt(3, curso.getProfesorID());   
            pstm.setInt(4, curso.getCodigo());   
       
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
     
    public int DeleteCurso(Curso curso){
        Connection conn = null;
        PreparedStatement pstm = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            pstm = conn.prepareStatement(SQL_DELETE);

            pstm.setInt(1, curso.getCodigo());

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
    
        
    public List<Curso> filtarPorProfesor(int idProf) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        // Instancio la entidad Estudiantes.
        Curso curso = null;

        List<Curso> cursos = new ArrayList<>();

        try {
            //Llamamos el método getConnection() que realiza la conexión a la base de datos.
            conn = Conexion.getConnection();
            //Mandamos con el método prepareStatement(sql) 
            pstm = conn.prepareStatement(FILTER_PROFE);
            pstm.setInt(1, idProf); 
            // Ejecuta la consulta
            rs = pstm.executeQuery();

            while ( rs.next() ) {
                 int codigo = rs.getInt("codigo_curso");
                String nombre = rs.getString("nombre_Curso");
                int cantidad = rs.getInt("cant_estu_curso");
                String nomProfesor = rs.getString("nombres_prof") + " " + rs.getString("apellidos_prof");
                
  
                         
                //Llamamos al constructor Estudiantes de la entidad
                curso =  new Curso(codigo, nombre, cantidad, nomProfesor);
                //Agrego la entidad (un estudiante) a un ArrayList<>();
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(pstm);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return cursos;
    }
    
    
}
