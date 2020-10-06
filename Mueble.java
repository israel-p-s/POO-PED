import java.io.Serializable;

/*
 * Clase abstracta de los muebles
 */
public abstract class Mueble implements Serializable{  
    protected String nombre;        //Atributo nombre del Mueble
    protected double precio;        //Atributo precio del Mueble
    protected String color;         //Atributo color del Mueble
    protected int medidaX;          //Atributo medidas en el eje X del Mueble
    protected int medidaY;          //Atributo medidas en el eje Y del Mueble       
    protected int medidaZ;          //Atributo medidas en el eje Y del Mueble
    
    /*
     * Constructor de Mueble
     */
    public Mueble(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ) {
        this.nombre = nombre;
        this.precio = precio;
        this.color = color;
        this.medidaX = medidaX;
        this.medidaY = medidaY;
        this.medidaZ = medidaZ;
    }
    
    /*
     * Método que devuelve el nombre del Mueble
     */
    public String getNombre() {
        return nombre;
    }
    
    /*
     * Método que modifica el nombre del Mueble
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /*
     * Método que devuelve el precio del Mueble
     */
    public double getPrecio() {
        return precio;
    }
    
    /*
     * Método que modifica el precio del Mueble
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /*
     * Método que devuelve el color del Mueble
     */
    public String getColor() {
        return color;
    }
    
    /*
     * Método que modifica el color del Mueble
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /*
     * Método que devuelve la medida X del Mueble
     */
    public int getMedidaX() {
        return medidaX;
    }
    
    /*
     * Método que modifica la medida X del Mueble
     */
    public void setMedidaX(int medidaX) {
        this.medidaX = medidaX;
    }
    
    /*
     * Método que devuelve la medida Y del Mueble
     */
    public int getMedidaY() {
        return medidaY;
    }
    
    /*
     * Método que modifica la medida Y del Mueble
     */
    public void setMedidaY(int medidaY) {
        this.medidaY = medidaY;
    }
    
    /*
     * Método que devuelve la medida Z del Mueble
     */
    public int getMedidaZ() {
        return medidaZ;
    }
    
    /*
     * Método que modifica la medida Z del Mueble
     */
    public void setMedidaZ(int medidaZ) {
        this.medidaZ = medidaZ;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
