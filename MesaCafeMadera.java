import java.io.Serializable;
/*
 * Clase de las Mesas de Cafe de Madera
 */
public class MesaCafeMadera extends MesaCafe implements Serializable{
    protected String tipoMadera;        //Atributo que indica el tipo de madera de la mesa

    /*
     * Constructor de la clase MesaCafeMadera
     */
    public MesaCafeMadera(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int capacidad, int patas, String forma, String tipoMadera) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ,capacidad,patas,forma);
        this.tipoMadera = tipoMadera;
    }
    
    /*
     * Método que devuelve tipoMadera
     */
    public String getTipoMadera() {
        return tipoMadera;
    }
    
    /*
     * Método que modifica tipoMadera
     */
    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }
    
    /*
     * Método que devuelve 2 para identificar la clase
     */
    public int getClase() {
        return 2;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "MESA DE CAFÉ DE MADERA.\nNombre: " + nombre + ".\nPrecio: " + precio +"€.\nColor: " + color + ".\nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + ".\nCapacidad: "; 
        res += capacidad + " personas.\nPatas: " + patas + ".\nForma: " + forma + ".\nTipo de madera: " + tipoMadera + ".";
        return res;
    }
    
}
