import java.io.Serializable;

/*
 * Clase de las Mesas de Comedor
 */
public class MesaComedor extends Mesa implements Serializable{
    protected String materialComedor;       //Atributo que indica el material en que se ha hecho la mesa 
    
    /*
     * Constructor de MesaComedor
     */
    public MesaComedor(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas, String materialComedor) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, capacidad, patas);
        this.materialComedor = materialComedor;
    }
    
    /*
     * Método que devuelve materialComedor
     */
    public String getMaterialComedor() {
        return materialComedor;
    }
    
    /*
     * Método que modifica materialComedor
     */
    public void setMaterialComedor(String materialComedor) {
        this.materialComedor = materialComedor;
    }
    
    /*
     * Método que devuelve 4 para identificar la clase
     */
    public int getClase() {
        return 4;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "MESA DE DORMITORIO.\nNombre: " + nombre + ".\nPrecio: " + precio + "€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + ".\nCapacidad: "; 
        res += capacidad + " personas.\nPatas: " + patas + ".\nMaterial: " + materialComedor + ".";
        return res;
    }
}
