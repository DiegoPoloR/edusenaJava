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

/**
 *
 * @author polod
 */
public class LoginDAO {
    
        private Connection conn = null;
        private PreparedStatement pstm = null;
        private ResultSet rs = null;
        int rows;
        boolean existe = false;
    
        public boolean checkLogin(String usuario, String password){
            
            String SQL_SELECT = "Select * from usuarios Where usuario= '" + usuario + "' AND  password_user = '" +password+ "';"; 
                
            try {
            
                conn = Conexion.getConnection();        
                pstm = conn.prepareStatement(SQL_SELECT);     
                rs = pstm.executeQuery();

                while ( rs.next() ) {
                    rows++; 
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
            
            if(rows >0) existe = true;                  
            return existe;
                     
        }
    
    
}
