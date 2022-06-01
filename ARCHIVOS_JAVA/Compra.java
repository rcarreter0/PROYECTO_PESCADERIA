/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo de la carpeta fuente
 */

/**
 * Clase Compra
 *
 * Contiene metodos con las variables que solemos pedir de todas las COMPRA que realizamos a los PROVEEDORES
 * implementando la interfaz Serializable
 *
 * @author Raul Carretero
 * @version 1
 */

import EstadosCompra.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Compra implements Serializable
{
        //ATRIBUTOS
    /**
     * General.Proveedor al que realizamos la compra
     */
    Proveedor proveedor;

    /**
     * Detalles que tiene la compra
     */
    ArrayList<DetalleCompra> detalleCompra;

    /**
     * Precio total de la compra
     */
    private float precio = 0;

    /**
     * Fecha de cuando queremos la compra
     */
    private String fecha;

    /**
     * Descripcion de la compra (opcional)
     */
    private String descripcion;

    /**
     * Estado en el que se encuentra la compra
     */
    EstadoCompra estado;

        //CONSTRUCTOR
    /**
     * Constructor con 3 parametros
     * @param proveedor proveedor que al que le hacemos la compra
     * @param fecha fecha en la hemos realizado la compra
     * @param descripcion descripcion de la compra
     */
    public Compra(Proveedor proveedor, String fecha, String descripcion) {
        this.proveedor = proveedor;
        detalleCompra = new ArrayList<DetalleCompra>();
        this.fecha = comprobacion(fecha);
        this.descripcion = descripcion;
        estado = Encargado.getInstance();
    }

    //METODOS
        //GET SET ESTADO DEL PEDIDO
    /**
     * @return estado actual de la compra
     */
    public String getEstado() {
        return estado.toString();
    }

    /**
     * Modificar a un estado de los que tenemos disponibles
     * @param estado nuevo estado de la compra
     */
    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

        //METODOS DEL ESTADO DEL PEDIDO
    /**
     * Cambiamos el estado al siguiente estado que le toque en la jerarquia
     */
    public void cambiaEstado() {
        estado = estado.siguiente();
    }

        //GET SET PROVEEDOR
    /**
     * @return el nombre del proveedor que hayamos realizado la compra
     */
    public String getProveedor() {
        return proveedor.getNomEmp();
    }

    /**
     * Modificar a un proveedor de los que tenemos registrados en el sistema
     * @param proveedor nuevo proveedor
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

        //METODOS DETALLE COMPRA
    /**
     * Almacenamos un nuevo detalle a la compra y actualizamos el precio total de la compra
     * @param origenP origen del pescado
     * @param gen genero encargado
     * @param cant cantidad en kg del genero
     * @param p precio el kg
     */
    public void nuevoDetalle(String origenP, String gen, float cant, float p) {
        detalleCompra.add(new DetalleCompra(origenP, gen, cant, p));
        precio += cant * p;
    }

    /**
     * @return cantidad de detalles que tenemos en la compra, valor numerico
     */
    public int cantidadDetalles() {
        return detalleCompra.size();
    }

        //GET SET PRECIO
    /**
     * @return precio de la compra total
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Modificar o añadir en caso de que el valor este vacio, el precio de la compra
     * @param precio nuevo precio total de la compra
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

        //GET SET FECHA
    /**
     * @return Fecha de cuando queremos la compra en formato texto
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modificar la fecha de cuando queremos la compra o darle una si el dato esta vacio y comprobarla por posible error de formato
     * @param fecha nueva fecha de la compra con un formato estandar (dd/mm/yyyy)
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
        int anyo=Integer.parseInt(fecha.substring(6, fecha.length()));

        int resultado=anyo*10000+mes*100+dia;
        return resultado;
    }

        //GET SET DESCRIPCION
    /**
     * @return descripcion de la compra
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Modificar o añadir en caso de que el valor este vacio, una descripcion de la compra
     * @param descripcion nueva descripcion de la compra
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        //MOSTRAR LOS DATOS
    /**
     * @return toda la descripcion de la compra con todos sus detalles incluidos
     */
    public String toString() {
        String resultado = "-- INFORMACION DE LA COMPRA --" +
                "\nProveedor=" + getProveedor()+
                "\nTelefono de contacto=" + proveedor.getTelEmp()+
                "\nDescripcion=" + descripcion+
                "\nPrecio=" + precio +" euros "+
                "\nFecha=" + fecha +
                "\nEstado=" + estado.toString();

        if(cantidadDetalles()>0) {
            for (int i = 0; i < detalleCompra.size(); i++) {
                resultado += ("\n*** DETALLE " + (i + 1) + " DE LA COMPRA ***");
                resultado += "\n" + detalleCompra.get(i).toString();
            }
        }
        else
            resultado+="\nSIN DETALLES DE COMPRA";

        return resultado;
    }

        //MODIFICAR LOS DATOS DE LA COMPRA Y DE SUS DETALLES
    /**
     * Modificamos los datos que nos pida el usuario
     * El sistema mandara las ordenes necesarias y pedira por teclado los nuevos datos de la compra y de los detalles de la compra
     */
    public void cambiarDatos(ArrayList<Proveedor> proveedores) {
        int menu1, menu2;
        do //ELEGIMOS LOS DATOS DEL PEDIDO QUE QUEREMOS MODIFICAR
        {
            System.out.println("\nQUE DATOS DE LA COMRPA QUIERES MODIFICAR:");
            System.out.println("1.Nombre del Proveedor");
            System.out.println("2.Fecha:");
            System.out.println("3.Precio:");
            System.out.println("4.Descripcion:");
            System.out.println("5.Estado de la Compra:");
            System.out.println("6.NUEVO detalle de la compra");
            System.out.println("7.Detalles del Compra:");
            System.out.println("0.ATRAS");


            menu1 = Utils.preguntarInt("Elige una opcion:", 0, 7);
            System.out.println();

            switch (menu1) //CASE DE LOS DATOS DE LA COMPRA
            {
                case 1:
                    System.out.println("Nombre Provedor");
                    //tenemos que seleccionar a proovedores ya almacenados
                    System.out.print("Por que Proveedor lo quieres cambiar");
                    for (int i = 0; i < proveedores.size(); i++)
                        System.out.println(i + " -> " + proveedores.get(i).getNomEmp() + " // " + proveedores.get(i).getFecha());

                    int n1 = Utils.preguntarInt("Por favor indica el numero del proveedor", 0, proveedores.size()-1);
                    setProveedor(proveedores.get(n1));
                    break;

                case 2:
                    setFecha(Utils.preguntarString("Fecha (dd/mm/yyyy)"));
                    break;

                case 3:
                    setPrecio((float) Utils.preguntarDouble("Precio Total", 0, 500));
                    break;

                case 4:
                    setDescripcion(Utils.preguntarString("Descripcion"));
                    break;

                case 5:
                    System.out.println("Estado de la compra");
                    cambiaEstado();
                    break;

                case 6:
                    System.out.println("Nuevo detalle de la compra");
                    String genero= Utils.preguntarString("Genero");

                    String origen= Utils.preguntarString("Origen del genero");

                    float cantidad=(float) Utils.preguntarDouble("Cantidad (Kg)",0,500);

                    float pr=(float) Utils.preguntarDouble("Precio el Kilo",0,500);

                    char respuesta1= Utils.preguntarString("¿Quieres almacenar el detalle nuevo?(S/N)").charAt(0);
                    if(respuesta1=='S' || respuesta1=='s' )
                        nuevoDetalle(origen, genero, cantidad, pr);
                    else System.out.println("No se ha almacenado el nuevo detalle de la compra");

                    break;

                case 7:
                    System.out.println("Detalles del pedido");

                    if (cantidadDetalles() > 0)
                    {
                        //SELECCIONAMOS UN DETALLE DE LOS QUE TENEMOS ALMACENADOS
                        System.out.println("DETALLES ALMACENADOS EN EL PEDIDO");
                        for (int i = 0; i < cantidadDetalles(); i++) {
                            System.out.println("Detalle " + i+" -> "+detalleCompra.get(i).getGenero()+" // "+detalleCompra.get(i).getOrigenPescado() +" // "+detalleCompra.get(i).getPrecio());
                        }

                        int n2 = Utils.preguntarInt("", 0, cantidadDetalles()-1);
                        System.out.println(detalleCompra.get(n2).toString());

                        do //ELEGIMOS EL DATO DEL DETALLE QUE QUEREMOS MODIFICAR
                        {
                            System.out.println("\nQUE DETALLE QUIERES MODIFICAR");
                            System.out.println("1.Origen del Pescado");
                            System.out.println("2.Genero");
                            System.out.println("3.Cantidad");
                            System.out.println("4.Precio");
                            System.out.println("5.ELIMINAR DETALLE");
                            System.out.println("0.ATRAS");
                            menu2 = Utils.preguntarInt("Elige el detalle a modificar", 0, 5);
                            switch (menu2)  //CASE DE LOS DETALLES DEL PEDIDO QUE QUEREMOS MODIFICAR
                            {
                                case 1:
                                    detalleCompra.get(n2).setOrigenPescado(Utils.preguntarString("Nuevo Origen del Pescado"));
                                    break;

                                case 2:
                                    detalleCompra.get(n2).setGenero(Utils.preguntarString("Nuevo genero"));
                                    break;

                                case 3:
                                    //quitamos el precio del detalle del total de la compra
                                    float resultado1 = getPrecio() - (detalleCompra.get(n2).getCantidad() * detalleCompra.get(n2).getPrecio());

                                    //actualizamos la cantidad en kilos
                                    detalleCompra.get(n2).setCantidad((float) Utils.preguntarInt("Nueva cantidad", 0, 500));

                                    //actualizamos el valor del detalle y lo sumamos al total de la compra
                                    resultado1 += detalleCompra.get(n2).getCantidad() * detalleCompra.get(n2).getPrecio();

                                    setPrecio(resultado1);
                                    break;

                                case 4:

                                    //quitamos el precio del detalle del total de la compra
                                    float resultado2 = getPrecio() - (detalleCompra.get(n2).getCantidad() * detalleCompra.get(n2).getPrecio());

                                    //actualizamos el precio por kilo
                                    detalleCompra.get(n2).setPrecio((float) Utils.preguntarInt("Nuevo precio", 0, 500));

                                    //actualizamos el valor del detalle y lo sumamos al total de la compra
                                    resultado2 += detalleCompra.get(n2).getCantidad() * detalleCompra.get(n2).getPrecio();

                                    setPrecio(resultado2);
                                    break;

                                case 5:
                                    detalleCompra.get(n2).toString();
                                    char rto= Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                    if(rto=='S' || rto=='s' )
                                    {
                                        //Le quitamos el precio del detalle al total de la compra
                                        float dinero = getPrecio() - (detalleCompra.get(n2).getCantidad() * detalleCompra.get(n2).getPrecio());

                                        //Actualizamos el precio de la compra sin el detalle que vamos a eliminar
                                        setPrecio(dinero);

                                        detalleCompra.remove(n2);
                                        System.out.println("¡¡¡ DETALLE DE LA COMPRA ELIMINADO !!!");
                                    } //PROVEEDOR ELIMINADO
                                    else
                                        System.out.println("No se ha eliminado el detalle de la compra seleccionado");
                                    menu2=0;
                                    break;

                                case 0:break;

                                    default:
                                        System.out.println("\nOpcion Incorrecta (0 a 5)");
                            }

                        }while (menu2 != 0) ;
                        break;
                    }
                    else System.out.println("Esta compra no tiene detalles");
                case 0:break;

                default:
                    System.out.println("\nOpcion Incorrecta (0 a 7)");
            }
        }while (menu1 != 0) ;
    }
}
