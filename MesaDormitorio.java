import java.io.Serializable;

/*
 * Clase de las Mesas de Dormitorio
 */
public class MesaDormitorio extends Mesa implements Serializable{
    protected String materialDormitorio;        //Atributo que indica el material en que se ha hecho la mesa 
    
    /*
     * Constructor de MesaDormitorio
     */
    public MesaDormitorio(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas, String materialDormitorio) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, capacidad, patas);
        this.materialDormitorio = materialDormitorio;
    }
    
    /*
     * Método que devuelve materialDormitorio
     */
    public String getMaterialDormitorio() {
        return materialDormitorio;
    }
    
    /*
     * Método que modifica materialDormitorio
     */
    public void setMaterialDormitorio(String materialDormitorio) {
        this.materialDormitorio = materialDormitorio;
    }
    
    /*
     * Método que devuelve 3 para identificar la clase
     */
    public int getClase() {
        return 3;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "MESA DE DORMITORIO.\nNombre: " + nombre + ".\nPrecio: " + precio + "€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + ".\nCapacidad: "; 
        res += capacidad + " personas.\nPatas: " + patas + ".\nMaterial: " + materialDormitorio + ".";
        return res;
    }
}