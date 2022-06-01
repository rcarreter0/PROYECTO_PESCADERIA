/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosPedido
 */

/**
 * Clase Preparacion
 *
 * Establecemos el estado PREPARACION a el PEDIDO que es cuando el cliente nos realiza el pedido
 * y procedemos a "despacharlo"(preparado)
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public class Preparacion implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, PREPARACION
     */
    private static final Preparacion instance=new Preparacion();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase Preparacion
     */
    public static Preparacion getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private Preparacion(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando hayamos terminado la preparacion del pedido
     * @return clase Preparado
     */
    public EstadoPedido siguiente()
    {
        EstadoPedido e= Preparado.getInstance();
        String cadena=e+"";
        System.out.println("Ahora el estado del pedido es:\n"+cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, Preparacion
     */
    public String toString() {
        return "Preparacion";
    }
}
