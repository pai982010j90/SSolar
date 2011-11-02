package Controlador;

import Modelo.SistemaSolar;
import Vista.VistaTexto;

/**
 *
 * @author nanohp
 */
public class Controlador {

    private VistaTexto vista;
    private SistemaSolar sistemaSolar;

    public Controlador(VistaTexto vista, SistemaSolar sistemaSolar) {
        this.vista = vista;
        this.sistemaSolar = sistemaSolar;
    }
    
    public void procesadorEvento(String evento){
        System.err.println(evento);
    }
}
