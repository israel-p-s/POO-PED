import java.io.Serializable;
/*
 * Clase de las Sillas de Oficina sin ruedas
 */
public class SillaOficinaSinRuedas extends SillaOficina implements Serializable{
    protected int numPatas;         //Atributo que indica el número de patas que tiene la silla
    
    /*
     * Constructor de SillaOficinaSinRuedas
     */
    public SillaOficinaSinRuedas(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY, boolean conReposabrazos, boolean conReposacabezas, int numPatas) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, respaldoX, respaldoY,conReposabrazos, conReposacabezas);
        this.numPatas = numPatas;
    }
    
    /*
     * Método que devuelve numPatas
     */
    public int getNumPatas() {
        return numPatas;
    }
    
    /*
     * Método que modifica numPatas
     */
    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }
    
    /*
     * Método que devuelve 7 para identificar la clase
     */
    public int getClase() {
        return 7;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "SILLA DE OFICINA CON RUEDAS.\nNombre: " + nombre + ".\nPrecio: " + precio +"€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + "."; 
        res += ". \nMedidas del respaldo: " + respaldoX + ", " + respaldoY + ".";
        if(conReposabrazos) {
            res += "\nTiene reposabrazos.";
        }
        if(conReposacabezas) {
            res += "\nTiene reposacabeza.";
        }
        res += "\nNúmero de patas: " + numPatas;
        return res;
    }
}
