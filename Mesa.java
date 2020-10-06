import java.io.Serializable;

/*
 * Clase abstracta de las mesas
 */
public abstract class Mesa extends Mueble implements Serializable{
    protected int capacidad;        //Atributo que indica la cantidad de personas que caben en la mesa
    protected int patas;            //Atributo que indica el número de patas de la mesa
    
    /*
     * Constructor de Mesa
     */
    public Mesa(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ);
        this.capacidad = capacidad;
        this.patas = patas;
    }
    
    /*
     * Método que devuelve la capacidad del Mueble
     */
    public int getCapacidad() {
        return capacidad;
    }
    
    /*
     * Método que modifica la capacidad del Mueble
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /*
     * Método que devuelve las patas del Mueble
     */
    public int getPatas() {
        return patas;
    }
    
    /*
     * Método que modifica las patas del Mueble
     */
    public void setPatas(int patas) {
        this.patas = patas;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
