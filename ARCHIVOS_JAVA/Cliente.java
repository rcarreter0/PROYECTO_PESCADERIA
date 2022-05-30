/**
 * Clase Cliente
 *
 * Contiene metodos con las variables que solemos pedir de todos los clientes(SIN DISTINCIONES)
 *
 * @author Raul Carretero
 * @version 1
 */
public class Cliente
{
        //ATRIBUTOS
    /**
     * Nombre completo del cliente (1 persona)
     */
    protected String nombre;

    /**
     * Numero de telefono de contacto del cliente
     */
    protected int telefono;

    /**
     * Direccion donde se ubica el cliente
     */
    protected String direccion;

    /**
     * Fecha de cuando registramos al cliente en el sistema
     */
    protected String fechaAlta;


        //CONSTRUCTOR
    /**
     * Constructor con 4 parametros
     * @param nom nombre completo del cliente
     * @param tel telefono de contacto del cliente
     * @param dir direccion donde vive el cliente
     * @param fA fecha de cuando registramos al cliente en el sistema
     */
    public Cliente(String nom, int tel, String dir, String fA)
    {
        nombre=nom;
        telefono=tel;
        direccion=dir;
        fechaAlta=comprobacion(fA);
    }

    //METODOS
        //GET SET NOMBRE
    /**
     * Modificar el nombre del cliente o darle uno si el dato esta vacio
     * @param n nuevo nombre del cliente
     */
    public void setNombre(String n)
    {
        nombre=n;
    }

    /**
     * @return nombre del cliente
     */
    public String getNombre()
    {
        return nombre;
    }


        //GET SET TELEFONO
    /**
     * Modificar el telefono de contacto del cliente o darle uno si el dato esta vacio
     * @param t telefono nuevo
     */
    public void setTelefono(int t)
    {
        telefono=t;
    }

    /**
     * @return telefono de contacto del cliente
     */
    public int getTelefono()
    {
        return telefono;
    }

        //GET SET DIRECCION
    /**
     * Modificar la direccion donde se ubica el cliente o darle uno si el dato esta vacio
     * @param t direccion nueva
     */
    public void setDireccion(String t)
    {
        direccion=t;
    }

    /**
     * @return direccion donde se ubica el cliente
     */
    public String getDireccion()
    {
        return direccion;
    }


        //GET SET FECHA ALTA
    /**
     * Modificar la fecha de alta del cliente o darle una si el dato esta vacio y comprobarla por posible error de formato
     * @param t fecha alta nueva con un formato estandar (dd/mm/yyyy)
     */
    public void setFechaAlta(String t)
    {
        this.fechaAlta=comprobacion(t);;
    }

    /**
     * @return fecha de alta del cliente en formato texto
     */
    public String getFechaAlta()
    {
        return fechaAlta;
    }

        //METODOS FECHA
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
}

