/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.LoginDAO;
import vista.AlertaContraseña;
import vista.AlertaError;
import vista.AlertaNoLogin;
import vista.Dashboard;


/**
 *
 * @author polod
 */
public class LoginCtrl {
    
    
    
    public boolean validarLogin(String username,String password){
        
        LoginDAO login = new LoginDAO();    
        
        if(username.isEmpty() && password.isEmpty()) JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios.");     
        else if(username.isEmpty()){
           AlertaError erroUser = new AlertaError();
           erroUser.setVisible(true);    
        }
        else if(password.isEmpty()){
           AlertaContraseña errorPassword = new AlertaContraseña();
           errorPassword.setVisible(true);         
        }
        else {          
            boolean checkLogin =  login.checkLogin(username, password);      
            if(checkLogin){
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                
                return true;   
            }
             else {
                AlertaNoLogin noLogin = new AlertaNoLogin();
                noLogin.setVisible(true);           
            }      
        }
        
        return false;      
    }
          
}
