/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosPedido
 */

/**
 * Clase Completado
 *
 * Establecemos el estado COMPLETADO a el PEDIDO que es cuando se haya finalizado todos los procesos previos.
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoPedido
 *
 * @author Raul Carretero
 * @version 1
 */

package EstadosPedido;
import java.util.Scanner;
public class Completado implements EstadoPedido
{
    /**
     * Devolver una instancia de la clase actual, COMPLETADO
     */
    private static final Completado instance=new Completado();

    /**
     * @return la instancia que hemos declarado anteriormente, la clase Completado
     */
    public static Completado getInstance()
    {
        return instance;
    }

    /**
     * Constructor sin parametros
     */
    private Completado(){}

    /**
     * Como es el ultimo estado del pedido en la jerarquia, preguntamos al usuario
     * las opciones que podemos realizar
     * @return cualquier clase que implemente la interfaz EstadoPedido
     */
    public EstadoPedido siguiente()
    {
        EstadoPedido e = Completado.getInstance();
        String cadena = "";
        System.out.println("YA NO HAY MAS ESTADOS DEL PEDIDO");
        System.out.println("1.Modificar el estado del pedido");
        System.out.println("0.Nada, dejarlo como esta");
        int n = preguntarInt("QUE DESEA HACER?", 0,1);
        if (n == 1)
        {
            System.out.println("A QUE ESTADO DESEA ACTUALIZAR EL PEDIDO?");
            System.out.println("1.Preparacion");
            System.out.println("2.Preparado");
            System.out.println("3.Enviado");
            System.out.println("4.Recogida Pendiente");
            System.out.println("5.Pendiente de Pago");
            System.out.println("0.SALIR");
            int n1 = preguntarInt("Selecciona una accion",0,5);
            switch (n1) {
                case 1:
                    e = Preparacion.getInstance();
                    break;
                case 2:
                    e = Preparado.getInstance();
                    break;
                case 3:
                    e = Enviado.getInstance();
                    break;
                case 4:
                    e = RecogidaPendiente.getInstance();
                    break;
                case 5:
                    e = PendientePago.getInstance();
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
        }

        cadena += e;
        System.out.println("El estado actual del pedido es " + cadena.toUpperCase());

        return e;
    }

    /**
     * @return El nombre en formato texto de la clase en la que nos ubicamos actualmente, Completado
     */
    public String toString() {
        return "Completado";
    }

    /**
     * Muestra un texto y espera un numero entre min y max por el teclado
     * @return numero introducido
     */
    public static int preguntarInt(String pregunta, int min, int max) {
        boolean repetir = true;
        int resultado = -1;
        do {
            String valor = preguntarString(pregunta);
            try {
                resultado = Integer.parseInt(valor);
                repetir = (resultado < min) || (resultado > max);
                if (repetir) {
                    System.out.println("Error: "+resultado+" fuera de rango");
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: "+valor+" no es un numero Valido");
            }
        } while (repetir);

        return resultado;
    }

    /**
     * Muestra un texto y espera una entrada del teclado
     * @return Valor introducido por teclado
     */
    public static String preguntarString(String pregunta) {
        System.out.print(pregunta+"\n ");
        Scanner entrada = new Scanner(System.in);

        return entrada.nextLine();
    }
}

