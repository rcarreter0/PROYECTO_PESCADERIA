/**
 * Clase Restaurante
 *
 * Contiene metodos con las variables que solemos pedir de todos los clientes RESTAURANTES
 * extendido de la clase Cliente
 *
 * @author Raul Carretero
 * @version 1
 */
public class Restaurante extends Cliente
{
        //ATRIBUTOS
    /**
     * Nombre del restaurante
     */
    private String nombreRestaurante;

    /**
     * Telefono del local restaurante
     */
    private int telefonoRestaurante;

    //CONSTRUCTOR
    /**
     * Constructor con 6 parametros
     * @param nom nombre completo del jefe del restaurante o del que nos hace los encargos
     * @param tel telefono de contacto del cliente jefe o encargado
     * @param dir direccion donde se ubica el restaurante
     * @param fA fecha de cuando registramos el restaurante en el sistema
     * @param nr nombre del restaurante
     * @param tr telefono del local restaurante
     */
    public Restaurante(String nom, int tel,String dir, String fA, String nr, int tr)
    {
        super(nom, tel, dir, fA);
        nombreRestaurante=nr;
        telefonoRestaurante=tr;
    }

    //METODOS
        //GET SET NOMBRE RESTAURANTE
    /**
     * Modificar el nombre del restaurante o darle uno si el dato esta vacio
     * @param n nuevo nombre del restaurante
     */
    public void setNomRest(String n)
    {
        nombreRestaurante=n;
    }

    /**
     * @return nombre del restaurante
     */
    public String getNomRest()
    {
        return nombreRestaurante;
    }

        //GET SET TELEFONO RESTAURANTE
    /**
     * Modificar el telefono del local restaurante o darle uno si el dato esta vacio
     * @param t telefono del restaurante
     */
    public void setTelRest(int t)
    {
        telefonoRestaurante=t;
    }

    /**
     * @return telefono del local restaurante
     */
    public int getTelRest()
    {
        return telefonoRestaurante;
    }

        //MOSTRAR LOS DATOS
    /**
     * Mostrar todos los datos del restaurante
     */
    public void mostrar()
    {
        System.out.println("\n-- INFORMACION DEL RESTAURANTE --: ");
        System.out.println("Nombre Jefe: "+super.getNombre());
        System.out.println("Telefono contacto: "+super.getTelefono());
        System.out.println("Direccion Restaurante: "+super.getDireccion());
        System.out.println("Nombre Restaurante: "+getNomRest());
        System.out.println("Telefono Local Restaurante: "+getTelRest());
        System.out.println("Fecha de alta Restaurante: "+super.getFechaAlta());
    }

        //MODIFICAR LOS DATOS DEL RESTAURANTE
    /**
     * Modificamos los datos que nos pida el usuario
     * El sistema mandara las ordenes necesarias y pedira por teclado los nuevos datos del restaurante
     */
    public void cambiarDatos()
    {
        int menu;
        do //ELEGIMOS LOS DATOS DEL RESTAURANTE QUE QUEREMOS MODIFICAR
        {
            System.out.println("\nQUE DATOS DEL RESTAURANTE QUIERES MODIFICAR:");
            System.out.println("1.Nombre del Jefe");
            System.out.println("2.Telefono del Jefe");
            System.out.println("3.Nombre del Restaurante");
            System.out.println("4.Telefono del Restaurante");
            System.out.println("5.Direccion del Restaurante");
            System.out.println("6.Fecha de alta del Restaurante");
            System.out.println("0.ATRAS");

            menu = Utils.preguntarInt("Elige una opcion:",0,6);

            switch (menu) //CASE DE LOS DATOS DE LOS RESTAURANTES
            {
                case 1:
                    super.setNombre(Utils.preguntarString("Nombre del Jefe"));
                    break;

                case 2:
                    super.setTelefono(Utils.preguntarInt("Telefono del Jefe",0,999999999));
                    break;

                case 3:
                    setNomRest(Utils.preguntarString("Nombre del Restaurante"));
                    break;

                case 4:
                    setTelRest(Utils.preguntarInt("Telefono del Restaurante",0,999999999));
                    break;

                case 5:
                    setDireccion(Utils.preguntarString("Direccion del Restaurante"));
                    break;

                case 6:
                    setFechaAlta(Utils.preguntarString("Fecha de alta del Restaurante(dd/mm/yyyy)"));
                    break;

                case 0:break;

                default:
                    System.out.println("\nOpcion Incorrecta (0 a 5)");
            }
        } while (menu != 0);
    }
}
