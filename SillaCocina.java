import java.io.Serializable;

/*
 * Clase de las Sillas de Cocina
 */
public class SillaCocina extends Silla implements Serializable{
    protected String materialCocina;        //Atributo que indica el material en que se ha hecho la silla
    
    /*
     * Constructor de SillaCocina
     */
    public SillaCocina(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY) {
         super(nombre, precio, color, medidaX, medidaY, medidaZ, respaldoX, respaldoY);
         this.materialCocina = materialCocina;
    }
    
    /*
     * Método que devuelve materialCocina
     */
    public String getMaterialCocina() {
        return materialCocina;
    }
    
    /*
     * Método que modifica materialCocina
     */
    public void setMaterialCocina(String materialCocina) {
        this.materialCocina = materialCocina;
    }
    
    /*
     * Método que devuelve 5 para identificar la clase
     */
    public int getClase() {
        return 5;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "SILLA DE COCINA. \nNombre: " + nombre + ". \nPrecio: " + precio +"€. \nColor: " + color + ". \nMedidas: " + medidaX + ", " + medidaY + ", " + medidaZ + ". \nMedidas del respaldo: "; 
        res += + respaldoX + ", " + respaldoY + ".";
        return res;
    }
}
