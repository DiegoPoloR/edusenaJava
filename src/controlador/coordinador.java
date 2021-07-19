package controlador;

import modelo.Logica;
import vista.AlertExit;
import vista.AlertaContraseña;
import vista.AlertaError;
import vista.VentanaLogin;


public class coordinador {
    private Logica milogica;
    private VentanaLogin mivista;
    
    private AlertaError miAlerta1;
    private AlertaContraseña miAlerta2;
    private AlertExit miAlerta3;
    
    
    public void setVentana(VentanaLogin mivista) {
        this.mivista=mivista;
    }

    public void setLogica(Logica miLogica) {
       this.milogica=miLogica;
    }
    public int restarX(int x1, int x2){
        int restaX = milogica.CalcPositionX(x1,x2);
        return restaX;
    }

    public int restarY(int y, int mouseY) {
        int restaY = milogica.CalcPositionY(y,mouseY);
        return restaY;
    }

    public boolean ValidarUser(String Username) {
        boolean errorUser = milogica.ValidUser(Username);
        return errorUser;
    }

    public boolean ValidarPassword(String Password) {
        boolean errorPassword = milogica.ValidarPassword(Password);
        return errorPassword;
    }

    public void setMialerta1(AlertaError mialerta1) {
        this.miAlerta1=mialerta1;
    }

    public void setMialerta2(AlertaContraseña mialerta2) {
       this.miAlerta2=mialerta2;
    }

    public void setMialerta3(AlertExit mialerta3) {
       this.miAlerta3=mialerta3;
    }


    public boolean InicioSesion(String Username, String Password) {
        String User = Username;
        String Pass = Password;
        boolean EnterUsuario = milogica.InicioDeSesion(Username,Password);
        return EnterUsuario;
    }

    

    

}
