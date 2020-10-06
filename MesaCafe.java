import java.io.Serializable;

/*
 * Clase abstracta de las mesas de café
 */
public abstract class MesaCafe extends Mesa implements Serializable{
    protected String forma;     //Atributo que indica la forma de la mesa
    
    /*
     * Constructor de MesaCafe
     */
    public MesaCafe(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas, String forma) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ,capacidad,patas);
        this.forma = forma;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
    
    /*
     * Método que devuelve forma
     */
    public String getForma() {
        return forma;
    }
    
    /*
     * Método que devuelve forma
     */
    public void setForma(String forma) {
        this.forma = forma;
    }
}
