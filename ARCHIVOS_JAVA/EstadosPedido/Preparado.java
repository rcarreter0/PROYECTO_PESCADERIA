/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosPedido
 */

/**
 * Clase Preparado
 *
 * Establecemos el estado PREPARADO a el PEDIDO que es cuando el pedido esta terminado y el cliente nos indica
 * si viene a recogerlo o se lo enviamos a domicilio
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public class Preparado implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, PREPARADO
     */
    private static final Preparado instance=new Preparado();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase Preparado
     */
    public static Preparado getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private Preparado(){}

    /**
     * Cambiamos al siguiente estado de la jerarquia, cuando el cliente nos deja claro el tipo de recogida del pedido
     * @return clase Enviado(domicilio) o RecogidaPendiente(local)
     */
    public EstadoPedido siguiente()
    {
        EstadoPedido e =Preparado.getInstance();
        int r;
        String cadena="";

           System.out.println("A Domicilio(0) o Recogida en General.Pescaderia(1)");
           r=Completado.preguntarInt("\nSeleccione un numero (0 // 1)", 0,1);
           switch (r) {
               case 0:
                   e = Enviado.getInstance();
                   cadena += e;
                   System.out.println("Ahora el estado del pedido es:\n" + cadena.toUpperCase());
                   break;
               case 1:
                   e = RecogidaPendiente.getInstance();
                   cadena += e;
                   System.out.println("Ahora el estado del pedido es:\n" + cadena.toUpperCase());
                   break;
               default:
                   System.out.println("Por favor seleccionar la opcion correcta (0 // 1)");
           }

       return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, Preparado
     */
    public String toString() {
        return "Preparado";
    }
}
