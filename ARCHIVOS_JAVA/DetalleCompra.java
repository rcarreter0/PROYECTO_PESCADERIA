/**
 * Clase DetalleCompra
 *
 * Contiene metodos con las variables que solemos pedir de todos los DEATLLES DE LA COMPRA que realizamos a los PROVEEDORES
 * implementando la interfaz Serializable
 *
 * @author Raul Carretero
 * @version 1
 */
import java.io.Serializable;
public class DetalleCompra implements Serializable
{
        //ATRIBUTOS
    /**
     * origen de procedencia del genero
     */
    private String origenPescado;

    /**
     * genero(pescado) encargado
     */
    private String genero;

    /**
     * cantidad en kg del genero encargado
     */
    private float cantidad;

    /**
     * precio el kg del genero
     */
    private float precio;

        //COINSTRUCTOR
    /**
     * Constructor con 4 parametros
     * @param op origen de procedencia del genero
     * @param g genero(pescado) encargado
     * @param c cantidad en kg del genero encargado
     * @param p precio el kg del genero
     */
    public DetalleCompra(String op, String g, float c, float p)
    {
        origenPescado=op;
        genero=g;
        cantidad=c;
        precio=p;
    }

        //GET SET ORIGEN PESCADO
    /**
     * @return origen del pescado
     */
    public String getOrigenPescado() {
        return origenPescado;
    }

    /**
     * Modificar el origen del pescado o darle uno si el dato esta vacio
     * @param origenPescado
     */
    public void setOrigenPescado(String origenPescado) {
        this.origenPescado = origenPescado;
    }

        //GET SET GENERO

    /**
     * @return nombre del genero encargado
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Modificar el genero encargado o darle uno si el dato esta vacio
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

        //GET SET CANTIDAD DEL GENERO EN KG

    /**
     * @return cantidad den kg del genero encargado
     */
    public float getCantidad() {
        return cantidad;
    }
    /**
     * Modificar cantidad en kg del genero o darle uno si el dato esta vacio
     * @param cantidad
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

        //GET SET PRECIO DEL GENERO

    /**
     * @return precio que cuesta el kg del genero
     */
    public float getPrecio() {
        return precio;
    }
    /**
     * Modificar el precio que cuesta el kg del genero o darle uno si el dato esta vacio
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

        //MOSTRAMOS LOS DATOS DEL DETALLE DE LA COMPRA
    /**
     * Mostrar todos los datos del detalle de la compra
     */
    public String toString() {
        return  "OrigenPescado=" + origenPescado +
                "\nGenero=" + genero +
                "\nPrecio=" + precio +
                "\nCantidad=" + cantidad;
    }
}
