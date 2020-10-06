import java.io.Serializable;

/*
 * Clase de los Artesanos por Horas
 */
public class ArtesanoPorHoras extends Artesano implements Serializable{
    protected int horasHechasMensuales;         //Atributo que indica las horas que ha hecho este artesano durante el mes
    
    /*
     * Constructor de ArtesanoPorHoras
     */
    public ArtesanoPorHoras(String nombre, String identificacion, int sueldo, int departamento, int trabajosMensuales, int horasHechasMensuales) {
        super(nombre, identificacion, sueldo, departamento, trabajosMensuales);
        this.horasHechasMensuales = horasHechasMensuales;
    }
  
    /*
     * Método que devuelve horasHechasMensuales
     */
    public int getHorasHechasMensuales() {
        return horasHechasMensuales;
    }
    
    /*
     * Método que modifica horasHechasMensuales
     */
    public void setHorasHechasMensuales(int horasHechasMensuales) {
        this.horasHechasMensuales = horasHechasMensuales;
    }
    
    /*
     * Método que devuelve 3 para identificar la clase
     */
    public int getClase() {
        return 3;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "ARTESANO POR HORAS.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nSueldo: " + sueldo + "€.\nDepartamento: " + departamento;
        res += ".\nTrabajos mensuales: " + trabajosMensuales + "trabajos.\nHoras hechas este mes: " + horasHechasMensuales + " horas.";
        return res;
    }
}
