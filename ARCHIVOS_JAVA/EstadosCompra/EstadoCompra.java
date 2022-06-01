/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosCompra
 */

/**
 * Interfaz EstadoCompra
 *
 * Aqui establecemos los metodos que van a tener todas las clases que implementen esta interfaz,
 * las cuales seran estados de la COMPRA que hacemos a los PROVEEDORES
 *
 * @author Raul Carretero
 * @version 1
 */
package EstadosCompra;

public interface EstadoCompra
{
    /**
     * Cambiaremos el estado actual al siguiente estado que seleccionemos
     * @return nuevo estado, el siguiente en la jerarquia
     */
    public EstadoCompra siguiente();

    /**
     * @return cadena de texto donde mostramos el estado en el que esta actualmente la
     * compra en formato texto
     */
    public String toString();
}
