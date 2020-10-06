import java.io.Serializable;

/*
 * Clase de los Clientes que son Empresa
 */
public class ClienteEmpresa extends Cliente implements Serializable{
    protected String sector;        //Atributo que indica el sector en que trabaja la empresa

    public ClienteEmpresa(String nombre, String identificacion, String localidad, String sector) {
        super(nombre, identificacion, localidad);
        this.sector = sector;
    }
    
    /*
     * Método que devuelve sector
     */
    public String getSector() {
        return sector;
    }
    
    /*
     * Método que modifica sector
     */
    public void setSector(String sector) {
        this.sector = sector;
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
        res += "CLIENTE PARTICULAR.\nNombre: " + nombre + ".\nIdentificación: " + identificacion + ".\nLocalidad: " + localidad + ".\nSector: " + sector + ".";
        return res;
    }
}
