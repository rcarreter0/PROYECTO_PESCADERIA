/**
 * Clase Persona
 *
 * Contiene metodos con las variables que solemos pedir de todos los clientes PERSONAS
 * extendido de la clase Cliente
 *
 * @author Raul Carretero
 * @version 1
 */
public class Persona extends Cliente
{
        //CONSTRUCTORES
    /**
     * Constructor con 4 parametros
     * @param nom nombre completo del cliente
     * @param tel telefono de contacto del cliente
     * @param dir direccion donde vive el cliente
     * @param fA fecha de cuando registramos al cliente en el sistema
     */
    public Persona(String nom, int tel,String dir,String fA)
    {
        super(nom, tel, dir, fA);
    }

        //MOSTRAR LOS DATOS DEL CLIENTE
    /**
     * Mostrar todos los datos del cliente
     */
    public void mostrar()
    {
        System.out.println("\n-- INFORMACION DEL CLIENTE -- ");
        System.out.println("Nombre Cliente: "+super.getNombre());
        System.out.println("Telefono Cliente: "+super.getTelefono());
        System.out.println("Direccion Cliente: "+super.getDireccion());
        System.out.println("Fecha de alta cliente: "+super.getFechaAlta());
    }

        //MODIFICAR LOS DATOS DEL CLIENTE
    /**
     * Modificamos los datos que nos pida el usuario
     * El sistema mandara las ordenes necesarias y pedira por teclado los nuevos datos del cliente
     */
    public void cambiarDatos()
    {
        int menu;
        do //ELEGIMOS LOS DATOS DEL CLIENTE QUE QUEREMOS MODIFICAR
        {
            System.out.println("\nQUE DATOS DEL RESTAURANTE QUIERES MODIFICAR:");
            System.out.println("1.Nombre del Cliente");
            System.out.println("2.Telefono del Cliente");
            System.out.println("3.Direccion del Cliente");
            System.out.println("4.Fecha de alta del Cliente");
            System.out.println("0.ATRAS");

            menu = Utils.preguntarInt("Elige una opcion:",0,4);
            System.out.println();

            switch (menu) //CASE DE LOS DATOS DE LOS RESTAURANTES
            {
                case 1:
                    setNombre(Utils.preguntarString("Nombre del Cliente"));
                    break;

                case 2:
                    setTelefono(Utils.preguntarInt("Telefono del Cliente",0,999999999));
                    break;

                case 3:
                    setDireccion(Utils.preguntarString("Direccion del Cliente"));
                    break;
                case 4:
                    setFechaAlta(Utils.preguntarString("Fecha de alta del Cliente"));
                    break;

                case 0:break;

                default:
                    System.out.println("\nOpcion Incorrecta (0 a 5)");
            }
        } while (menu != 0);
    }

}

