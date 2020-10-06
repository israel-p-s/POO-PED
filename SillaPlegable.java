import java.io.Serializable;

/*
 * Clase de las Sillas Plegables
 */
public class SillaPlegable extends Silla implements Serializable{
    protected int plegadaX;     //Atributo que indica la medida de la silla plegada en el eje X
    protected int plegadaY;     //Atributo que indica la medida de la silla plegada en el eje X
    
    /*
     * Constructor de SillaPlegable
     */
    public SillaPlegable(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY, int plegadaX, int pleagadaY) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, respaldoX, respaldoY);
        this.plegadaX = plegadaX;
        this.plegadaY = plegadaY;
    }
    
    /*
     * Método que devuelve plegadaX
     */
    public int getPlegadaX() {
        return plegadaX;
    }
    
    /*
     * Método que modifica plegadaX
     */
    public void setPlegadaX(int plegadaX) {
        this.plegadaX = plegadaX;
    }
    
    /*
     * Método que devuelve plegadaY
     */
    public int getPlegadaY() {
        return plegadaY;
    }
    
    /*
     * Método que modifica plegadaX
     */
    public void setPlegadaY(int plegadaY) {
        this.plegadaY = plegadaY;
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
        res += "SILLA DE OFICINA CON RUEDAS.\nNombre: " + nombre + ".\nPrecio: " + precio +"€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + "."; 
        res += ". \nMedidas del respaldo: " + respaldoX + ", " + respaldoY + ". \nMedidas plegada: " + plegadaX + ", " + plegadaX;
        return res;
    }
}
