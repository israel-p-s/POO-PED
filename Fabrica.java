import java.util.Scanner;
import java.util.ArrayList;

public class Fabrica {
    
    public static String[] admin = {"admin"};               //Atributo con el argumento para iniciar el programa en modo Admin
    public static String[] artesano = {"artesano"};         //Atributo con el argumento para iniciar el programa en modo Artesano
    public static BaseDeDatos bbdd = new BaseDeDatos();     //Atributo que inicializa la base de datos
    
    /*
     * Método main. Se encarga de interactuar con el usuario para el funcionamiento del programa.
     * Hace llamadas a las otras clases para hacerlo posible.
     */
    public static void main(String []args) {    
        if (args[0].equals(admin[0])) {
            System.out.println("\nMENÚ PRINCIPAL:\n");
            System.out.println("1. Base de datos de Muebles.");
            System.out.println("2. Base de datos de Empleados");
            System.out.println("3. Base de datos de Clientes.");
            System.out.println("4. Base de datos de Pedidos.");
            System.out.println("5. Salir.");
            System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
            Scanner sc = new Scanner(System.in);
            int eleccion = sc.nextInt();
            sc.nextLine();
            if(eleccion == 1) {
                bbddMuebles();
            } else if(eleccion == 2){
                bbddEmpleados();
            } else if(eleccion == 3) {
                bbddClientes();
            } else if(eleccion == 4) {
                bbddPedidos();
            } else if(eleccion == 5) {
                System.exit(0);
            } else {
                System.out.println("\nERROR: Hay que elegir un número del 1 al 5.\n");
                main(admin);
            }   
        } else if (args[0].equals(artesano[0])){
            System.out.println("\nMENÚ ARTESANO:\n");
            System.out.println("1. Ver mis pedidos.");
            System.out.println("2. Actualizar un pedido.");
            System.out.println("3. Dar pedido por finalizado.");
            System.out.println("4. Salir.");
            System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
            Scanner sc = new Scanner(System.in);
            int eleccion = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduce tu identificación: ");
            String identificacion = sc.nextLine();
            ArrayList<Pedido> pedidosArtesano = new ArrayList<Pedido>();
            pedidosArtesano = bbdd.returnPedidosIdentificador(identificacion);
            if(eleccion == 1) {
                if(bbdd.showPedidosArtesano(pedidosArtesano).equals("")){
                    System.out.println("No hay pedidos para mostrar.");
                    main(artesano);
                } else {
                    System.out.println(bbdd.showPedidosArtesano(pedidosArtesano));
                    System.out.println("Seleccione el número del pedido: ");
                    int pedido = sc.nextInt();
                    sc.nextLine();
                    System.out.println(bbdd.showPedidoArtesano(pedidosArtesano,pedido));
                    bbdd.addPedidosArtesano(pedidosArtesano);
                    main(artesano);
                }
            } else if(eleccion == 2){
                if(bbdd.showPedidosArtesano(pedidosArtesano).equals("")){
                    System.out.println("No hay pedidos para actualizar.");
                    main(artesano);
                } else {
                    System.out.println("\n" + bbdd.showPedidosArtesano(pedidosArtesano));
                    System.out.println("Escriba el numero del pedido que desea actualizar.");
                    int pedido = sc.nextInt();
                    sc.nextLine();
                    System.out.println(bbdd.showPedidoArtesano(pedidosArtesano,pedido));
                    Pedido nuevoPedido = pedidosArtesano.get(pedido-1);
                    bbdd.removePedidoArtesano(pedidosArtesano,pedido);
                    System.out.println("Introduce el comentario: ");
                    String comentario = sc.nextLine();
                    nuevoPedido.setComentario(comentario);
                    System.out.println("Introduce las piezas necesarias: ");
                    String piezas = sc.nextLine();
                    nuevoPedido.setPiezas(piezas);
                    pedidosArtesano.add(nuevoPedido);
                    bbdd.addPedidosArtesano(pedidosArtesano);
                    main(artesano);
                }
            } else if(eleccion == 3) {
                if(bbdd.showPedidosArtesano(pedidosArtesano).equals("")){
                    System.out.println("No hay pedidos para finalizar.");
                    main(artesano);
                } else {
                    System.out.println("\n" + bbdd.showPedidosArtesano(pedidosArtesano));
                    System.out.println("Escriba el numero del pedido que desea finalizar.");
                    int pedido = sc.nextInt();
                    sc.nextLine();
                    bbdd.removePedidoArtesano(pedidosArtesano,pedido);
                    System.out.println("Pedido terminado.");
                    bbdd.guardarPedidos(bbdd.pedidos);
                    main(artesano);
                }
            } else if(eleccion == 4) {
                System.exit(0);
            } else {
                System.out.println("\nERROR: Hay que elegir un número del 1 al 3.\n");
                main(artesano);
            } 
        } else {
            System.out.println("\nERROR FATAL: argumento incorrecto.\n");
        }
    }
    
    public static void bbddMuebles() {
        System.out.println("\nBBDD Muebles:\n");
        System.out.println("1. Ver mueble.");
        System.out.println("2. Crear un nuevo mueble.");
        System.out.println("3. Actualizar un mueble.");
        System.out.println("4. Volver al menú principal.");
        System.out.println("5. Salir.");
        System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        if(eleccion == 1) {
            if(bbdd.showMuebles().equals("")){
                System.out.println("No hay muebles para mostrar.");
                bbddMuebles();
            } else {
                System.out.println(bbdd.showMuebles());
                System.out.println("Escriba el numero del mueble que desea ver.");
                int numMueble = sc.nextInt();
                System.out.println("\n" + bbdd.showMueble(numMueble));
                bbddMuebles();
            }
        } else if(eleccion == 2){
            System.out.println("Introduzca el tiplo de mueble que quiere introducir: ");
            System.out.println("\n1) Mesa de Cafe de Cristal\n2) Mesa de Cafe de Madera\n3) Mesa de Dormitorio\n4) Mesa de Comedor");
            System.out.println("5) Silla de Cocina\n6) Silla de Oficina con Ruedas\n7) Silla de Oficina sin Ruedas\n8) Silla Plegable");
            int tipoMueble = sc.nextInt();
            sc.nextLine();
            switch(tipoMueble) {
                case 1: System.out.println("Has elegido Mesa de Cafe de Cristal.\nIntroduce el nombre: ");
                        String nombreMesaCC = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioMesaCC = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorMesaCC = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXMesaCC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYMesaCC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZMesaCC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la capacidad: ");
                        int capacidadMesaCC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el número de patas: ");
                        int patasMesaCC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la forma: ");
                        String formaMesaCC = sc.nextLine();
                        System.out.println("Introduce el tipo del cristal: ");
                        String tipoMesaCC = sc.nextLine();
                        MesaCafeCristal mesaCC = new MesaCafeCristal(nombreMesaCC,precioMesaCC,colorMesaCC,medidaXMesaCC,medidaYMesaCC,medidaZMesaCC,capacidadMesaCC,patasMesaCC,formaMesaCC,tipoMesaCC);
                        bbdd.addMueble(mesaCC);
                        break;
                case 2: System.out.println("Has elegido Mesa de Cafe de Madera.\nIntroduce el nombre: ");
                        String nombreMesaCM = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioMesaCM = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorMesaCM = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXMesaCM = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYMesaCM = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZMesaCM = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la capacidad: ");
                        int capacidadMesaCM = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el número de patas: ");
                        int patasMesaCM = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la forma: ");
                        String formaMesaCM = sc.nextLine();
                        System.out.println("Introduce el tipo de madera: ");
                        String tipoMesaCM = sc.nextLine();
                        MesaCafeMadera mesaCM = new MesaCafeMadera(nombreMesaCM,precioMesaCM,colorMesaCM,medidaXMesaCM,medidaYMesaCM,medidaZMesaCM,capacidadMesaCM,patasMesaCM,formaMesaCM,tipoMesaCM);
                        bbdd.addMueble(mesaCM);
                        break;
                case 3: System.out.println("Has elegido Mesa de Dormitorio.\nIntroduce el nombre: ");
                        String nombreMesaD = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioMesaD = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorMesaD = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXMesaD = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYMesaD = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZMesaD = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la capacidad: ");
                        int capacidadMesaD = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el número de patas: ");
                        int patasMesaD = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el material: ");
                        String materialMesaD = sc.nextLine();
                        MesaDormitorio mesaD = new MesaDormitorio(nombreMesaD,precioMesaD,colorMesaD,medidaXMesaD,medidaYMesaD,medidaZMesaD,capacidadMesaD,patasMesaD,materialMesaD);
                        bbdd.addMueble(mesaD);
                        break;
                case 4: System.out.println("Has elegido Mesa de Comedor.\nIntroduce el nombre: ");
                        String nombreMesaC = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioMesaC = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorMesaC = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXMesaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYMesaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZMesaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la capacidad: ");
                        int capacidadMesaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el número de patas: ");
                        int patasMesaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce el material: ");
                        String materialMesaC = sc.nextLine();
                        MesaComedor mesaC = new MesaComedor(nombreMesaC,precioMesaC,colorMesaC,medidaXMesaC,medidaYMesaC,medidaZMesaC,capacidadMesaC,patasMesaC,materialMesaC);
                        bbdd.addMueble(mesaC);
                        break;
                case 5: System.out.println("Has elegido Silla de Cocina.\nIntroduce el nombre: ");
                        String nombreSillaC = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioSillaC = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorSillaC = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXSillaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYSillaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZSillaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaXRespaldoSillaC = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaYRespaldoSillaC = sc.nextInt();
                        sc.nextLine();
                        SillaCocina sillaC = new SillaCocina(nombreSillaC,precioSillaC,colorSillaC,medidaXSillaC,medidaYSillaC,medidaZSillaC,medidaXRespaldoSillaC,medidaYRespaldoSillaC);
                        bbdd.addMueble(sillaC);
                        break;
                case 6: System.out.println("Has elegido Silla de Oficina con Ruedas.\nIntroduce el nombre: ");
                        String nombreSillaOCR = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioSillaOCR = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorSillaOCR = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXSillaOCR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYSillaOCR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZSillaOCR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaXRespaldoSillaOCR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaYRespaldoSillaOCR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                        String auxConReposabrazosSillaOCR = sc.nextLine();
                        boolean conReposabrazosSillaOCR;
                        if(auxConReposabrazosSillaOCR.equals("y")) {
                            conReposabrazosSillaOCR = true;
                        } else {
                            conReposabrazosSillaOCR = false;
                        }
                        System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                        String auxConReposacabezasSillaOCR = sc.nextLine();
                        boolean conReposacabezasSillaOCR;
                        if(auxConReposacabezasSillaOCR.equals("y")) {
                            conReposacabezasSillaOCR = true;
                        } else {
                            conReposacabezasSillaOCR = false;
                        }
                        System.out.println("Introduce el número de ruedas: ");
                        int numRuedasSillaOCR = sc.nextInt();
                        sc.nextLine();
                        SillaOficinaConRuedas sillaOCR = new SillaOficinaConRuedas(nombreSillaOCR,precioSillaOCR,colorSillaOCR,medidaXSillaOCR,medidaYSillaOCR,medidaZSillaOCR,medidaXRespaldoSillaOCR,medidaYRespaldoSillaOCR,conReposabrazosSillaOCR,conReposacabezasSillaOCR,numRuedasSillaOCR);
                        bbdd.addMueble(sillaOCR);
                        break;
                case 7: System.out.println("Has elegido Silla de Oficina sin Ruedas.\nIntroduce el nombre: ");
                        String nombreSillaOSR = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioSillaOSR = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorSillaOSR = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXSillaOSR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYSillaOSR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZSillaOSR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaXRespaldoSillaOSR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaYRespaldoSillaOSR = sc.nextInt();
                        sc.nextLine();
                        System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                        String auxConReposabrazosSillaOSR = sc.nextLine();
                        boolean conReposabrazosSillaOSR;
                        if(auxConReposabrazosSillaOSR.equals("y")) {
                            conReposabrazosSillaOSR = true;
                        } else {
                            conReposabrazosSillaOSR = false;
                        }
                        System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                        String auxConReposacabezasSillaOSR = sc.nextLine();
                        boolean conReposacabezasSillaOSR;
                        if(auxConReposacabezasSillaOSR.equals("y")) {
                            conReposacabezasSillaOSR = true;
                        } else {
                            conReposacabezasSillaOSR = false;
                        }
                        System.out.println("Introduce el número de patas: ");
                        int numPatasSillaOSR = sc.nextInt();
                        sc.nextLine();
                        SillaOficinaSinRuedas sillaOSR = new SillaOficinaSinRuedas(nombreSillaOSR,precioSillaOSR,colorSillaOSR,medidaXSillaOSR,medidaYSillaOSR,medidaZSillaOSR,medidaXRespaldoSillaOSR,medidaYRespaldoSillaOSR,conReposabrazosSillaOSR,conReposacabezasSillaOSR,numPatasSillaOSR);
                        bbdd.addMueble(sillaOSR);
                        break;
                case 8: System.out.println("Has elegido Silla Plegable.\nIntroduce el nombre: ");
                        String nombreSillaP = sc.nextLine();
                        System.out.println("Introduce el precio: ");
                        double precioSillaP = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Introduce el color: ");
                        String colorSillaP = sc.nextLine();
                        System.out.println("Introduce la medida X: ");
                        int medidaXSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y: ");
                        int medidaYSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Z: ");
                        int medidaZSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaXRespaldoSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y plegada: ");
                        int medidaYRespaldoSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida X del respaldo: ");
                        int medidaXPlegadaSillaP = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce la medida Y plegada: ");
                        int medidaYPlegadaSillaP = sc.nextInt();
                        sc.nextLine();
                        SillaPlegable sillaP = new SillaPlegable(nombreSillaP,precioSillaP,colorSillaP,medidaXSillaP,medidaYSillaP,medidaZSillaP,medidaXRespaldoSillaP,medidaYRespaldoSillaP,medidaXPlegadaSillaP,medidaYPlegadaSillaP);
                        bbdd.addMueble(sillaP);
                        break;
            }
            bbdd.guardarMuebles(bbdd.muebles);
            bbddMuebles();
        } else if(eleccion == 3) {
            if(bbdd.showMuebles().equals("")){
                System.out.println("No hay muebles para actualizar.");
                bbddMuebles();
            } else {
                System.out.println("\n" + bbdd.showMuebles());
                System.out.println("Escriba el numero del mueble que desea actualizar.");
                int numMueble = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showMueble(numMueble));
                int claseMueble = bbdd.returnMueble(numMueble).getClase();
                switch(claseMueble) {
                    case 1: System.out.println("Introduce el nombre: ");
                            String nombreMesaCC = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioMesaCC = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorMesaCC = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXMesaCC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYMesaCC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZMesaCC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la capacidad: ");
                            int capacidadMesaCC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el número de patas: ");
                            int patasMesaCC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la forma: ");
                            String formaMesaCC = sc.nextLine();
                            System.out.println("Introduce el tipo del cristal: ");
                            String tipoMesaCC = sc.nextLine();
                            MesaCafeCristal mesaCC = new MesaCafeCristal(nombreMesaCC,precioMesaCC,colorMesaCC,medidaXMesaCC,medidaYMesaCC,medidaZMesaCC,capacidadMesaCC,patasMesaCC,formaMesaCC,tipoMesaCC);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),mesaCC);
                            break;
                    case 2: System.out.println("Has elegido Mesa de Cocina de Madera.\nIntroduce el nombre: ");
                            String nombreMesaCM = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioMesaCM = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorMesaCM = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXMesaCM = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYMesaCM = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZMesaCM = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la capacidad: ");
                            int capacidadMesaCM = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el número de patas: ");
                            int patasMesaCM = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la forma: ");
                            String formaMesaCM = sc.nextLine();
                            System.out.println("Introduce el tipo de madera: ");
                            String tipoMesaCM = sc.nextLine();
                            MesaCafeMadera mesaCM = new MesaCafeMadera(nombreMesaCM,precioMesaCM,colorMesaCM,medidaXMesaCM,medidaYMesaCM,medidaZMesaCM,capacidadMesaCM,patasMesaCM,formaMesaCM,tipoMesaCM);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),mesaCM);
                            break;
                    case 3: System.out.println("Has elegido Mesa de Dormitorio.\nIntroduce el nombre: ");
                            String nombreMesaD = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioMesaD = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorMesaD = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXMesaD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYMesaD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZMesaD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la capacidad: ");
                            int capacidadMesaD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el número de patas: ");
                            int patasMesaD = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el material: ");
                            String materialMesaD = sc.nextLine();
                            MesaDormitorio mesaD = new MesaDormitorio(nombreMesaD,precioMesaD,colorMesaD,medidaXMesaD,medidaYMesaD,medidaZMesaD,capacidadMesaD,patasMesaD,materialMesaD);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),mesaD);
                            break;
                    case 4: System.out.println("Has elegido Mesa de Comedor.\nIntroduce el nombre: ");
                            String nombreMesaC = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioMesaC = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorMesaC = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXMesaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYMesaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZMesaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la capacidad: ");
                            int capacidadMesaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el número de patas: ");
                            int patasMesaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce el material: ");
                            String materialMesaC = sc.nextLine();
                            MesaComedor mesaC = new MesaComedor(nombreMesaC,precioMesaC,colorMesaC,medidaXMesaC,medidaYMesaC,medidaZMesaC,capacidadMesaC,patasMesaC,materialMesaC);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),mesaC);
                            break;
                    case 5: System.out.println("Has elegido Silla de Cocina.\nIntroduce el nombre: ");
                            String nombreSillaC = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioSillaC = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorSillaC = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXSillaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYSillaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZSillaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaXRespaldoSillaC = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaYRespaldoSillaC = sc.nextInt();
                            sc.nextLine();
                            SillaCocina sillaC = new SillaCocina(nombreSillaC,precioSillaC,colorSillaC,medidaXSillaC,medidaYSillaC,medidaZSillaC,medidaXRespaldoSillaC,medidaYRespaldoSillaC);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),sillaC);
                            break;
                    case 6: System.out.println("Has elegido Silla de Oficina con Ruedas.\nIntroduce el nombre: ");
                            String nombreSillaOCR = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioSillaOCR = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorSillaOCR = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXSillaOCR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYSillaOCR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZSillaOCR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaXRespaldoSillaOCR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaYRespaldoSillaOCR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                            String auxConReposabrazosSillaOCR = sc.nextLine();
                            boolean conReposabrazosSillaOCR;
                            if(auxConReposabrazosSillaOCR.equals("y")) {
                                conReposabrazosSillaOCR = true;
                            } else {
                                conReposabrazosSillaOCR = false;
                            }
                            System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                            String auxConReposacabezasSillaOCR = sc.nextLine();
                            boolean conReposacabezasSillaOCR;
                            if(auxConReposacabezasSillaOCR.equals("y")) {
                                conReposacabezasSillaOCR = true;
                            } else {
                                conReposacabezasSillaOCR = false;
                            }
                            System.out.println("Introduce el número de ruedas: ");
                            int numRuedasSillaOCR = sc.nextInt();
                            sc.nextLine();
                            SillaOficinaConRuedas sillaOCR = new SillaOficinaConRuedas(nombreSillaOCR,precioSillaOCR,colorSillaOCR,medidaXSillaOCR,medidaYSillaOCR,medidaZSillaOCR,medidaXRespaldoSillaOCR,medidaYRespaldoSillaOCR,conReposabrazosSillaOCR,conReposacabezasSillaOCR,numRuedasSillaOCR);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),sillaOCR);
                            break;
                   case 7:  System.out.println("Has elegido Silla de Oficina sin Ruedas.\nIntroduce el nombre: ");
                            String nombreSillaOSR = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioSillaOSR = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorSillaOSR = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXSillaOSR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYSillaOSR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZSillaOSR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaXRespaldoSillaOSR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaYRespaldoSillaOSR = sc.nextInt();
                            sc.nextLine();
                            System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                            String auxConReposabrazosSillaOSR = sc.nextLine();
                            boolean conReposabrazosSillaOSR;
                            if(auxConReposabrazosSillaOSR.equals("y")) {
                                conReposabrazosSillaOSR = true;
                            } else {
                                conReposabrazosSillaOSR = false;
                            }
                            System.out.println("¿Tiene reposacabezas? y:si | n:no ");
                            String auxConReposacabezasSillaOSR = sc.nextLine();
                            boolean conReposacabezasSillaOSR;
                            if(auxConReposacabezasSillaOSR.equals("y")) {
                                conReposacabezasSillaOSR = true;
                            } else {
                                conReposacabezasSillaOSR = false;
                            }
                            System.out.println("Introduce el número de patas: ");
                            int numPatasSillaOSR = sc.nextInt();
                            sc.nextLine();
                            SillaOficinaSinRuedas sillaOSR = new SillaOficinaSinRuedas(nombreSillaOSR,precioSillaOSR,colorSillaOSR,medidaXSillaOSR,medidaYSillaOSR,medidaZSillaOSR,medidaXRespaldoSillaOSR,medidaYRespaldoSillaOSR,conReposabrazosSillaOSR,conReposacabezasSillaOSR,numPatasSillaOSR);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),sillaOSR);
                            break;
                   case 8:  System.out.println("Has elegido Silla Plegable.\nIntroduce el nombre: ");
                            String nombreSillaP = sc.nextLine();
                            System.out.println("Introduce el precio: ");
                            double precioSillaP = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Introduce el color: ");
                            String colorSillaP = sc.nextLine();
                            System.out.println("Introduce la medida X: ");
                            int medidaXSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y: ");
                            int medidaYSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Z: ");
                            int medidaZSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaXRespaldoSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y plegada: ");
                            int medidaYRespaldoSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida X del respaldo: ");
                            int medidaXPlegadaSillaP = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce la medida Y plegada: ");
                            int medidaYPlegadaSillaP = sc.nextInt();
                            sc.nextLine();
                            SillaPlegable sillaP = new SillaPlegable(nombreSillaP,precioSillaP,colorSillaP,medidaXSillaP,medidaYSillaP,medidaZSillaP,medidaXRespaldoSillaP,medidaYRespaldoSillaP,medidaXPlegadaSillaP,medidaYPlegadaSillaP);
                            bbdd.muebles.remove(numMueble-1);
                            bbdd.muebles.add((numMueble-1),sillaP);
                            break;
                }
            }
            bbdd.guardarMuebles(bbdd.muebles);
            bbddMuebles();
        } else if(eleccion == 4) {
            main(admin);
        } else if(eleccion == 5) {
            System.exit(0);
        } else {
            System.out.println("\nERROR: Hay que elegir un número del 1 al 5.\n");
            main(admin);
        }   
    }
    
    public static void bbddEmpleados() {
        System.out.println("\nBBDD Empleados:\n");
        System.out.println("1. Ver empleado.");
        System.out.println("2. Crear un nuevo empleado.");
        System.out.println("3. Actualizar un empleado.");
        System.out.println("4. Volver al menú principal.");
        System.out.println("5. Salir.");
        System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        if(eleccion == 1) {
            if(bbdd.showEmpleados().equals("")){
                System.out.println("No hay empleados para mostrar.");
                bbddEmpleados();
            } else {
                System.out.println(bbdd.showEmpleados());
                System.out.println("Escriba el numero del empleado que desea ver.");
                int numEmpleado = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showEmpleado(numEmpleado));
                bbddEmpleados();
            }
        } else if(eleccion == 2){
            System.out.println("Introduzca el tiplo de empleado que quiere introducir: ");
            System.out.println("\n1) Jefe\n2) Comercial");
            System.out.println("3) Artesano por horas\n4) Artesano en plantilla");
            int tipoEmpleado = sc.nextInt();
            sc.nextLine();
            switch(tipoEmpleado) {
                case 1: System.out.println("Has elegido Jefe.\nIntroduce el nombre: ");
                        String nombreJefe = sc.nextLine();
                        System.out.println("Introduce la identificación: ");
                        String identificacionJefe = sc.nextLine();
                        System.out.println("Introduce su sueldo: ");
                        int sueldoJefe = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce su departamento: ");
                        int departamentoJefe = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce su número de trabajadores: ");
                        int trabajadoresJefe = sc.nextInt();
                        sc.nextLine();
                        Jefe jefe = new Jefe(nombreJefe,identificacionJefe,sueldoJefe,departamentoJefe,trabajadoresJefe);
                        bbdd.addEmpleado(jefe);
                        break;
                case 2: System.out.println("Has elegido Comercial.\nIntroduce el nombre: ");
                        String nombreComercial = sc.nextLine();
                        System.out.println("Introduce la identificación: ");
                        String identificacionComercial = sc.nextLine();
                        System.out.println("Introduce su sueldo: ");
                        int sueldoComercial = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce su departamento: ");
                        int departamentoComercial = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce sus ventas mensuales: ");
                        int trabajadoresComercial = sc.nextInt();
                        sc.nextLine();
                        Comercial comercial = new Comercial(nombreComercial,identificacionComercial,sueldoComercial,departamentoComercial,trabajadoresComercial);
                        bbdd.addEmpleado(comercial);
                        break;
                case 3: System.out.println("Has elegido Artesano por Horas.\nIntroduce el nombre: ");
                        String nombreArtesanoPorHoras = sc.nextLine();
                        System.out.println("Introduce la identificación: ");
                        String identificacionArtesanoPorHoras = sc.nextLine();
                        System.out.println("Introduce su sueldo: ");
                        int sueldoArtesanoPorHoras = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce su departamento: ");
                        int departamentoArtesanoPorHoras = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce sus trabajos hechos este mes: ");
                        int trabajosHechosArtesanoPorHoras = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce sus horas hechas este mes: ");
                        int horasHechasArtesanoPorHoras = sc.nextInt();
                        sc.nextLine();
                        ArtesanoPorHoras artesanoPorHoras = new ArtesanoPorHoras(nombreArtesanoPorHoras,identificacionArtesanoPorHoras,sueldoArtesanoPorHoras,departamentoArtesanoPorHoras,trabajosHechosArtesanoPorHoras,horasHechasArtesanoPorHoras);
                        bbdd.addEmpleado(artesanoPorHoras);
                        break;
                case 4: System.out.println("Has elegido Artesano en Plantilla.\nIntroduce el nombre: ");
                        String nombreArtesanoEnPlantilla = sc.nextLine();
                        System.out.println("Introduce la identificación: ");
                        String identificacionArtesanoEnPlantilla = sc.nextLine();
                        System.out.println("Introduce su sueldo: ");
                        int sueldoArtesanoEnPlantilla = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce su departamento: ");
                        int departamentoArtesanoEnPlantilla = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce sus trabajos hechos este mes: ");
                        int trabajosHechosArtesanoEnPlantilla = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce sus horas por contrato: ");
                        int horasArtesanoEnPlantilla = sc.nextInt();
                        sc.nextLine();
                        ArtesanoEnPlantilla artesanoEnPlantilla = new ArtesanoEnPlantilla(nombreArtesanoEnPlantilla,identificacionArtesanoEnPlantilla,sueldoArtesanoEnPlantilla,departamentoArtesanoEnPlantilla,trabajosHechosArtesanoEnPlantilla,horasArtesanoEnPlantilla);
                        bbdd.addEmpleado(artesanoEnPlantilla);
                        break;
            }
            bbdd.guardarEmpleados(bbdd.empleados);
            bbddEmpleados();
        } else if(eleccion == 3) {
            if(bbdd.showEmpleados().equals("")){
                System.out.println("No hay empleados para actualizar.");
                bbddEmpleados();
            } else {
                System.out.println("\n" + bbdd.showEmpleados());
                System.out.println("Escriba el numero del empleado que desea actualizar.");
                int numEmpleado = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showEmpleado(numEmpleado));
                int claseEmpleado = bbdd.returnEmpleado(numEmpleado).getClase();
                switch(claseEmpleado) {
                    case 1: System.out.println("Has elegido Jefe.\nIntroduce el nombre: ");
                            String nombreJefe = sc.nextLine();
                            System.out.println("Introduce la identificación: ");
                            String identificacionJefe = sc.nextLine();
                            System.out.println("Introduce su sueldo: ");
                            int sueldoJefe = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce su departamento: ");
                            int departamentoJefe = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce su número de trabajadores: ");
                            int trabajadoresJefe = sc.nextInt();
                            sc.nextLine();
                            Jefe jefe = new Jefe(nombreJefe,identificacionJefe,sueldoJefe,departamentoJefe,trabajadoresJefe);
                            bbdd.empleados.remove(numEmpleado-1);
                            bbdd.empleados.add((numEmpleado-1),jefe);
                            break;
                    case 2: System.out.println("Has elegido Comercial.\nIntroduce el nombre: ");
                            String nombreComercial = sc.nextLine();
                            System.out.println("Introduce la identificación: ");
                            String identificacionComercial = sc.nextLine();
                            System.out.println("Introduce su sueldo: ");
                            int sueldoComercial = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce su departamento: ");
                            int departamentoComercial = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce sus ventas mensuales: ");
                            int trabajadoresComercial = sc.nextInt();
                            sc.nextLine();
                            Comercial comercial = new Comercial(nombreComercial,identificacionComercial,sueldoComercial,departamentoComercial,trabajadoresComercial);
                            bbdd.empleados.remove(numEmpleado-1);
                            bbdd.empleados.add((numEmpleado-1),comercial);
                            break;
                    case 3: System.out.println("Has elegido Artesano por Horas.\nIntroduce el nombre: ");
                            String nombreArtesanoPorHoras = sc.nextLine();
                            System.out.println("Introduce la identificación: ");
                            String identificacionArtesanoPorHoras = sc.nextLine();
                            System.out.println("Introduce su sueldo: ");
                            int sueldoArtesanoPorHoras = sc.nextInt();
                            System.out.println("Introduce su departamento: ");
                            int departamentoArtesanoPorHoras = sc.nextInt();
                            System.out.println("Introduce sus trabajos hechos este mes: ");
                            int trabajosHechosArtesanoPorHoras = sc.nextInt();
                            System.out.println("Introduce sus horas hechas este mes: ");
                            int horasHechasArtesanoPorHoras = sc.nextInt();
                            ArtesanoPorHoras artesanoPorHoras = new ArtesanoPorHoras(nombreArtesanoPorHoras,identificacionArtesanoPorHoras,sueldoArtesanoPorHoras,departamentoArtesanoPorHoras,trabajosHechosArtesanoPorHoras,horasHechasArtesanoPorHoras);
                            bbdd.empleados.remove(numEmpleado-1);
                            bbdd.empleados.add((numEmpleado-1),artesanoPorHoras);
                            break;
                    case 4: System.out.println("Has elegido Artesano en Plantilla.\nIntroduce el nombre: ");
                            String nombreArtesanoEnPlantilla = sc.nextLine();
                            System.out.println("Introduce la identificación: ");
                            String identificacionArtesanoEnPlantilla = sc.nextLine();
                            System.out.println("Introduce su sueldo: ");
                            int sueldoArtesanoEnPlantilla = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce su departamento: ");
                            int departamentoArtesanoEnPlantilla = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce sus trabajos hechos este mes: ");
                            int trabajosHechosArtesanoEnPlantilla = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Introduce sus horas por contrato: ");
                            int horasArtesanoEnPlantilla = sc.nextInt();
                            sc.nextLine();
                            ArtesanoEnPlantilla artesanoEnPlantilla = new ArtesanoEnPlantilla(nombreArtesanoEnPlantilla,identificacionArtesanoEnPlantilla,sueldoArtesanoEnPlantilla,departamentoArtesanoEnPlantilla,trabajosHechosArtesanoEnPlantilla,horasArtesanoEnPlantilla);
                            bbdd.empleados.remove(numEmpleado-1);
                            bbdd.empleados.add((numEmpleado-1),artesanoEnPlantilla);
                            break;
                }
            }
            bbdd.guardarEmpleados(bbdd.empleados);
            bbddEmpleados();
        } else if(eleccion == 4) {
            main(admin);
        } else if(eleccion == 5) {
            System.exit(0);
        } else {
            System.out.println("\nERROR: Hay que elegir un número del 1 al 5.\n");
            main(admin);
        }
    }
    
    public static void bbddClientes() {
        System.out.println("\nBBDD Clientes:\n");
        System.out.println("1. Ver cliente.");
        System.out.println("2. Crear un nuevo cliente.");
        System.out.println("3. Actualizar un cliente.");
        System.out.println("4. Volver al menú principal.");
        System.out.println("5. Salir.");
        System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        if(eleccion == 1) {
            if(bbdd.showClientes().equals("")){
                System.out.println("No hay clientes para mostrar.");
                bbddClientes();
            } else {
                System.out.println(bbdd.showClientes());
                System.out.println("Escriba el numero del cliente que desea ver.");
                int numCliente = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showCliente(numCliente));
                bbddClientes();
            }
        } else if(eleccion == 2){
            System.out.println("Introduzca si es una persona o una empresa: ");
            System.out.println("\n1) Persona\n2) Empresa");
            int tipoCliente = sc.nextInt();
            sc.nextLine();
            switch(tipoCliente) {
                case 1: System.out.println("Has elegido Persona.\nIntroduce el nombre: ");
                        String nombrePersona = sc.nextLine();
                        System.out.println("Introduce la identificacion: ");
                        String identificacionPersona = sc.nextLine();
                        System.out.println("Introduce la localidad: ");
                        String localidadPersona = sc.nextLine();
                        System.out.println("Introduce el nivel VIP: ");
                        int vipPersona = sc.nextInt();
                        sc.nextLine();
                        ClientePersona clienteP = new ClientePersona(nombrePersona,identificacionPersona,localidadPersona,vipPersona);
                        bbdd.addCliente(clienteP);
                        break;
                case 2: System.out.println("Has elegido Empresa.\nIntroduce el nombre: ");
                        String nombreEmpresa = sc.nextLine();
                        System.out.println("Introduce la identificacion: ");
                        String identificacionEmpresa = sc.nextLine();
                        System.out.println("Introduce la localidad: ");
                        String localidadEmpresa = sc.nextLine();
                        System.out.println("Introduce el sector: ");
                        String sectorEmpresa = sc.nextLine();
                        ClienteEmpresa clienteE = new ClienteEmpresa(nombreEmpresa,identificacionEmpresa,localidadEmpresa,sectorEmpresa);
                        bbdd.addCliente(clienteE);
                        break;
            }
            bbdd.guardarClientes(bbdd.clientes);
            bbddClientes();
        } else if(eleccion == 3) {
            if(bbdd.showClientes().equals("")){
                System.out.println("No hay empleados para actualizar.");
                bbddClientes();
            } else {
                System.out.println("\n" + bbdd.showClientes());
                System.out.println("Escriba el numero del cliente que desea actualizar.");
                int numCliente = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showCliente(numCliente));
                int claseCliente = bbdd.returnCliente(numCliente).getClase();
                switch(claseCliente) {
                    case 1: System.out.println("Has elegido Persona.\nIntroduce el nombre: ");
                            String nombrePersona = sc.nextLine();
                            System.out.println("Introduce la identificacion: ");
                            String identificacionPersona = sc.nextLine();
                            System.out.println("Introduce la localidad: ");
                            String localidadPersona = sc.nextLine();
                            System.out.println("Introduce el nivel VIP: ");
                            int vipPersona = sc.nextInt();
                            sc.nextLine();
                            ClientePersona clienteP = new ClientePersona(nombrePersona,identificacionPersona,localidadPersona,vipPersona);
                            bbdd.clientes.remove(numCliente-1);
                            bbdd.clientes.add((numCliente-1),clienteP);
                            break;
                    case 2: System.out.println("Has elegido Empresa.\nIntroduce el nombre: ");
                            String nombreEmpresa = sc.nextLine();
                            System.out.println("Introduce la identificacion: ");
                            String identificacionEmpresa = sc.nextLine();
                            System.out.println("Introduce la localidad: ");
                            String localidadEmpresa = sc.nextLine();
                            System.out.println("Introduce el sector: ");
                            String sectorEmpresa = sc.nextLine();
                            ClienteEmpresa clienteE = new ClienteEmpresa(nombreEmpresa,identificacionEmpresa,localidadEmpresa,sectorEmpresa);
                            bbdd.clientes.remove(numCliente-1);
                            bbdd.clientes.add((numCliente-1),clienteE);
                            break;
                }
                bbdd.guardarClientes(bbdd.clientes);
                bbddClientes();
            }
        } else if(eleccion == 4) {
            main(admin);
        } else if(eleccion == 5) {
            System.exit(0);
        } else {
            System.out.println("\nERROR: Hay que elegir un número del 1 al 4.\n");
            main(admin);
        }
    }
    
    public static void bbddPedidos() {
        System.out.println("\nBBDD Pedidos:\n");
        System.out.println("1. Ver pedido.");
        System.out.println("2. Crear un nuevo pedido.");    
        System.out.println("3. Volver al menú principal.");
        System.out.println("4. Salir.");
        System.out.println("Escriba el número correspondiente y haga click en ENTRAR");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();
        sc.nextLine();
        if(eleccion == 1) {
            if(bbdd.showPedidos().equals("")){
                System.out.println("No hay pedidos para mostrar.");
                bbddPedidos();
            } else {
                System.out.println(bbdd.showPedidos());
                System.out.println("Escriba el numero del pedido que desea ver.");
                int numPedido = sc.nextInt();
                sc.nextLine();
                System.out.println(bbdd.showPedido(numPedido));
            }
            bbddPedidos();
        } else if(eleccion == 2){
            if(bbdd.showClientes().equals("")){
                System.out.println("No hay clientes creados, primero crea un cliente.\n");
                bbddClientes();
            } else if(bbdd.showMuebles().equals("")) {
                System.out.println("No hay muebles creados, primero crea un mueble.\n");
                bbddMuebles();
            } else if(bbdd.showArtesanos().equals("")) {
                System.out.println("No hay artesanos creados, primero crea un artesano.\n");
                bbddEmpleados();
            } else {
                System.out.println("Introduce el nombre: ");
                String nombre = sc.nextLine();
                System.out.println(bbdd.showClientes());
                System.out.println("Introduce el cliente: ");
                int auxCliente = sc.nextInt();
                sc.nextLine();
                Cliente cliente = bbdd.returnCliente(auxCliente);
                System.out.println(bbdd.showMuebles());
                System.out.println("Introduce el mueble: ");
                int auxMueblePersona = sc.nextInt();
                sc.nextLine();
                Mueble mueble = bbdd.returnMueble(auxMueblePersona);
                System.out.println(bbdd.showArtesanos());
                System.out.println("Introduce el artesano: ");
                int auxArtesanoPersona = sc.nextInt();
                sc.nextLine();
                Artesano artesano = (Artesano)bbdd.returnEmpleado(auxArtesanoPersona);
                String comentario = "";
                String piezas = "";
                Pedido pedido = new Pedido(nombre,cliente,mueble,artesano,comentario,piezas);
                bbdd.addPedido(pedido);
                bbdd.guardarPedidos(bbdd.pedidos);
                bbddPedidos();
            }
        } else if(eleccion == 3) {
            main(admin);
        } else if(eleccion == 4) {
            System.exit(0);
        } else {
            System.out.println("\nERROR: Hay que elegir un número del 1 al 4.\n");
            main(admin);
        }
    }
}