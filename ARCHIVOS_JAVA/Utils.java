/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo de la carpeta fuente
 */

/**
 * Clase Utils
 *
 * Contiene metodos estaticos con distintas funcionalidades que utilizaremos en cualquier clase que las necesite
 *
 * @author Raul Carretero
 * @version 1
 */
import EstadosPedido.*;
import java.io.*;
import java.util.*;
public class Utils
{
    /**
     * Ruta estatica donde almacenamos los ficheros
     */
    public static final String RUTA="./ARCHIVOS_JAVA/FICHEROS/";

    /**
     * Muestra un texto y espera una entrada del teclado
     * @return Valor introducido por teclado
     */
    public static String preguntarString(String pregunta) {
        System.out.print(pregunta+"\n ");
        Scanner entrada = new Scanner(System.in);

        return entrada.nextLine();
    }

    /**
     * Muestra un texto y espera un numero entre min y max por el teclado
     * @return numero introducido
     */
    public static int preguntarInt(String pregunta, int min, int max) {
        boolean repetir = true;
        int resultado = -1;
        do {
            String valor = Utils.preguntarString(pregunta);
            try {
                resultado = Integer.parseInt(valor);
                repetir = (resultado < min) || (resultado > max);
                if (repetir) {
                    System.out.println("Error: "+resultado+" fuera de rango");
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: "+valor+" no es un numero Valido");
            }
        } while (repetir);

        return resultado;
    }

    /**
     * Muestra un texto y espera un numero double por el teclado
     * @return numero introducido
     */
    public static double preguntarDouble(String pregunta, double min, double max) {
        boolean repetir = true;
        double resultado = -1;
        do {
            String valor = Utils.preguntarString(pregunta);
            try {
                resultado = Double.parseDouble(valor);
                repetir = (resultado < min) || (resultado > max);
                if (repetir) {
                    System.out.println("Error: "+resultado+" fuera de rango");
                    System.out.println("Rango valido: de "+min+" a "+max);
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: "+valor+" no es un numero Valido");
            }
        } while (repetir);

        return resultado;
    }

    /**
     * Almacenamos informacion ya generada en los arrayList(almacenes)
     * @param pedidos almacen de pedidos
     * @param clientes almacen de clientes
     */
    public static void arrancarArrayList(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes)
    {
        //CLIENTES
        Cliente c;

        //11 RESTAURANTES
        /*0*/ c=new Restaurante( "Francisco Navarro", 647556985,"C/ Alfahuir 95","06/03/2008", "General.Restaurante Pare Pere", 963225204);
        clienteOrdenado(c, clientes);

        /*1*/c=new Restaurante( "Pablo Escobar", 721465398,"C/ 67225 Hermiston Streets","19/09/1982", "Sin City Cocina", 967663660);
        clienteOrdenado(c, clientes);

        /*2*/c=new Restaurante( "Rafa Nadal", 664380438,"C/ 9809 Jovanny Junction","05/02/2008", "Fresca y Soledad", 968408584);
        clienteOrdenado(c, clientes);

        /*3*/c=new Restaurante( "Bad Bunny", 659839293,"C/ 977 Cormier Center","20/05/2001", "cocina latina", 960621640);
        clienteOrdenado(c, clientes);

        /*4*/c=new Restaurante( "Jacobo Collado", 680919287,"C/ 054 Carter Mountain","08/09/2002", "Saná Plaza", 969485887);
        clienteOrdenado(c, clientes);

        /*5*/ c=new Restaurante( "Marcelino Antolin", 601494887,"C/ 794 Schaefer Brooks","05/05/2006", "Saffron", 926545743);
        clienteOrdenado(c, clientes);

        /*6*/ c=new Restaurante( "Amal Vegas", 651707693,"C/ 040 Maggio Garden","20/11/2010", "Parlay", 925874984);
        clienteOrdenado(c, clientes);

        /*7*/c=new Restaurante( "Arnau Alcaide", 702604457,"C/ 7572 Nicolas Shore","13/05/2015", "Ambience", 980992356);
        clienteOrdenado(c, clientes);

        /*8*/c=new Restaurante( "Cecilio Lloret", 637815243,"C/ 66376 Janis Villages","07/10/2016", "El rincón enchilado", 980433384);
        clienteOrdenado(c, clientes);

        /*9*/c=new Restaurante( "Ayman Vazquez", 767675424,"C/ 4613 Beatty Creek","01/09/2000", "Comer & Beber", 963042203);
        clienteOrdenado(c, clientes);

        /*10*/c=new Restaurante( "Alfredo Herranz", 659483057,"C/ 7745 Mayer Locks","11/11/2018", "Paella en casa", 973430135);
        clienteOrdenado(c, clientes);

        //11 CLIENTES
        /*0*/c=new Persona( "Martin Vicente", 725569742,"C/ 22061 Ahmad Highway","18/01/2013");
        clienteOrdenado(c, clientes);

        /*1*/c=new Persona( "Vicente Bacete", 714368636,"C/ San Juan Bosco 94","24/12/1990");
        clienteOrdenado(c, clientes);

        /*2*/c=new Persona( "Vicente Del Bosque", 681581593,"C/ 150 Lucie Roads","17/08/1992");
        clienteOrdenado(c, clientes);

        /*3*/c=new Persona( "Maradona", 776365080,"C/ 537 Ryley Square","06/11/1994");
        clienteOrdenado(c, clientes);

        /*4*/c=new Persona( "Oscar Garrido", 634853631,"C/ 817 Thad Turnpike","21/09/2016");
        clienteOrdenado(c, clientes);

        /*5*/c=new Persona( "Sara Cano", 726363961,"C/ 95026 Dorcas Squares","25/12/1987");
        clienteOrdenado(c, clientes);

        /*6*/c=new Persona( "Gema Muñoz", 638684111,"C/ 4686 Schoen Trail","14/12/2013");
        clienteOrdenado(c, clientes);

        /*7*/c=new Persona( "Angela-Maria Meseguer", 634160910,"C/ 6742 Esperanza Path","05/11/2017");
        clienteOrdenado(c, clientes);

        /*8*/c=new Persona( "Ion Velasco", 672953833,"C/ 57798 Valentine Parks","22/04/2021");
        clienteOrdenado(c, clientes);

        /*9*/c=new Persona( "Paula Oliver", 769948141,"C/ 4750 Marcos Islands","31/12/2006");
        clienteOrdenado(c, clientes);

        /*10*/c=new Persona( "Filomena Cid", 663059098,"C/ 31205 Fahey Ramp","02/11/2016");
        clienteOrdenado(c, clientes);


        //PEDIDOS
        Pedido p;

        /*0*/p=new Pedido(clientes.get(21),"Llamar una vez el pedido esta preparado (Saber recogida o envio)", "11/12/2010");
        p.nuevoDetalle("Galicia", "Pulpo", 4.16f , 24f );
        p.nuevoDetalle("Valencia", "Clochina", 3f, 4.5f );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*1*/p=new Pedido(clientes.get(0),"Preparar para congelar para viaje largo", "10/05/2020");
        p.nuevoDetalle("Mediterraneo", "Gambon", 3.04f , 28.9f );
        p.nuevoDetalle("Galicia", "Mejillon", 2.76f , 23.5f );
        p.nuevoDetalle("Barcelona", "Calamares", 0.92f, 22 );
        p.nuevoDetalle("Marruecos", "Tellinas", 4.47f , 13.9f );
        p.nuevoDetalle("Francia", "Chirlas", 3.95f , 11.25f );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*2*/p=new Pedido(clientes.get(6),"", "30/07/2020");
        p.nuevoDetalle("Valencia", "Palayas", 2.5f , 23 );
        p.nuevoDetalle("Barcelona", "Sepia", 0.47f , 16.5f);
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);;

        /*3*/p=new Pedido(clientes.get(8),"Llamar al momento de pedido completado", "26/09/2019");
        p.nuevoDetalle("Asturias", "Merluza", 1.21f , 16 );
        p.nuevoDetalle("Noruega", "Salmon", 1.29f , 24.0f );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*4*/p=new Pedido(clientes.get(10),"Llevar a domicilio", "04/06/2023");
        p.nuevoDetalle("Portugal", "Atun", 4.22f , 24.0f );
        p.setEstado(Preparacion.getInstance());
        pedidoOrdenado(p, pedidos);

        /*5*/p=new Pedido(clientes.get(12),"Subirle precio, mal trato al trabajador jejeje", "06/09/2020");
        p.nuevoDetalle("Congelado", "Quisquilla", 4.94f  , 29.33f  );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*6*/p=new Pedido(clientes.get(10),"Precio especial amigo", "19/08/2019");
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*7*/p=new Pedido(clientes.get(10),"", "21/05/2022");
        p.nuevoDetalle("Sevilla", "Gamba Roja", 1.15f , 29.43f  );
        p.nuevoDetalle("Francia", "Almejas", 1.85f , 31.90f  );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*8*/p=new Pedido(clientes.get(6),"Llamar una vez el pedido esta preparado", "13/09/2019");
        p.nuevoDetalle("Murcia", "Sargo Real", 2.74f , 16.14f  );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*9*/p=new Pedido(clientes.get(3),"", "19/10/2020");
        p.nuevoDetalle("Alicante", "Calamares", 3.86f , 26.47f  );
        p.nuevoDetalle("Valencia", "Puntilla", 3.51f , 29.54f  );
        p.nuevoDetalle("Castellon", "Lenguado", 0.89f , 16.65f  );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);

        /*10*/p=new Pedido(clientes.get(16),"Preparar envasado al vacio", "12/05/2012");
        p.nuevoDetalle("Francia", "Ostras", 1.68f , 29.54f  );
        p.nuevoDetalle("Congelado", "Colas de Gamba", 2.20f , 31.79f  );
        p.setEstado(Completado.getInstance());
        pedidoOrdenado(p, pedidos);
    }

    /**
     * Lee el fichero donde hay informacion de compras y lo carga en el arraylist
     * @param compras arraylist de compras
     */
    public static void arranqueCompras(ArrayList<Compra> compras)
    {
        final String FICHERO="compras.obj";
        try
        {
            File f=null;
            FileInputStream fi=null;
            ObjectInputStream obj=null;
            try
            {
                f=new File(RUTA+FICHERO);

                if(f.exists())
                {
                    fi=new FileInputStream(f);
                    obj=new ObjectInputStream(fi);

                    while(true)
                    {
                        Compra li1=(Compra)obj.readObject();
                        compras.add(li1);
                    }
                }
            }
            catch(EOFException eof){
                System.out.println("--------------------------------");
            }
            catch(FileNotFoundException fnf){
                System.out.println("--------------------------------");
            }
            catch(Throwable t){
                System.out.println("--------------------------------");
            }
            finally{
                if(obj!=null )
                {
                    obj.close();
                    fi.close();
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Lee el fichero donde hay informacion de proveedores y lo carga en el arraylist
     * @param proveedores arraylist de proveedores
     */
    public static void arranqueProveedores(ArrayList<Proveedor> proveedores)
    {
        final String FICHERO="proveedores.obj";
        try
        {
            File f=null;
            FileInputStream fi=null;
            ObjectInputStream obj=null;
            try
            {
                f=new File(RUTA+FICHERO);
                if(f.exists())
                {
                    fi=new FileInputStream(f);
                    obj=new ObjectInputStream(fi);

                    while(true)
                    {
                        //COMPRAS
                        Proveedor li1=(Proveedor) obj.readObject();
                        proveedores.add(li1);
                    }
                }
            }
            catch(EOFException eof){
                System.out.println("--------------------------------");
            }
            catch(FileNotFoundException fnf){
                System.out.println("--------------------------------");
            }
            catch(Throwable t){
                System.out.println("--------------------------------");
            }
            finally{
                if(obj!=null )
                {
                    obj.close();
                    fi.close();
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Almacenamos el nuevo cliente en el arraylist, ordenado por fechas(de mas nuevo a mas viejo)
     * @param c nuevo cliente que vamos a almacenar
     * @param clientes almacen de clientes ordenados
     */
    public static void clienteOrdenado(Cliente c, ArrayList<Cliente> clientes)
    {
        if(clientes.size()>0)
        {
            //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
            int orden = -1;
            int i=0;
            boolean esta=false;
            while (i<clientes.size() && !esta)
            {
                int masNuevo = clientes.get(i).getFechaNum();
                if (c.getFechaNum() > masNuevo) //si la fecha es mayor a la que tenemos significa que es mas nueva
                {
                    orden = i;//almacenamos la posicion donde tenemos que meter el nuevo cliente
                    esta=true;
                }
                else {
                    i++;
                }
            }
            if (orden <0)
                clientes.add(c);
            else
                clientes.add(orden, c);
        }
        else clientes.add(c);
    }

    /**
     * Almacenamos el nuevo pedido en el arraylist, ordenado por fechas(de mas nuevo a mas viejo)
     * @param p nuevo pedido que vamos a almacenar
     * @param pedidos almacen de pedidos ordenados
     */
    public static void pedidoOrdenado(Pedido p, ArrayList<Pedido> pedidos)
    {

            //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
            int orden = -1;
            int i=0;
            boolean esta=false;
            while (i<pedidos.size() && !esta)
            {
                int masNuevo = pedidos.get(i).getFechaNum();
                if (p.getFechaNum() > masNuevo) //si la fecha es mayor a la que tenemos significa que es mas nueva
                {
                    orden = i;//almacenamos la posicion donde tenemos que meter el nuevo pedido
                    esta=true;
                }
                else {
                    i++;
                }
            }
            if (orden <0)
                pedidos.add(p);
            else
                pedidos.add(orden, p);

    }

    /**
     * Almacenamos la nueva compra en el arraylist, ordenado por fechas(de mas nuevo a mas viejo)
     * @param c nueva compra que vamos a almacenar
     * @param compras almacen de compras ordenadas
     */
    public static void compraOrdenada(Compra c, ArrayList<Compra> compras)
    {
        if(compras.size()>0)
        {
            //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
            int orden = -1;
            int i=0;
            boolean esta=false;
            while (i<compras.size() && !esta)
            {
                int masNuevo = compras.get(i).getFechaNum();
                if (c.getFechaNum() > masNuevo) //si la fecha es mayor a la que tenemos significa que es mas nueva
                {
                    orden = i;//almacenamos la posicion donde tenemos que meter la nueva compra
                    esta=true;
                }
                else {
                    i++;
                }
            }
            if (orden <0)
                compras.add(c);
            else
                compras.add(orden, c);
        }
        else compras.add(c);

        //almacenamos todos los cambios en el fichero
        guardarCompras(compras);
    }

    /**
     * Almacenamos el nuevo proveedor en el arraylist, ordenado por fechas(de mas nuevo a mas viejo)
     * @param p nuevo proveedor que vamos a almacenar
     * @param proveedores almacen de proveedores ordenados
     */
    public static void proveedorOrdenado(Proveedor p, ArrayList<Proveedor> proveedores)
    {
        if(proveedores.size()>0)
        {
            //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
            int orden = -1;
            int i=0;
            boolean esta=false;
            while (i<proveedores.size() && !esta)
            {
                int masNuevo = proveedores.get(i).getFechaNum();
                if (p.getFechaNum() > masNuevo) //si la fecha es mayor a la que tenemos significa que es mas nueva
                {
                    orden = i;//almacenamos la posicion donde tenemos que meter el nuevo proveedor
                    esta=true;
                }
                else {
                    i++;
                }
            }
            if (orden <0)
                proveedores.add(p);
            else
                proveedores.add(orden, p);
        }
        else proveedores.add(p);

        //almacenamos todos los cambios en el fichero
        guardarProveedores(proveedores);
    }

    /**
     * Almacenamos todos los datos que tenemos sobre proveedores en el arraylist en el fichero correspondiente
     * @param a arraylist de proveedores
     */
    public static void guardarProveedores(ArrayList<Proveedor> a)
    {
        final String FICHERO="proveedores.obj";
        try
        {
            FileOutputStream fs=new FileOutputStream(RUTA+FICHERO, false);
            ObjectOutputStream oos= new ObjectOutputStream(fs);

            for(int i=0; i<a.size(); i++)
            {
                Proveedor objeto=a.get(i);
                oos.writeObject(objeto);
            }

            if(oos!=null)
            {
                oos.close();
                fs.close();
                System.out.println("Fichero cerrado con exito");
            }
            else
                System.out.println("Fichero NO se ha abierto");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Almacenamos todos los datos que tenemos sobre compras en el arraylist en el fichero correspondiente
     * @param a arraylist de compras
     */
    public static void guardarCompras(ArrayList<Compra> a)
    {
        final String FICHERO="compras.obj";
        try
        {
            FileOutputStream fs=new FileOutputStream(RUTA+FICHERO,false);
            ObjectOutputStream oos= new ObjectOutputStream(fs);

            for(int i=0; i<a.size(); i++)
            {
                Compra c=a.get(i);
                oos.writeObject(c);
            }

            if(oos!=null)
            {
                oos.close();
                fs.close();
                System.out.println("Fichero cerrado con exito");
            }
            else
                System.out.println("Fichero NO se ha abierto");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

