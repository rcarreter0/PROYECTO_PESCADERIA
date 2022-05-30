/**
 * Clase Proveedor
 *
 * Contiene metodos con las variables que solemos pedir de todos los PROVEEDORES
 * implementando la interfaz Serializable
 *
 * @author Raul Carretero
 * @version 1
 */

import java.io.Serializable;
public class Proveedor implements Serializable
{
        //ATRIBUTOS
    /**
     * Nombre de la empresa proveedora
     */
    private String nombreEmpresa;

    /**
     * Telefono de contacto al que hacer los encargos
     */
    private int telefonoEmpresa;

    /**
     * Nombre del jefe o a quien hacemos los encargos
     */
    private String nombreJefe;

    /**
     * Ubicacion del local donde esta el proveedor
     */
    private String direccion="MercaValencia Puesto ";

    /**
     * Fecha de cuando registramos al proveedor en el sistema
     */
    private String fechaAlta;


    //CONSTRUCTOR
    /**
     * Constructor con 5 parametros
     * @param nomE Nombre de la empresa proveedora
     * @param telE Telefono de contacto al que hacer los encargos
     * @param nj Nombre del jefe o a quien hacemos los encargos
     * @param d Ubicacion del local donde esta el proveedor
     * @param f Fecha de cuando registramos al proveedor en el sistema
     */
    public Proveedor(String nomE, int telE, String nj, int d, String f)
    {
        nombreEmpresa=nomE;
        telefonoEmpresa=telE;
        nombreJefe=nj;
        direccion+=d;
        fechaAlta=comprobacion(f);
    }

    //METODOS
        //GET SET FECHA DE ALTA
    /**
     * @return fecha de alta del proveedor en formato texto
     */
    public String getFecha() {
        return fechaAlta;
    }

    /**
     * Modificar la fecha de alta del cliente o darle una si el dato esta vacio y comprobarla por posible error de formato
     * @param fecha fecha alta nueva con un formato estandar (dd/mm/yyyy)
     */
    public void setFecha(String fecha) {
        this.fechaAlta=comprobacion(fecha);
    }

        //METODOS FECHA DE ALTA
    /**
     * @param f fecha en cualquier formado posible de d/m/yy
     * @return fecha tipo texto y con el formato dd/mm/yyyy
     */
    private String comprobacion(String f)
    {
        String numero="", resultado="";
        String dia="", mes="", anyo="";

        for(int i=0;i<f.length(); i++)
        {
            if(f.charAt(i)=='/')
            {
                if(dia.length()==0)
                {
                    dia=numero;
                    numero="";
                }
                else if(mes.length()==0)
                {
                    mes=numero;
                    numero="";
                }
            }
            else numero+=f.charAt(i);
        }
        anyo=numero;

        if(dia.length()<2)
            dia="0"+dia;
        if(mes.length()<2)
            mes="0"+mes;
        if(anyo.length()<4)
            anyo="20"+anyo;

        resultado=dia+"/"+mes+"/"+anyo;
        return resultado;
    }

    /**
     * De tener la fecha en tipo texto dd/mm/yyyy , cambiarla a valor numerico
     * @return fecha en formato entero (yyyymmdd)
     */
    public int getFechaNum()
    {
        int dia=Integer.parseInt(fechaAlta.substring(0, 2));
        int mes=Integer.parseInt(fechaAlta.substring(3, 5));
        int anyo=Integer.parseInt(fechaAlta.substring(6, fechaAlta.length()));

        int resultado=anyo*10000+mes*100+dia;
        return resultado;
    }

        //GET SET NOMBRE EMPRESA
    /**
     * Modificar o añadir en caso de que el valor este vacio, el nombre de la empresa proveedora
     * @param n nuevo nombre de la empresa
     */
    public void setNomEmp(String n)
    {
        nombreEmpresa=n;
    }

    /**
     * @return nombre de la empresa proveedora
     */
    public String getNomEmp()
    {
        return nombreEmpresa;
    }

        //GET SET TELEFONO EMPRESA
    /**
     * Modificar o añadir en caso de que el valor este vacio, el numero de contacto para hacer los encargos
     * @param t nuevo telefono de contacto
     */
    public void setTelEmp(int t)
    {
        telefonoEmpresa=t;
    }

    /**
     * @return telefono de contacto del proveedor
     */
    public int getTelEmp()
    {
        return telefonoEmpresa;
    }

        //GET SET NOMBRE JEFE
    /**
     * Modificar o añadir en caso de que el valor este vacio, el nombre del jefe o del trabajdor al que hacemos los encargos
     * @param n nuevo nombre de contacto
     */
    public void setNomJef(String n)
    {
        nombreJefe=n;
    }

    /**
     * @return nombre del contacto de la empresa proveedora
     */
    public String getNomJef()
    {
        return nombreJefe;
    }

        //GET SET DIRECCION
    /**
     * Modificar o añadir en caso de que el valor este vacio, el numero del puesto en MercaValencia donde se ubica el proveedor
     * @param n  nuevo numero del puesto en MercaValencia donde se ubica el proveedor
     */
    public void setDireccion(int n)
    {
        direccion="MercaValencia Puesto "+n;
    }

    /**
     * @return ubicacion donde esta el proveedor
     */
    public String getDireccion()
    {
        return direccion;
    }

        //MOSTRAR LOS DATOS
    /**
     * Mostrar todos los datos del proveedor
     */
    public void mostrar()
    {
        System.out.println("\n-- INFORMACION DEL PROVEEDOR --");
        System.out.println("Nombre Empresa: "+getNomEmp());
        System.out.println("Telefono Empresa: "+getTelEmp());
        System.out.println("Nombre Jefe: "+getNomJef());
        System.out.println("Direccion: "+getDireccion());
        System.out.println("Fecha de alta: "+getFecha());
    }

        //MODIFICAR LOS DATOS DEL PROVEEDOR
    /**
     * Modificamos los datos que nos pida el usuario
     * El sistema mandara las ordenes necesarias y pedira por teclado los nuevos datos del proveedor
     */
    public void cambiarDatos()
    {
        int menu;
        do //ELEGIMOS LOS DATOS DEL PROVEEDOR QUE QUEREMOS MODIFICAR
        {
            System.out.println("\nQUE DATOS DEL RESTAURANTE QUIERES MODIFICAR:");
            System.out.println("1.Nombre de la empresa");
            System.out.println("2.Telefono de contacto de la empresa");
            System.out.println("3.Nombre del contacto de la empresa");
            System.out.println("4.Direccion del proveedor");
            System.out.println("5.Fecha de alta del proveedor");
            System.out.println("0.ATRAS");

            menu= Utils.preguntarInt("Elige una opcion:", 0,5);

            switch(menu) //CASE DE LOS DATOS DE LOS RESTAURANTES
            {
                case 1:
                    setNomEmp(Utils.preguntarString("Nombre de la empresa"));
                    break;

                case 2:
                    setTelEmp(Utils.preguntarInt("Telefono de contacto de la empresa", 0,999999999));
                    break;

                case 3:
                    setNomJef(Utils.preguntarString("Nombre del contacto de la empresa"));
                    break;

                case 4:
                    setDireccion(Utils.preguntarInt("Numero de puesto del proveedor:", 0, 100));
                    break;

                case 5:
                    setFecha(Utils.preguntarString("Fecha de alta del proveedor"));
                    break;

                case 0:break;

                default: System.out.println("\nOpcion Incorrecta (0 a 5)");
            }
        }while(menu!=0);
    }
}
