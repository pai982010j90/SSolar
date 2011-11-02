package Vista;

import Controlador.Controlador;
import Modelo.Menu;
import Modelo.MenuItem;

/**
 *
 * @author nanohp
 */
public class VistaTexto {

    private VistaMenu vistaMenu;
    private Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public VistaTexto() {
        Menu menu = new Menu();
        menu.add(new MenuItem('0', "Salir.", "EventoSalir"));
        menu.add(new MenuItem('1', "Mostrar.", "EventoMostrar"));

        vistaMenu = new VistaMenu(menu);
    }

    public void arranca() {
        String evento;
        do {
            vistaMenu.mostrarMenu();
            vistaMenu.mostrarMenuOpciones();
            evento = vistaMenu.selectorEvento();
            if (evento.equals("EventoSalir")) {
                break;
            }
            controlador.procesadorEvento(evento);

        } while (true);
    }
}
