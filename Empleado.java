import java.io.Serializable;

/*
 * Clase de los Empleaos
 */
public abstract class Empleado extends Persona implements Serializable{
    protected int sueldo;           //Atributo que indica el sueldo del empleado
    protected int departamento;     //Atributo que indica el número del departamento en que trabaja
    
    /*
     * Construcor de Empleado
     */
    public Empleado (String nombre, String identificacion, int sueldo, int departamento) {
        super(nombre, identificacion);
        this.sueldo = sueldo;
        this.departamento = departamento;
    }
    
    /*
     * Método que devuelve sueldo
     */
    public int getSueldo() {
        return sueldo;
    }
    
    /*
     * Método que modifica sueldo
     */
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    /*
     * Método que devuelve departamento
     */
    public int getDepartamento() {
        return departamento;
    }
    
    /*
     * Método que modifica departamento
     */
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    
    /*
     * Método que devuelve 0 para identificar la clase
     */
    public int getClase() {
        return 0;
    }
}
