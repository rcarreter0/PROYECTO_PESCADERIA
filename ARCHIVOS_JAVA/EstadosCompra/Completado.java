/*
 * Autor: Raul Carretero
 * Nombre: PROYECTO PESCADERIA 1ºDAW
 * Descripción: Archivo del paquete EstadosCompra
 */

/**
 * Clase Completado
 *
 * Establecemos el estado COMPLETADO a la COMPRA que es cuando se haya finalizado todos los procesos previos.
 * Contiene los metodos para las siguientes acciones que necesitaremos en el main
 * Implementando la interfaz EstadoCompra y Serializable
 *
 * @deprecated La compra ha finalizado todos los procesos previos, ya esta terminado por completo
 * @author Raul Carretero
 * @version 1
 */

package EstadosCompra;
import java.io.Serializable;
import java.util.Scanner;

public class Completado implements EstadoCompra, Serializable
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
     * Como es el ultimo estado de la compra en la jerarquia, preguntamos al usuario
     * las opciones que podemos realizar
     * @return cualquier clase que implemente la interfaz EstadoCompra
     */
    public EstadoCompra siguiente()
    {
        EstadoCompra e = Completado.getInstance();
        String cadena = "";
        System.out.println("YA NO HAY MAS ESTADOS DE LA COMPRA");
        System.out.println("1.Modificar el estado de la compra");
        System.out.println("0.Nada, dejarlo como esta");
        int n = preguntarInt("\nQUE DESEA HACER?",0,1);
        if (n == 1) {
            System.out.println("A QUE ESTADO DESEA ACTUALIZAR EL PEDIDO?");
            System.out.println("1.Encargado");
            System.out.println("2.Pendiente de Recoger");
            System.out.println("3.Pendiente de pago");
            System.out.println("0.SALIR");
            int n1 = preguntarInt("Selecciona una accion",0,3);
            switch (n1) {
                case 1:
                    e = Encargado.getInstance();
                    break;
                case 2:
                    e = PendienteRecoger.getInstance();
                    break;
                case 3:
                    e = PendienteRecoger.getInstance();
                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
        }

        cadena += e;
        System.out.println("El estado actual de la compra es " + cadena.toUpperCase());

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
