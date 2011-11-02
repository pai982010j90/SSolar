package Modelo;

/**
 *
 * @author nanohp
 */
public class Estrella extends ObjetoAstronomicoEsferico {

    private int temperatura;

    public Estrella(String nombre, double masa, double diametro, double vRotacion, int temperatura) {
        super(nombre, masa, diametro, vRotacion);
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}
