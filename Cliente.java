import java.io.Serializable;

/*
 * Clase de los Clientes
 */
public abstract class Cliente extends Persona implements Serializable{
    protected String localidad;     //Atributo que indica el lugar de residencia del cliente

    /*
     * Constructor de Cliente
     */
    public Cliente(String nombre, String identificacion, String localidad) {
        super(nombre, identificacion);
        this.localidad = localidad;
    }
    
    /*
     * Método que devuelve localidad
     */
    public String getLocalidad() {
        return localidad;
    }
    
    /*
     * Método que modifica localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
