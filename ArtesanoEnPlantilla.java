import java.io.Serializable;

/*
 * Clase de los Artesanos en Plantilla
 */
public class ArtesanoEnPlantilla extends Artesano implements Serializable{
    protected int horasContrato;        //Atributo que indica el número de horas que tiene en su contrato
    
    /*
     * Constructor de ArtesanoEnPlantilla
     */
    public ArtesanoEnPlantilla(String nombre, String identificacion, int sueldo, int departamento, int trabajosMensuales, int horasContrato) {
        super(nombre, identificacion, sueldo, departamento, trabajosMensuales);
        this.horasContrato = horasContrato;
    }
    
    /*
     * Método que devuelve horasContrato
     */
    public int getHorasContrato() {
        return horasContrato;
    }
    
    /*
     * Método que modifica horasContrato
     */
    public void setHorasContrato(int horasContrato) {
        this.horasContrato = horasContrato;
    }
    
    /*
     * Método que devuelve 4 para identificar la clase
     */
    public int getClase() {
        return 4;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "ARTESANO POR HORAS.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nSueldo: " + sueldo + "€.\nDepartamento: " + departamento;
        res += ".\nTrabajos mensuales: " + trabajosMensuales + " trabajos.\nHoras por contrato: " + horasContrato + " horas.";
        return res;
    }
}
