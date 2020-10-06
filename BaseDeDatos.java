import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Clase de la base de datos, encargada de manipular la información usada en el programa
 */
public class BaseDeDatos implements Serializable{
    public ArrayList<Mueble> muebles = new ArrayList<Mueble>();             //ArrayList donde se guarda la información de los muebles
    public ArrayList<Empleado> empleados = new ArrayList<Empleado>();       //ArrayList donde se guarda la información de los empleados
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();          //ArrayList donde se guarda la información de los clientes
    public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();             //ArrayList donde se guarda la información de los pedidos
    String bbddMuebles = "./bbdd/muebles.log";                              //Ruta del archivo donde se guarda la información de los muebles
    String bbddEmpleados = "./bbdd/empleados.log";                          //Ruta del archivo donde se guarda la información de los empleados
    String bbddClientes = "./bbdd/clientes.log";                            //Ruta del archivo donde se guarda la información de los clientes
    String bbddPedidos = "./bbdd/pedidos.log";                              //Ruta del archivo donde se guarda la información de los pedidos
    
    public BaseDeDatos() {
    
    }
    
    /*
     * Método que guardar el ArrayListg muebles en el fichero muebles.log
     */
    public void guardarMuebles(ArrayList<Mueble> nuevosMuebles) {
        try {
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(bbddMuebles));
            ficheroSalida.writeObject(nuevosMuebles);
            ficheroSalida.flush();
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }
    
    /*
     * Método que guardar el ArrayList empleados en el fichero empleados.log
     */
    public void guardarEmpleados(ArrayList<Empleado> nuevosEmpleados) {
        try {
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(bbddEmpleados));
            ficheroSalida.writeObject(nuevosEmpleados);
            ficheroSalida.flush();
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }
    
    /*
     * Método que guardar el ArrayList clientes en el fichero clientes.log
     */
    public void guardarClientes(ArrayList<Cliente> nuevosClientes) {
        try {
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(bbddClientes));
            ficheroSalida.writeObject(nuevosClientes);
            ficheroSalida.flush();
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }
    
    /*
     * Método que guardar el ArrayList pedidos en el fichero pedidos.log
     */ 
    public void guardarPedidos(ArrayList<Pedido> nuevosPedidos) {
        try {
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(bbddPedidos));
            ficheroSalida.writeObject(nuevosPedidos);
            ficheroSalida.flush();
            ficheroSalida.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }
    
    /*
     * Método que lee el ArrayList muebles del fichero muebles.log
     */
    public ArrayList<Mueble> leerMuebles() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(bbddMuebles) );
            muebles = ( ArrayList<Mueble> )leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return muebles;
    }
    
    /*
     * Método que lee el ArrayList empleados del fichero empleados.log
     */
    public ArrayList<Empleado> leerEmpleados() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(bbddEmpleados) );
            empleados = ( ArrayList<Empleado> )leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return empleados;
    }
    
    /*
     * Método que lee el ArrayList clientes del fichero clientes.log
     */
    public ArrayList<Cliente> leerClientes() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(bbddClientes) );
            clientes = ( ArrayList<Cliente> )leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return clientes;
    }
    
    /*
     * Método que lee el ArrayList pedidos del fichero pedidos.log
     */
    public ArrayList<Pedido> leerPedidos() {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(bbddPedidos) );
            pedidos = ( ArrayList<Pedido> )leyendoFichero.readObject();
            leyendoFichero.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return pedidos;
    }
    
    
    /*
     * Método que devuelve un String con el nombre de los muebles
     */
    public String showMuebles() {
        String res = "";
        for (int i = 0; i < leerMuebles().size(); i++) {
            res += (i+1) + ") "+ leerMuebles().get(i).getNombre() + "\n";
        }
        return res;
    }
    
    /*
     * Método que devuelve un String con la información de un mueble
     */
    public String showMueble(int num) {
        String res = leerMuebles().get(num-1).toString() + "\n";
        return res;
    }
    
    /*
     * Método que devuelve un objeto de tipo Mueble
     */
    public Mueble returnMueble(int num) {
        return leerMuebles().get(num-1);
    }
    
    /*
     * Método que añade un mueble MesaCafeCristal a la base de datos
     */
    public void addMueble(MesaCafeCristal mesaCC) {
        muebles = leerMuebles();
        muebles.add(mesaCC);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble MesaCafeMadera a la base de datos
     */
    public void addMueble(MesaCafeMadera mesaCM) {
        muebles = leerMuebles();
        muebles.add(mesaCM);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble MesaDormitorio a la base de datos
     */
    public void addMueble(MesaDormitorio mesaD) {
        muebles = leerMuebles();
        muebles.add(mesaD);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble MesaComedor a la base de datos
     */
    public void addMueble(MesaComedor mesaC) {
        muebles = leerMuebles();
        muebles.add(mesaC);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble SillaCocina a la base de datos
     */
    public void addMueble(SillaCocina sillaC) {
        muebles = leerMuebles();
        muebles.add(sillaC);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble SillaOficinaConRuedas a la base de datos
     */
    public void addMueble(SillaOficinaConRuedas sillaOCR) {
        muebles = leerMuebles();
        muebles.add(sillaOCR);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble SillaOficinaSinRuedas a la base de datos
     */
    public void addMueble(SillaOficinaSinRuedas sillaOSR) {
        muebles = leerMuebles();
        muebles.add(sillaOSR);
        guardarMuebles(muebles);
    }
    
    /*
     * Método que añade un mueble SillaPlegable a la base de datos
     */
    public void addMueble(SillaPlegable sillaP) {
        muebles = leerMuebles();
        muebles.add(sillaP);
        guardarMuebles(muebles);
    }
    
    
    /*
     * Método que devuelve un String con el nombre de los empleados
     */
    public String showEmpleados() {
        String res = "";
        for (int i = 0; i < leerEmpleados().size(); i++) {
            res += (i+1) + ") "+ leerEmpleados().get(i).getNombre() + " -> " +  leerEmpleados().get(i).getIdentificacion() +"\n";
        }
        return res;
    }
    
    /*
     * Método que devuelve un String con la información de un empleado
     */
    public String showEmpleado(int num) {
        String res = leerEmpleados().get(num-1).toString() + "\n";
        return res;
    }
    
    /*
     * Método que devuelve un objeto de tipo Empleado
     */
    public Empleado returnEmpleado(int num) {
        return leerEmpleados().get(num-1);
    }
    
    /*
     * Método que añade un empleado Jefe a la base de datos
     */
    public void addEmpleado(Jefe jefe) {
        empleados = leerEmpleados();
        empleados.add(jefe);
        guardarEmpleados(empleados);
    }
    
    /*
     * Método que añade un empleado Comercial a la base de datos
     */
    public void addEmpleado(Comercial comercial) {
        empleados = leerEmpleados();
        empleados.add(comercial);
        guardarEmpleados(empleados);
    }
    
    /*
     * Método que añade un empleado ArtesanoPorHoras a la base de datos
     */
    public void addEmpleado(ArtesanoPorHoras artesanoPorHoras) {
        empleados = leerEmpleados();
        empleados.add(artesanoPorHoras);
        guardarEmpleados(empleados);
    }
    
    /*
     * Método que añade un empleado ArtesanoEnPlantilla a la base de datos
     */
    public void addEmpleado(ArtesanoEnPlantilla artesanoEnPlantilla) {
        empleados = leerEmpleados();
        empleados.add(artesanoEnPlantilla);
        guardarEmpleados(empleados);
    }
    
    /*
     * Método que devuelve un String con el nombre de los artesanos
     */
    public String showArtesanos() {
        String res = "";
        for (int i = 0; i < leerEmpleados().size(); i++) {
            if((leerEmpleados().get(i).getClase() == 3) || (leerEmpleados().get(i).getClase() == 4)){
                res += (i+1) + ") "+ leerEmpleados().get(i).getNombre() + "\n";
            }
        }
        return res;
    }
    
    /*
     * Método que devuelve un objeto de tipo Empleado a partir de su identificacion
     */
    public Empleado returnEmpleadoIdentificacion(String identificacion){
        for (int i = 0; i < leerEmpleados().size(); i++) {
            if((leerEmpleados().get(i).getIdentificacion().equals(identificacion))){
                return leerEmpleados().get(i);
            }
        }
        return null;
    }
    
    /*
     * Método que devuelve un String con el nombre de los artesanos
     */
    public String showClientes() {
        String res = "";
        for (int i = 0; i < leerClientes().size(); i++) {
            res += (i+1) + ") "+ leerClientes().get(i).getNombre() + "\n";
        }
        return res;
    }
    
    /*
     * Método que devuelve un String con la información de un cliente
     */
    public String showCliente(int num) {
        String res = leerClientes().get(num-1).toString() + "\n";
        return res;
    }
    
    /*
     * Método que devuelve un objeto de tipo Cliente
     */
    public Cliente returnCliente(int num) {
        return leerClientes().get(num-1);
    }
    
    /*
     * Método que añade un cliente ClientePersona a la base de datos
     */
    public void addCliente(ClientePersona clienteP) {
        clientes = leerClientes();
        clientes.add(clienteP);
        guardarClientes(clientes);
    }
    
    /*
     * Método que añade un cliente ClienteEmpresa a la base de datos
     */
    public void addCliente(ClienteEmpresa clienteE) {
        clientes = leerClientes();
        clientes.add(clienteE);
        guardarClientes(clientes);
    }
    
    /*
     * Método que devuelve un String con el nombre de los pedidos
     */
    public String showPedidos() {
        String res = "";
        for (int i = 0; i < leerPedidos().size(); i++) {
            res += (i+1) + ") "+ leerPedidos().get(i).getNombre() + "\n";
        }
        return res;
    }
    
    /*
     * Método que devuelve un String con la información de un cliente
     */
    public String showPedido(int num) {
        String res = leerPedidos().get(num-1).toString() + "\n";
        return res;
    }
    
    /*
     * Método que devuelve un ArrayList con los pedidos de un artesano en función de su identificación
     */
    public ArrayList<Pedido> returnPedidosIdentificador(String id) {
        ArrayList<Pedido> aux = new ArrayList<Pedido>();
        pedidos = leerPedidos();
        for (int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getArtesano().getIdentificacion().equals(id)) {
                aux.add(leerPedidos().get(i));
                pedidos.remove(i);
            }
        }
        guardarPedidos(pedidos);
        return aux;
    }
    
    /*
     * Método que añade un pedido a la lista de pedidos de un Artesano
     */
    public void addPedidosArtesano(ArrayList<Pedido> pedidosArtesano) {
        pedidos = leerPedidos();
        for (int i = 0; i < pedidosArtesano.size(); i++) {
            pedidos.add(pedidosArtesano.get(i));
        }
        guardarPedidos(pedidos);
    }
    
    /*
     * Método que devuelve un String con el nombre de los pedidos
     */
    public String showPedidosArtesano(ArrayList<Pedido> pedidosArtesano) {
        String res = "";
        for (int i = 0; i < pedidosArtesano.size(); i++) {
            res += (i+1) + ") "+ pedidosArtesano.get(i).getNombre() + "\n";
        }
        return res;
    }
    
    /*
     * Método que devuelve un String con la información de un pedido
     */
    public String showPedidoArtesano(ArrayList<Pedido> pedidosArtesano, int pedido) {
        return pedidosArtesano.get(pedido-1).toString();
    }
    
    /*
     * Método que elimina un pedido de la lista de pedidos pendientes de un artesano
     */
    public void removePedidoArtesano(ArrayList<Pedido> pedidosArtesano, int pedido) {
        pedidosArtesano.remove(pedido-1);
    }
    
    /*
     * Método que devuelve un objeto de tipo Pedido
     */
    public Pedido returnPedido(int num) {
        return leerPedidos().get(num-1);
    }
    
    /*
     * Método que añade un pedido a la base de datos 
     */
    public void addPedido(Pedido pedido) {
        pedidos = leerPedidos();
        pedidos.add(pedido);
        guardarPedidos(pedidos);
    }

}
