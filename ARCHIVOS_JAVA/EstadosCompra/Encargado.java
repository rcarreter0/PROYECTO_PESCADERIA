/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosCompra
 */

/**
 * Clase Encargado
 *
 * Establecemos el estado ENCARGADO a la COMPRA, que es cuando hemos encargado la compra al proveedor
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoCompra y Serializable
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosCompra;
import java.io.Serializable;

public class Encargado implements EstadoCompra, Serializable
{
    /**
     * Devolver una instancia de la clase actual, ENCARGADO
     */
    private static final Encargado instance=new Encargado();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase Encargado
     */
    public static Encargado getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private Encargado(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando hayamos encargado la compra
     * y este preparada de recoger
     * @return clase PendienteRecoger
     */
    public EstadoCompra siguiente()
    {
        EstadoCompra e=PendienteRecoger.getInstance();
        String cadena=e+"";
        System.out.println("Ahora el estado del pedido es:\n"+cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, Encargado
     */
    public String toString() {
        return "Encargado";
    }
}
