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
    
    
    
}
