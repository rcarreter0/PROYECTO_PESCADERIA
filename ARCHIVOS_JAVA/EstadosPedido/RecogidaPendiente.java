/**
 * Clase RecogidaPendiente
 *
 * Establecemos el estado RECOGIDAPENDIENTE a el PEDIDO que es cuando el pedido es local y
 * esperamos la llegada del cliente a la "parada"(puesto de la pescaderia)
 * Previamente el cliente nos pide que el pedido se recoge en el local
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public class RecogidaPendiente implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, RECOGIDAPENDIENTE
     */
    private static final RecogidaPendiente instance=new RecogidaPendiente();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase RecogidaPendiente
     */
    public static RecogidaPendiente getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private RecogidaPendiente(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando el General.Cliente/General.Restaurante ha recogido
     * el pedido en el local
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
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, RecogidaPendiente
     */
    public String toString() {
        return "RecogidaPendiente";
    }
}
