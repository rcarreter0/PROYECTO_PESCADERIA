/**
 * Clase PendientePago
 *
 * Establecemos el estado PENDIENTEPAGO a el PEDIDO que es cuando el cliente recibe el pedido(domicilio o local)
 * y falta recibir el pago del importe total del pedido(la situacion puede depender del cliente)
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public class PendientePago implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, PENDIENTEPAGO
     */
    private static final PendientePago instance=new PendientePago();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase PendientePago
     */
    public static PendientePago getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private PendientePago(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando el General.Cliente/General.Restaurante nos ha pagado
     * el importe total del pedido
     * @return clase Completado
     */
    public EstadoPedido siguiente()
    {
        EstadoPedido e= Completado.getInstance();
        String cadena=e+"";
        System.out.println("Ahora el estado del pedido es:\n"+cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, PendientePago
     */
    public String toString() {
        return "PendientePago";
    }
}
