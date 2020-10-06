import java.io.Serializable;

/*
 * Clase abstracta de las Silla de Oficina
 */
public abstract class SillaOficina extends Silla implements Serializable{
    protected boolean conReposabrazos;          //Atributo que indica si la silla tiene reposabrazos
    protected boolean conReposacabezas;         //Atributo que indica si la silla tiene reposacabezas
    
    /*
     * Constructor de SillaOficina
     */
    public SillaOficina(String nombre, double precio, String color, int medidaX, int medidaY, int medidaZ, int respaldoX, int respaldoY, boolean conReposabrazos, boolean conReposacabezas) {
        super(nombre, precio, color, medidaX, medidaY, medidaZ, respaldoX, respaldoY);
        this.conReposabrazos = conReposabrazos;
        this.conReposacabezas = conReposacabezas;
    }
    
    /*
     * Método que devuelve conReposabrazos
     */
    public boolean getConReposabrazos() {
        return conReposabrazos;
    }
    
    /*
     * Método que modifica conReposabrazos
     */
    public void setConReposabrazos(boolean conReposabrazos) {
        this.conReposabrazos = conReposabrazos;
    }
    
    /*
     * Método que devuelve conReposacabezas
     */
    public boolean getConReposacabezas() {
        return conReposacabezas;
    }
    
    /*
     * Método que modifica conReposacabezas
     */
    public void setConReposacabezas(boolean conReposacabezas) {
        this.conReposacabezas = conReposacabezas;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}