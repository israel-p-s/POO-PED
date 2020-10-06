import java.io.Serializable;

/*
 * Clase de los Pedidos
 */
public class Pedido implements Serializable{
    public String nombre;           //Atributo que indica el nombre del pedido
    public Cliente cliente;         //Atributo que indica el cliente del pedido
    public Mueble mueble;           //Atributo que indica el mueble del pedido
    public Artesano artesano;       //Atributo que indica el artesano del pedido
    public String comentario;       //Atributo que indica el comentario del pedido
    public String piezas;           //Atributo que indica las piezas necesarias para el pedido
    
    /*
     * Constructor de Pedido
     */
    public Pedido(String nombre, Cliente cliente, Mueble mueble, Artesano artesano, String comentario, String piezas) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.mueble = mueble;
        this.artesano = artesano;
        this.comentario = comentario;
        this.piezas = piezas;
    }
    
    /*
     * Método que devuelve nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /*
     * Método que modifica nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /*
     * Método que devuelve cliente
     */
    public Cliente getCliente() {
        return cliente;
    }
    
    /*
     * Método que modifica cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /*
     * Método que devuelve mueble
     */
    public Mueble getMueble() {
        return mueble;
    }
    
    /*
     * Método que modifica mueble
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }
    
    /*
     * Método que devuelve artesano
     */
    public Artesano getArtesano() {
        return artesano;
    }
    
    /*
     * Método que modifica artesano
     */
    public void setArtesano(Artesano artesano) {
        this.artesano = artesano;
    }
    
    /*
     * Método que devuelve comentario
     */
    public String getComentario() {
        return comentario;
    }
    
    /*
     * Método que modifica comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    /*
     * Método que devuelve piezas
     */
    public String getPiezas() {
        return piezas;
    }
    
    /*
     * Método que modifica piezas
     */
    public void setPiezas(String piezas) {
        this.piezas = piezas;
    }
    
    /*
     * Método que devuelve un string con la información del objeto creado
     */
    public String toString() {
        String res = "";
        res += "PEDIDO.\nCliente: " + cliente.getNombre() + ".\nMueble: " + mueble.getNombre() + ".\nArtesano: " + artesano.getNombre() + ".\nComentarios del artesano: " + comentario + "\nPiezas: " + piezas;
        return res;
    }
}
