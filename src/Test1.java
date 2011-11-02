
import Controlador.Controlador;
import Modelo.Menu;
import Modelo.MenuItem;
import Modelo.SistemaSolar;
import Vista.VistaMenu;
import Vista.VistaTexto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nanohp
 */
public class Test1 {
    public static void main(String[] args){
        
        SistemaSolar sistemaSolar = new SistemaSolar();
        VistaTexto vistaTexto = new VistaTexto();
        
        Controlador controlador = new Controlador(vistaTexto, sistemaSolar);
        vistaTexto.setControlador(controlador);
        
        vistaTexto.arranca();
        
    }
            
}
