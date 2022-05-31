/**
 * Clase Pedido
 *
 * Contiene metodos con las variables que solemos pedir de todos los PEDIDOS que nos realizan los clientes
 * implementando la interfaz Serializable
 *
 * @author Raul Carretero
 * @version 1
 */
import EstadosPedido.*;
import java.util.ArrayList;

public class Pedido
{
        //ATRIBUTOS
    /**
     * Cliente que nos ha realizado el pedido
     */
    Cliente cliente;

    /**
     * Detalles del pedido
     */
    ArrayList<DetallePedido> detallePedido;

    /**
     * Descripcion del pedido
     */
    private String descripcion;

    /**
     * Fecha de cuando quiere el cliente el pedido
     */
    private String fecha;

    /**
     * Precio total del pedido
     */
    private float precio=0;

    /**
     * Estado del pedido
     */
    EstadoPedido estado;

         //CONSTRUCTOR
    /**
     * Constructor con 3 parametros
     * @param c cliente que realiza el pedido
     * @param des descripcion del pedido
     * @param f fecha de cuando quiere el cliente el pedido
     */
    public Pedido(Cliente c,String des, String f)
    {
        cliente=c;
        detallePedido=new ArrayList<DetallePedido>();
        descripcion=des;
        fecha=comprobacion(f);
        estado= (EstadoPedido) Preparacion.getInstance();
    }

    //METODOS
        //GET SET ESTADOS DEL PEDIDO
    /**
     * @return estado actual del pedido
     */
    public String getEstado()
    {
        return estado.toString();
    }

    /**
     * Modificar el estado por uno de los que tengamos disponibles
     * @param estado nuevoe estado del pedido
     */
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
        //METODOS DEL ESTADO DEL PEDIDO

    /**
     * Cambiamos el estado del pedido al siguiente estado que toque en la jerarquia y dependiendo del pedido
     */
    public void cambiaEstado()
    {
        estado=estado.siguiente();
    }

        //METODOS DETALLE PEDIDO
    /**
     * Almnacenamos un nuevo detalle al pedido y actualizamos el precio total del pedido
     * @param op origen del pescado
     * @param gh genero pedido
     * @param c cantidad en kg del genero
     * @param p precio el kg
     */
    public void nuevoDetalle(String op, String gh,float c,float p)
    {
        detallePedido.add( new DetallePedido(op,  gh, c, p));
        precio+=c*p;
    }

    /**
     * @return cantidad de detalles que tiene el pedido, en valor numerico
     */
    public int cantidadDetalles()
    {
        return detallePedido.size();
    }

        //GET SET DESCRIPCION
    /**
     * @return descripcion del pedido
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modificar o añadir en caso de que el valor este vacio, una descripcion del pedido
     * @param descripcion nueva descripcion del pedido
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        //GET SET CLIENTE
    /**
     * @return cliente que nos ha realizado el pedido
     */
    public String getCliente() {

        return cliente.getNombre();
    }

    /**
     * Modificar el cliente por uno de los que tengamos registrados en el sistema
     * @param cliente otro cliente que tenemos registrados
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

        //GET SET PRECIO
    /**
     * @return precio total del pedido
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Modificar el precio total del pedido o darle un valor en caso de que este vacio
     * @param precio precio total del pedido
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

        //GET SET FECHA
    /**
     * @return fecha de cuando quiere el cliente el el pedido en tipo texto
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modificar la fecha de cuando quiere el cliente el pedido o darle una si el dato esta vacio y comprobarla por posible error de formato
     * @param fecha fecha alta nueva con un formato estandar (dd/mm/yyyy)
     */
    public void setFecha(String fecha) {

       this.fecha=comprobacion(fecha);
    }

        //METODOS FECHA
    /**
     * @param f fecha en cualquier formado posible de d/m/yy
     * @return fecha tipo texto y con el formato dd/mm/yyyy
     */
    private String comprobacion(String f)
    {
        String numero="", resultado="";
        String dia="", mes="", anyo="";

        for(int i=0;i<f.length(); i++)
        {
            if(f.charAt(i)=='/')
            {
                if(dia.length()==0)
                {
                    dia=numero;
                    numero="";
                }
                else if(mes.length()==0)
                {
                    mes=numero;
                    numero="";
                }
            }
            else numero+=f.charAt(i);
        }
        anyo=numero;

        if(dia.length()<2)
            dia="0"+dia;
        if(mes.length()<2)
            mes="0"+mes;
        if(anyo.length()<4)
            anyo="20"+anyo;

        resultado=dia+"/"+mes+"/"+anyo;
        return resultado;
    }

    /**
     * De tener la fecha en tipo texto dd/mm/yyyy , cambiarla a valor numerico
     * @return fecha en formato entero (yyyymmdd)
     */
    public int getFechaNum()
    {
        int dia=Integer.parseInt(fecha.substring(0, 2));
        int mes=Integer.parseInt(fecha.substring(3, 5));
        int anyo=Integer.parseInt(fecha.substring(6, fecha.length() ));

        int resultado=anyo*10000+mes*100+dia;
        return resultado;
    }

        //MOSTRAR LOS DATOS
    /**
     * @return toda la descripcion del pedido con todos sus detalles incluidos
     */
    public String toString()
    {
        String resultado= "-- INFORMACION DEL PEDIDO --";
        if(cliente instanceof Restaurante)
            resultado += "\nRestaurante=" + getCliente();
        else
            resultado += "\nCliente=" + getCliente();


        resultado+= "\nTelefono de contacto=" + cliente.getTelefono()+
                "\nDescripcion=" + descripcion +
                "\nFecha=" + fecha +
                "\nPrecio Total=" + precio +" euros "+
                "\nEstado=" + estado.toString();

        if(cantidadDetalles()>0)
        {
            for (int i = 0; i < cantidadDetalles(); i++)
            {
                resultado += ("\n*** DETALLE " + (i + 1) + " DEL PEDIDO ***");
                resultado += "\n" + detallePedido.get(i).toString();
            }
        }
        else resultado+="\nSIN DETALLES DE PEDIDO";

        return resultado;
    }

        //MODIFICAR LOS DATOS DEL PEDIDO Y DE SUS DETALLES
    /**
     * Modificamos los datos que nos pida el usuario
     * El sistema mandara las ordenes necesarias y pedira por teclado los nuevos datos del pedido y de los detalles del pedido
     */
    public void cambiarDatos(ArrayList<Cliente> clientes)
    {
        int menu1, menu2;

        do //ELEGIMOS LOS DATOS DEL PEDIDO QUE QUEREMOS MODIFICAR
        {

            System.out.println("\nQUE DATOS DEL PEDIDO QUIERES MODIFICAR:");
            System.out.println("1.Nombre del Cliente/Restaurante");
            System.out.println("2.Fecha:");
            System.out.println("3.Precio:");
            System.out.println("4.Descripcion:");
            System.out.println("5.Estado del pedido:");
            System.out.println("6.NUEVO detalle del pedido");
            System.out.println("7.Detalles del Pedido:");
            System.out.println("0.ATRAS");


            menu1 = Utils.preguntarInt("Elige una opcion:",0,7);
            System.out.println();

            switch(menu1) //CASE DE LOS DATOS DEL PEDIDO
            {
                case 1:
                    System.out.println("Nombre del Cliente/Restaurante");

                    //tenemos que seleccionar a clientes ya almacenados
                    System.out.println("Por que Cliente/Restaurante lo quieres cambiar");
                    for(int i=0; i<clientes.size(); i++)
                        if(clientes.get(i)instanceof Restaurante)
                            System.out.println("RESTAURANTE "+i+" -> "+((Restaurante)clientes.get(i)).getNomRest());
                        else
                            System.out.println("CLIENTE "+i+" -> "+clientes.get(i).getNombre());

                    int n1= Utils.preguntarInt("Por favor indica el numero del cliente:",0,clientes.size()-1);
                    setCliente(clientes.get(n1));
                    break;

                case 2:
                    setFecha(Utils.preguntarString("Fecha (dd/mm/yyyy)"));
                    break;

                case 3:
                    System.out.println("Precio Total");
                    setPrecio((float) Utils.preguntarDouble("Precio Total",0,500));
                    break;

                case 4:
                    setDescripcion(Utils.preguntarString("Descrripcion"));
                    break;

                case 5:
                    System.out.println("Estado del pedido");
                    cambiaEstado();
                    break;

                case 6:
                    System.out.println("Nuevo detalle del pedido");
                    String genero= Utils.preguntarString("Genero");

                    String origen= Utils.preguntarString("Origen del genero");

                    float cantidad=(float) Utils.preguntarDouble("Cantidad (Kg)d", 0, 500);

                    float pr=(float) Utils.preguntarDouble("Precio el Kilo", 0, 500);

                    char respuesta1= Utils.preguntarString("¿Quieres almacenar el detalle nuevo?(S/N)").charAt(0);
                    if(respuesta1=='S' || respuesta1=='s' )
                        nuevoDetalle(origen, genero, cantidad, pr);
                    else System.out.println("No se ha almacenado el nuevo detalle del pedido");

                    break;


                case 7:
                    System.out.println("Detalles del pedido");

                    if(cantidadDetalles()>0)
                    {
                        //SELECCIONAMOS UN DETALLE DE LOS QUE TENEMOS ALMACENADOS
                        System.out.println("DETALLES ALMACENADOS EN EL PEDIDO");
                        for(int i=0; i<cantidadDetalles(); i++)
                        {
                            System.out.println("Detalle "+i+" -> "+detallePedido.get(i).getGenero() +" // "+detallePedido.get(i).getOrigenPescado()+" // "+detallePedido.get(i).getPrecio());
                        }

                        int n2= Utils.preguntarInt("Elige el detalle que quieres modificar (numDetalle)", 0, cantidadDetalles()-1);
                        System.out.println(detallePedido.get(n2).toString());

                        do //ELEGIMOS EL DATO DEL DETALLE QUE QUEREMOS MODIFICAR
                        {
                            System.out.println("\nQUE DETALLE QUIERES MODIFICAR");
                            System.out.println("1.Origen del Pescado");
                            System.out.println("2.Genero");
                            System.out.println("3.Cantidad");
                            System.out.println("4.Precio");
                            System.out.println("5.ELIMINAR DETALLE");
                            System.out.println("0.ATRAS");
                            menu2= Utils.preguntarInt("Elige el detalle a modificar", 0,5);

                            switch (menu2)  //CASE DE LOS DETALLES DEL PEDIDO QUE QUEREMOS MODIFICAR
                            {

                                case 1:
                                    detallePedido.get(n2).setOrigenPescado(Utils.preguntarString("Nuevo Origen del Pescado"));
                                    break;

                                case 2:
                                    detallePedido.get(n2).setGenero(Utils.preguntarString("Nuevo genero"));
                                    break;

                                case 3:
                                    //quitamos el precio del detalle del total del pedido
                                    float resultado1=getPrecio()-(detallePedido.get(n2).getCantidad()*detallePedido.get(n2).getPrecio());

                                    //actualizamos la cantidad en kilos
                                    detallePedido.get(n2).setCantidad((float) Utils.preguntarInt("Nueva cantidad", 0, 500));

                                    //actualizamos el valor del detalle y lo sumamos al total del pedido
                                    resultado1+=detallePedido.get(n2).getCantidad()*detallePedido.get(n2).getPrecio();

                                    setPrecio(resultado1);
                                    break;

                                case 4:

                                    //quitamos el precio del detalle del total del pedido
                                    float resultado2=getPrecio()-(detallePedido.get(n2).getCantidad()*detallePedido.get(n2).getPrecio());

                                    //actualizamos el precio por kilo
                                    detallePedido.get(n2).setPrecio((float) Utils.preguntarInt("Nuevo precio", 0, 500));

                                    //actualizamos el valor del detalle y lo sumamos al total del pedido
                                    resultado2+=detallePedido.get(n2).getCantidad()*detallePedido.get(n2).getPrecio();

                                    setPrecio(resultado2);
                                    break;

                                case 5:
                                    detallePedido.get(n2).toString();
                                    char rto= Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                    if(rto=='S' || rto=='s' )
                                    {
                                        //Le quitamos el precio del detalle al total de la compra
                                        float dinero = getPrecio() - (detallePedido.get(n2).getCantidad() * detallePedido.get(n2).getPrecio());

                                        //Actualizamos el precio de la compra sin el detalle que vamos a eliminar
                                        setPrecio(dinero);

                                        detallePedido.remove(n2);
                                        System.out.println("¡¡¡ DETALLE DEL PEDIDO ELIMINADO !!!");
                                    } //PROVEEDOR ELIMINADO
                                    else
                                        System.out.println("No se ha eliminado el detalle del pedido seleccionado");

                                    menu2=0;
                                    break;
                                case 0:break;

                                default:
                                    System.out.println("\nOpcion Incorrecta (0 a 5)");
                            }
                        }while(menu2!=0);
                    }
                    else System.out.println("Lo sentimos pero este pedido no tiene detalles");

                    break;

                case 0:break;

                default: System.out.println("\nOpcion Incorrecta (0 a 5)");
            }
        }while(menu1!=0);
    }
}
