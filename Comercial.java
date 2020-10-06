import java.io.Serializable;

/*
 * Clase de los Comerciales
 */
public class Comercial extends Empleado implements Serializable{
    protected int ventasMensuales;      //Atributo que indica el número de ventas que ha hecho este mes
    
    /*
     * Constructor de Comercial
     */
    public Comercial (String nombre, String identificacion, int sueldo, int departamento, int ventasMensuales) {
        super(nombre, identificacion, sueldo, departamento);
        this.ventasMensuales = ventasMensuales;
    }
    
    /*
     * Método que devuelve ventasMensuales
     */
    public int getVentasMensuales() {
        return ventasMensuales;
    }
    
    /*
     * Método que modifica ventasMensuales
     */
    public void setVentasMensuales (int ventasMensuales) {
        this.ventasMensuales = ventasMensuales;
    }
    
    /*
     * Método que devuelve 2 para identificar la clase
     */
    public int getClase() {
        return 2;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "COMERCIAL.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nSueldo: " + sueldo + "€.\nDepartamento: " + departamento + ".\nVentas mensuales: " + ventasMensuales + ".";
        return res;
    }
}
