import java.io.Serializable;

/*
 * Clase de las Sillas de Oficina con Ruedas
 */
public class SillaOficinaConRuedas extends SillaOficina implements Serializable{
    protected int numRuedas;        //Atributo que indica el número de ruedas de la silla
    /*
     * Constructor de SillaOficinaConRuedas
     */
    public SillaOficinaConRuedas(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY, boolean conReposabrazos, boolean conReposacabezas, int numRuedas) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, respaldoX, respaldoY,conReposabrazos, conReposacabezas);
        this.numRuedas = numRuedas;
    }
    
    /*
     * Método que devuelve numRuedas
     */
    public int getNumRuedas() {
        return numRuedas;
    }
    
    /*
     * Método que modifica numRuedas
     */
    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }
    
    /*
     * Método que devuelve 6 para identificar la clase
     */
    public int getClase() {
        return 6;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "SILLA DE OFICINA CON RUEDAS.\nNombre: " + nombre + ".\nPrecio: " + precio +"€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ; 
        res += ". \nMedidas del respaldo: " + respaldoX + ", " + respaldoY + ".";
        if(conReposabrazos) {
            res += "\nTiene reposabrazos.";
        }
        if(conReposacabezas) {
            res += "\nTiene reposacabeza.";
        }
        res += "\nNúmero de ruedas: " + numRuedas;
        return res;
    }
}
