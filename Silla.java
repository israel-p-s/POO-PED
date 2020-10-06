import java.io.Serializable;

/*
 * Clase abstracta de las sillas
 */
public abstract class Silla extends Mueble implements Serializable{
    protected int respaldoX;        //Atributo que indica la medida del respaldo en el eje X
    protected int respaldoY;        //Atributo que indica la medida del respaldo en el eje Y
    
    /*
     * Constructor de Silla
     */
    public Silla(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ);
        this.respaldoX = respaldoX;
        this.respaldoY = respaldoY;
    }
    
    /*
     * Método que devuelve respaldoX
     */
    public int getRespaldoX() {
        return respaldoX;
    }
    
    /*
     * Método que modifica respaldoX
     */
    public void setRespaldoX(int respaldoX) {
        this.respaldoX = respaldoX;
    }
    
    /*
     * Método que devuelve respaldoY
     */
    public int getRespaldoY() {
        return respaldoY;
    }
    
    /*
     * Método que modifica respaldoY
     */
    public void setRespaldoY(int respaldoY) {
        this.respaldoY = respaldoY;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
