package modelo;

import controlador.coordinador;
import javax.swing.JOptionPane;
import vista.AlertaError;


public class Logica {
    private coordinador miCoordinador;
    AlertaError mialerta2 = new AlertaError();
    public int CalcPositionX(int x1, int x2){
        return x1-x2;
    }

    public void setCoordinador(coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public int CalcPositionY(int y1, int y2) {
         return y1-y2;
    }

    public boolean ValidUser(String Username) {
        boolean ErrorUser = false;
        if(Username.equals("")||Username.isEmpty()){
            //JOptionPane.showMessageDialog(null, "Porfavor ingrese un usuario","Error",JOptionPane.WARNING_MESSAGE);
            ErrorUser = true;
        }
        else{
             ErrorUser=false;
        }
        return ErrorUser;
    }

    public boolean ValidarPassword(String Password) {
        boolean ErrorPassword = false;
        if(Password.equals("")){
            //JOptionPane.showMessageDialog(null, "Porfavor ingrese una contraseña","Error",JOptionPane.WARNING_MESSAGE);
            ErrorPassword = true;
        }
        return ErrorPassword;
    }

    public boolean InicioDeSesion(String Username, String Password) {
        boolean EnterUsuario = false;
        /*if(Username.equalsIgnoreCase("123")&& Password.equals("123")){
            //miVentana2.setVisible(true);
            EnterUsuario = true;
            
        }*/
        return EnterUsuario;
    }
    
}
