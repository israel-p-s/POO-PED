import java.io.Serializable;

/*
 * Clase de las Mesas de Cafe de Cristal
 */
public class MesaCafeCristal extends MesaCafe implements Serializable{
    protected String tipoCristal;           //Atributo que indica el tipo de cristal de la mesa
    
    /*
     * Constructor de MesaCafeCristal
     */
    public MesaCafeCristal(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas, String forma, String tipoCristal) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, capacidad, patas, forma);
        this.tipoCristal = tipoCristal;
    }
    
    /*
     * Método que devuelve tipoCristal
     */
    public String getTipoCristal() {
        return tipoCristal;
    }
    
    /*
     * Método que de modifica tipoCristal
     */
    public void setTipoCristal(String tipoCristal) {
        this.tipoCristal = tipoCristal;
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
        res += "MESA DE CAFÉ DE CRISTAL.\nNombre: " + nombre + ".\nPrecio: " + precio + "€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + ".\nCapacidad: "; 
        res += capacidad + " personas.\nPatas: " + patas + ".\nForma: " + forma + ".\nTipo de cristal: " + tipoCristal + ".";
        return res;
    }
    
}
