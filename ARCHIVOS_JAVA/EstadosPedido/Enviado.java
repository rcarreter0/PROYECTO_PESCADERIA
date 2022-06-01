/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosPedido
 */

/**
 * Clase Enviado
 *
 * Establecemos el estado ENVIADO a el PEDIDO que es cuando el pedido es a domicilio y le enviamos la comanda
 * Previamente el cliente nos pide que el pedido se haga a domicilio
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public class Enviado implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, ENVIADO
     */
    private static final Enviado instance=new Enviado();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase Enviado
     */
    public static Enviado getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private Enviado(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando enviamos el pedido a la direccion del General.Cliente/General.Restaurante
     * @return clase PendientePago
     */
    public EstadoPedido siguiente()
    {
        EstadoPedido e= PendientePago.getInstance();
        String cadena=e+"";
        System.out.println("Ahora el estado del pedido es:\n"+cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, Enviado
     */
    public String toString() {
        return "Enviado";
    }
}
