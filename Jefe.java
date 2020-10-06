import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/*
 * Clase de los Jefes
 */
public class Jefe extends Empleado implements Serializable{
    protected int trabajadores;     //Atributo que indica el número de trabajadores que tiene a su cargo
    
    /*
     * Constructor de Jefe
     */
    public Jefe(String nombre, String identificacion, int sueldo, int departamento, int trabajadores) {
        super(nombre, identificacion, sueldo, departamento);
        this.trabajadores = trabajadores;
    }
    
    /*
     * Método que devuelve trabajadores
     */
    public int getTrabajadores() {
        return trabajadores;
    }
    
    /*
     * Método que modifica trabajadores
     */
    public void SetTrabajadores (int trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    /*
     * Método que devuelve 1 para identificar la clase
     */
    public int getClase() {
        return 1;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "JEFE.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nSueldo: " + sueldo + "€.\nDepartamento: " + departamento + "\nNúmero de trabajadores a su cargo: " + trabajadores + ".";
        return res;
    }
}
