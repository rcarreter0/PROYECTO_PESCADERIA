/**
 * Clase PendienteRecoger
 *
 * Establecemos el estado PENDIENTE DE RECOGER a la COMPRA, que es cuando la compra ya esta preparada
 * y solo queda recogerla al proveedor
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoCompra y Serializable
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosCompra;
import java.io.Serializable;

public class PendienteRecoger implements EstadoCompra, Serializable
{
    /**
     * Devolver una instancia de la clase actual, PENDIENTERECOGER
     */
    private static final PendienteRecoger instance=new PendienteRecoger();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase PendienteRecoger
     */
    public static PendienteRecoger getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private PendienteRecoger(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando hemos recogido la compra
     * @return la clase PendientePago
     */
    public EstadoCompra siguiente()
    {
        EstadoCompra e=PendientePago.getInstance();
        String cadena=e+"";
        System.out.println("Ahora el estado del pedido es:\n"+cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, PendienteRecoger
     */
    public String toString() {
        return "PendienteRecoger";
    }
}
