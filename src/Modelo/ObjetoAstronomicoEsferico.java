package Modelo;

/**
 *
 * @author nanohp
 */
public class ObjetoAstronomicoEsferico {

    protected String nombre;
    protected double masa;
    protected double diametro;
    protected double velocidadRotacion;

    public ObjetoAstronomicoEsferico(String nombre, double masa, double diametro, double velocidadRotacion) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.velocidadRotacion = velocidadRotacion;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public void setVelocidadRotacion(double velocidadRotacion) {
        this.velocidadRotacion = velocidadRotacion;
    }

    public double getDiametro() {
        return diametro;
    }

    public double getMasa() {
        return masa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidadRotacion() {
        return velocidadRotacion;
    }
}
