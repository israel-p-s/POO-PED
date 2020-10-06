import java.io.Serializable;

/*
 * Clase abstracta de los Artesanos
 */
public abstract class Artesano extends Empleado implements Serializable{
    protected int trabajosMensuales;        //Atributo que indica los trabajos que han hecho este mes
    
    /*
     * Constructor de Artesano
     */
    public Artesano(String nombre, String identificacion, int sueldo, int departamento, int trabajosMensuales) {
        super(nombre, identificacion, sueldo, departamento);
        this.trabajosMensuales = trabajosMensuales;
    }
    
    /*
     * Método que devuelve trabajosMensuales
     */
    public int getTrabajosMensuales() {
        return trabajosMensuales;
    }
    
    /*
     * Método que modifica trabajosMensuales
     */
    public void setTrabajosMensuales(int trabajosMensuales) {
        this.trabajosMensuales = trabajosMensuales;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
