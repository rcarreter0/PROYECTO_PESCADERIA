/**
 * Interfaz EstadoPedido
 *
 * Aqui establecemos los metodos que van a tener todas las clases que implementen esta interfaz,
 * las cuales seran estados del PEDIDO que nos hacen los CLIENTES
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;

public interface EstadoPedido
{
    /**
     * Cambiaremos el estado actual al siguiente estado que seleccionemos
     * @return nuevo estado, el siguiente en la jerarquia
     */
    public EstadoPedido siguiente();

    /**
     * @return cadena de texto donde mostramos el estado en el que esta actualmente el
     * pedido en formato texto
     */
    public String toString();
}
