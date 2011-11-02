package Modelo;

/**
 *
 * @author nanohp
 */
public class MenuItem {

    private char opcion;
    private String etiqueta;

    public String getEtiqueta() {
        return etiqueta;
    }

    public MenuItem(char opcion, String etiqueta) {
        this.opcion = opcion;
        this.etiqueta = etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public char getOpcion() {
        return opcion;
    }

    @Override
    public String toString() {
        return opcion + ": " + etiqueta;
    }
}
