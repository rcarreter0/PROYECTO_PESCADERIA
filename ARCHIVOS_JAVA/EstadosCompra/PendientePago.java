/**
 * Clase PendientePago
 *
 * Establecemos el estado PENDIENTE DE PAGAR a la COMPRA, que es cuando ya hemos recogido la
 * compra y queda pagar el importe total (el momento del pago depende de que procedimientos haga el proveedor)
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoCompra y Serializable
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosCompra;
import java.io.Serializable;

public class PendientePago implements EstadoCompra, Serializable
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
     * Cambiamos al siguiente estado de la jerarquia, cuando ya hemos pagado el importe de la compra
     * @return la clase Completado
     */
    public EstadoCompra siguiente()
    {
        EstadoCompra e=Completado.getInstance();
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
