import java.io.Serializable;

/*
 * Clase de los Clintes particulares
 */
public class ClientePersona extends Cliente implements Serializable{
    protected int nivelVIP;     //Atributo que indica el nivel VIP del cliente
    
    /*
     * Constructor de Cliente
     */
    public ClientePersona(String nombre, String identificacion, String localidad, int nivelVIP) {
        super(nombre, identificacion, localidad);
        this.nivelVIP = nivelVIP;
    }
    
    /*
     * Método que devuelve nivelVIP
     */
    public int getNivelVIP() {
        return nivelVIP;
    }
    
    /*
     * Método que modifica nivelVIP
     */
    public void setNivelVIP(int nivelVIP) {
        this.nivelVIP = nivelVIP;
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
        res += "CLIENTE PARTICULAR.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nLocalidad: " + localidad + ".\nNivel VIP: " + nivelVIP + ".";
        return res;
    }
}
