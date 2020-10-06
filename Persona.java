import java.io.Serializable;

/*
 * Clase abstracta de las Personas
 */
public abstract class Persona implements Serializable{
    protected String nombre;                //Atributo que indica el nombre de la persona
    protected String identificacion;        //Atributo que indica la identificación(dni, nif, cif,...)
    
    /*
     * Constructor de Persona
     */
    public Persona(String nombre, String identificacion){
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
    
    /*
     * Método que devuelve nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /*
     * Método que modifica nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /*
     * Modifica que devuelve identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }
    
    /*
     * Modifica que modifica identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
