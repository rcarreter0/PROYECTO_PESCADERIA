/**
 * Clase Pescaderia
 *
 * Es la clase MAIN, donde ejecutaremos el menu y haremos todas las acciones que el
 * programa puede realizar
 *
 * @author Raul Carretero
 * @version 1
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Pescaderia
{
    public static void main (String[] args)
    {
        //DECLARAMOS LAS VARIABLES ENTERAS QUE HARAN DE MENUS
        int menu1,menu2,menu3,menu4,menu5;

        //CREAMOS LOS ALMACENES DE...
            //...PEDIDOS QUE NOS HACEN LOS CLIENTES
        ArrayList<Pedido>pedidos=new ArrayList<Pedido>();
            //...CLIENTES QUE NOS COMPRAN
        ArrayList<Cliente>clientes=new ArrayList<Cliente>();
            //...COMPRAS QUE HACEMOS A LOS PROVEEDORES
        ArrayList<Compra>compras=new ArrayList<Compra>();
            //...PROVEEDORES A LOS QUE COMPRAMOS
        ArrayList<Proveedor>proveedores=new ArrayList<Proveedor>();

        //alamcenamos 10 pedidos y 10 clientes para tener cargados los arraylist al arrancar el main
        Utils.arrancarArrayList(pedidos, clientes);

        //Leemos los objetos de los ficheros y cargamos los arrays con ellos
        Utils.arranqueProveedores(proveedores);
        Utils.arranqueCompras(compras);

        //COMPROBAMOS CUANTOS DATOS TENEMOS ALMACENADOS
        System.out.println("Num Clientes "+clientes.size());
        System.out.println("Num Proveedores "+proveedores.size());
        System.out.println("Num Pedidos "+pedidos.size());
        System.out.println("Num Compras "+compras.size());

        do
        {
            System.out.println("\nMENU");
            System.out.println("1.PEDIDOS");
            System.out.println("2.COMPRAS");
            System.out.println("3.CLIENTES");
            System.out.println("4.PROVEEDORES");
            System.out.println("5.Abrir JavaDoc Proyecto");
            System.out.println("0.SALIR");

            //SELECCIONAMOS QUE DATOS QUEREMOS MANEJAR
            menu1=Utils.preguntarInt("\nQue opcion quieres hacer: ", 0,5);
            System.out.println();

            switch(menu1)
            {
                case 1:
                    do //OPCIONES QUE PODEMOS HACER CON LOS PEDIDOS
                    {
                        System.out.println("\nOPCIONES PEDIDOS:");
                        System.out.println("1.Consultar Informacion Pedido");
                        System.out.println("2.Crear Nuevo Pedido");
                        System.out.println("3.Modificar Datos Pedido");
                        System.out.println("4.Eliminar Pedido");
                        System.out.println("0.ATRAS");

                        menu2=Utils.preguntarInt("\nQue quieres hacer con los pedidos: ", 0,5);

                        switch(menu2) //CASE DE LAS OPCIONES DE LOS PEDIDOS
                        {
                            case 1://consultar pedidos almacenados                     //OK
                                System.out.println("****PEDIDOS ALMACENADOS****");
                                for(int i=0; i<pedidos.size(); i++)
                                    System.out.println("Pedido-"+i+" -> "+pedidos.get(i).getFecha() +" // "+pedidos.get(i).getCliente()+" // "+pedidos.get(i).getEstado() );

                                int mostrar=Utils.preguntarInt("Que pedido quieres CONSULTAR (numPedido)", 0, pedidos.size()-1);

                                //MOSTRAMOS TODA LA INFORMACION DEL PEDIDO SELECCIONADO
                                System.out.println( pedidos.get(mostrar).toString() );
                                break;

                            case 2://almacenar un nuevo cliente                         //FALLA LA ORDENACION
                                System.out.println("\nIntroduce datos completos del Nuevo PEDIDO: ");

                                System.out.println("Para que Cliente/General.Restaurante es");
                                for(int i=0; i<clientes.size(); i++)
                                    if(clientes.get(i)instanceof Restaurante)
                                     System.out.println("RESTAURANTE "+i+" -> "+((Restaurante)clientes.get(i)).getNomRest());
                                    else
                                        System.out.println("CLIENTE "+i+" -> "+clientes.get(i).getNombre());

                                int n=Utils.preguntarInt("Por favor indica el numero del cliente", 0, clientes.size()-1);

                                String f1=Utils.preguntarString("Fecha del pedido: (dd/mm/yyyy)");

                                String descripcion=Utils.preguntarString("Descripcion: (Opcional)");

                                Pedido p=new Pedido(clientes.get(n), descripcion, f1);
                                char continuar='S';
                                int d=1;

                                //almacenamos el detalle del pedido
                                do {
                                    System.out.println("Detalle Numero "+d);

                                    String genero=Utils.preguntarString("Genero");

                                    String origen=Utils.preguntarString("Origen del genero");

                                    float cantidad=(float)Utils.preguntarDouble("Cantidad (Kg)d", 0, 500);

                                    float pr=(float)Utils.preguntarDouble("Precio el Kilo", 0, 500);


                                    p.nuevoDetalle(origen, genero, cantidad, pr);
                                    d++;

                                    continuar=Utils.preguntarString("Quieres almacenar otro detalle mas? (S/N)").charAt(0);

                                }while(continuar=='s' || continuar=='S');

                                System.out.println(p.toString());

                                char respuesta=Utils.preguntarString("Desea almacenarlo en el sitema?(S/N)").charAt(0);

                                if(respuesta=='S' || respuesta=='s' )
                                {
                                    //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
                                    Utils.pedidoOrdenado(p, pedidos);
                                    System.out.println("PEDIDO ALMACENADO CON EXITO");
                                }
                                else
                                    System.out.println("No se ha almacenado el cliente registrado");

                                break;

                            case 3: //modificar informacion del pedido                  //OK

                                System.out.println("****PEDIDOS ALMACENADOS****");
                                for(int i=0; i<pedidos.size(); i++)
                                    System.out.println("Pedido-"+i+" -> "+pedidos.get(i).getFecha() +" // "+pedidos.get(i).getCliente()+" // "+pedidos.get(i).getEstado());

                                int editar=Utils.preguntarInt("Que pedido quieres EDITAR (numPedido)", 0, pedidos.size()-1);
                                System.out.println(pedidos.get(editar).toString());

                                pedidos.get(editar).cambiarDatos(clientes);
                                break;

                            case 4://eliminar un pedido almacenado              //OK
                                System.out.println("****PEDIDOS ALMACENADOS****");
                                for(int i=0; i<pedidos.size(); i++)
                                    System.out.println("Pedido-"+i+" -> "+pedidos.get(i).getFecha() +" // "+pedidos.get(i).getCliente()+" // "+pedidos.get(i).getEstado());

                                int eliminar=Utils.preguntarInt("Que pedido quieres ELIMINAR (numPedido)", 0, pedidos.size()-1);
                                pedidos.get(eliminar).toString();

                                char respuesta1=Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                if(respuesta1=='S' || respuesta1=='s' )
                                {
                                    pedidos.remove(eliminar);
                                    System.out.println("¡¡¡ PEDIDO ELIMINADO !!!");
                                }
                                else System.out.println("No se ha eliminado el pedido seleccionado");
                                break;

                            case 0:break;

                            default: System.out.println("\nOpcion Incorrecta (0 a 4)");
                        }
                    }while(menu2!=0);
                    break;

                case 2:
                    do //OPCIONES QUE PODEMOS HACER CON LAS COMPRAS
                    {
                        System.out.println("\nOPCIONES COMPRAS:");
                        System.out.println("1.Consultar Informacion Compra");
                        System.out.println("2.Crear Nueva Compra");
                        System.out.println("3.Modificar Datos Compra");
                        System.out.println("4.Eliminar Compra");
                        System.out.println("0.ATRAS");

                        menu3=Utils.preguntarInt("\nQue quieres hacer con las compras:", 0,4);

                        switch(menu3) //CASE DE LAS OPCIONES DE LAS COMPRAS
                        {
                            case 1://consultar iformacion de las compras
                                System.out.println("****COMPRAS ALMACENADOS****");
                                for(int i=0; i<compras.size(); i++)
                                    System.out.println("Compra-"+i+" -> "+compras.get(i).getFecha() +" // "+compras.get(i).getProveedor()+" // "+compras.get(i).getEstado() );

                                int mostrar=Utils.preguntarInt("Que compra quieres CONSULTAR (numCompra)", 0,compras.size()-1);
                                System.out.println( compras.get(mostrar).toString() );
                                break;

                            case 2://crear una nueva compra
                                System.out.println("\nIntroduce datos completos de la Nueva General.Compra: ");

                                System.out.println("Para que Proveedor es");
                                for(int i=0; i<proveedores.size(); i++)
                                    System.out.println(i+" -> "+proveedores.get(i).getNomEmp());
                                int n=Utils.preguntarInt("Por favor indica el numero del proveedor", 0,proveedores.size()-1);

                                String f1=Utils.preguntarString("Fecha de la compra: (dd/mm/yyyy)");

                                String descripcion=Utils.preguntarString("Descripcion: (Opcional)");

                                Compra c=new Compra(proveedores.get(n), f1, descripcion);

                                char continuar='S';
                                int d=0;

                                //almacenamos el detalle de la compra
                                do {
                                    System.out.println("Detalle Numero "+d);

                                    String genero=Utils.preguntarString("Genero");

                                    String origen=Utils.preguntarString("Origen del genero");

                                    float cantidad=(float)Utils.preguntarDouble("Cantidad (Kg)",0,500);

                                    float pr=(float)Utils.preguntarDouble("Precio el Kilo",0,500);

                                    c.nuevoDetalle(origen, genero, cantidad, pr);
                                    d++;

                                    continuar=Utils.preguntarString("Quieres almacenar otro detalle mas? (S/N)").charAt(0);

                                }while(continuar=='s' || continuar=='S');

                                System.out.println(c.toString());

                                char respuesta=Utils.preguntarString("Desea almacenarlo en el sitema?(S/N)").charAt(0);

                                if(respuesta=='s' || respuesta=='S' )
                                {
                                    //ALMACENAMOS EN ORDEN DE FECHA LAS COMPRAS
                                    Utils.compraOrdenada(c, compras);

                                    System.out.println("COMPRA ALMACENADA CON EXITO");

                                }
                                else
                                    System.out.println("No se ha almacenado la compra registrado");

                                break;

                            case 3://modificamos informacion de la compra

                                System.out.println("****COMPRAS ALMACENADOS****");
                                for(int i=0; i<compras.size(); i++)
                                    System.out.println("Compra-"+i+" -> "+compras.get(i).getFecha() +" // "+compras.get(i).getProveedor()+" // "+compras.get(i).getEstado());

                                int editar=Utils.preguntarInt("Que compra quieres EDITAR (numCompra)",0,compras.size()-1);

                                System.out.println(compras.get(editar).toString());

                                compras.get(editar).cambiarDatos(proveedores);

                                Utils.guardarCompras(compras);
                                break;

                            case 4:
                                System.out.println("****COMPRAS ALMACENADAS****");
                                for(int i=0; i<compras.size(); i++)
                                    System.out.println("Compra-"+i+" -> "+compras.get(i).getFecha() +" // "+compras.get(i).getProveedor()+" // "+compras.get(i).getEstado());

                                int eliminar=Utils.preguntarInt("Que compra quieres ELIMINAR (numCompra)", 0, compras.size()-1);
                                System.out.println(compras.get(eliminar).toString());

                                char respuesta1=Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                if(respuesta1=='S' || respuesta1=='s' )
                                {
                                    compras.remove(eliminar);
                                    System.out.println("¡¡¡ COMPRA ELIMINADA !!!");

                                    Utils.guardarCompras(compras);//modificamos el fichero
                                } //COMPRA ELIMINADA

                                else System.out.println("No se ha eliminado el pedido seleccionado");
                                break;

                            case 0:break;

                            default: System.out.println("\nOpcion Incorrecta (0 a 4)");
                        }
                    }while(menu3!=0);
                    break;

                case 3:
                    do //OPCIONES QUE PODEMOS HACER CON LOS CLIENTES
                    {
                        System.out.println("\nOPCIONES CLIENTES:");
                        System.out.println("1.Consultar informacion CLIENTE");
                        System.out.println("2.Nuevo CLIENTE");
                        System.out.println("3.Modificar Informacion CLIENTE");
                        System.out.println("4.Eliminar CLIENTE");
                        System.out.println("0.ATRAS");

                        menu4=Utils.preguntarInt("\nQue quieres hacer con los restaurantes: ", 0,4);

                        switch(menu4) //CASE DE LAS OPCIONES DE RESTAURANTES
                        {
                            case 1://consutar clientes
                                System.out.println("QUE TIPO DE CLIENTE DESEA CONSULTAR ?");
                                char l1=Utils.preguntarString("RESTAURANTES(R) o CLIENTES(C)\nCual desea (R/C)").charAt(0);

                                if(l1=='r' || l1=='R')
                                {
                                    System.out.println("****RESTAURANTES ALMACENADOS****");
                                    for(int i=0; i<clientes.size(); i++)
                                    {
                                        if(clientes.get(i) instanceof Restaurante)
                                            System.out.println("Restaurante-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                    }

                                    int mostrar=Utils.preguntarInt("Que Restaurante quieres CONSULTAR (numCliente)", 0, clientes.size()-1);

                                    //MOSTRAMOS EL CLIENTE DEPENDIENDO DE LA CLASE QUE PERTENEZCA
                                    if(clientes.get(mostrar) instanceof Restaurante)
                                        ((Restaurante) clientes.get(mostrar)).mostrar();
                                    else
                                        System.out.println("El numero de cliente seleccionado no es valido con Restaurantes");

                                }
                                else if(l1=='c' || l1=='C')
                                {
                                    System.out.println("****CLIENTES ALMACENADOS****");
                                    for(int i=0; i<clientes.size(); i++)
                                    {
                                        if(clientes.get(i) instanceof Persona)
                                            System.out.println("Cliente-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                    }

                                    int mostrar=Utils.preguntarInt("Que Cliente quieres CONSULTAR (numCliente)", 0, clientes.size()-1);

                                    //MOSTRAMOS EL CLIENTE DEPENDIENDO DE LA CLASE QUE PERTENEZCA
                                    if(clientes.get(mostrar) instanceof Persona)
                                        ((Persona) clientes.get(mostrar)).mostrar();
                                    else
                                        System.out.println("El numero de cliente seleccionado no es valido con Clientes");
                                }
                                else
                                    System.out.println("Opcion Incorrecta (R/C)");

                                break;

                            case 2: //almacenar nuevo cliente
                                System.out.println("QUE TIPO DE CLIENTE DESEA ALMACENAR ?");
                                char l2=Utils.preguntarString("RESTAURANTES(R) o CLIENTES(C)\nCual desea almacenar (R/C)").charAt(0);

                                if(l2=='r' || l2=='R' || l2=='c' || l2=='C')
                                {
                                    Cliente c=null;
                                    if (l2 == 'r' || l2 == 'R')
                                    {
                                        System.out.println("\nIntroduce datos completos del Nuevo RESTAURANTE: ");

                                        String nomJefe = Utils.preguntarString("Nombre completo del jefe del restaurante o del que nos hace los encargos:");

                                        int telf1 = Utils.preguntarInt("Numero telefono de contacto del cliente jefe o encargado:",0,1000000000);

                                        String dir = Utils.preguntarString("Direccion donde se ubica el restaurante");

                                        String fA = Utils.preguntarString("Fecha de cuando registramos al restaurante en el sistema");

                                        String nomRest = Utils.preguntarString("Nombre Restaurante: ");

                                        int telf2 = Utils.preguntarInt("Telefono del local Restaurante",0,1000000000);

                                        c = new Restaurante(nomJefe, telf1, dir, fA, nomRest, telf2);
                                    }
                                    else if (l2 == 'c' || l2 == 'C')
                                    {
                                        System.out.println("\nIntroduce datos completos del Nuevo CLIENTE: ");

                                        String nomJefe = Utils.preguntarString("Nombre completo del cliente: ");

                                        int telf1 = Utils.preguntarInt("Numero telefono de contacto del cliente :",0,1000000000);

                                        String dir = Utils.preguntarString("Direccion donde vive el cliente");

                                        String fA = Utils.preguntarString("Fecha de cuando registramos al cliente en el sistema");


                                        c = new Persona(nomJefe, telf1, dir, fA);
                                    }

                                    c.toString();

                                    char respuesta=Utils.preguntarString("Desea almacenarlo en el sitema?(S/N)").charAt(0);

                                    if(respuesta=='s' || respuesta=='S' )
                                    {
                                        //ALMACENAMOS EN ORDEN DE FECHA LOS CLIENTES
                                        Utils.clienteOrdenado(c, clientes);

                                        if(c instanceof Restaurante)
                                            System.out.println("RESTAURANTE ALMACENADO CON EXITO");
                                        else
                                            System.out.println("CLIENTE ALMACENADO CON EXITO");


                                    }
                                    else
                                        System.out.println("No se ha almacenado el cliente registrado");

                                }
                                else
                                    System.out.println("NO SE HA ALMACENADO NINGUN TIPO DE CLIENTE\n OPCION INCORRECTA(R/C)");

                                break;

                            case 3: //modificar los datos de un cliente
                                System.out.println("****CLIENTES ALMACENADOS****");
                                for(int i=0; i<clientes.size(); i++)
                                {
                                    if(clientes.get(i) instanceof Restaurante)
                                        System.out.println("RESTAURANTE-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                    else
                                        System.out.println("CLIENTE-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                }
                                int editar=Utils.preguntarInt("Que cliente quieres EDITAR (numCliente)",0,clientes.size()-1);

                                //DEPENDIENDO DE QUE TIPO DE CLIENTE QUEREMOS EDITAR DEBEMOS DE MOSTRAR DATOS DIFERENTES
                                if (clientes.get(editar) instanceof Restaurante)
                                {
                                    //mostramos el contenido del restaurante que queremos modificar
                                    ((Restaurante) clientes.get(editar)).mostrar();

                                    //llamamos a la funcion que se encarga de modificar los datos
                                    ((Restaurante)clientes.get(editar)).cambiarDatos();
                                }
                                else
                                {
                                    //mostramos el contenido del cliente que queremos modificar
                                    ((Persona) clientes.get(editar)).mostrar();

                                    //llamamos a la funcion que se encarga de modificar los datos
                                    ((Persona)clientes.get(editar)).cambiarDatos();
                                }

                                break;

                            case 4: //eliminar un cliente
                                System.out.println("****CLIENTES ALMACENADOS****");
                                for(int i=0; i<clientes.size(); i++)
                                {
                                    if(clientes.get(i) instanceof Restaurante)
                                        System.out.println("Restaurante-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                    else
                                        System.out.println("Cliente-" + i + " -> " + clientes.get(i).getFechaAlta()+" // "+clientes.get(i).getNombre());
                                }

                                int eliminar=Utils.preguntarInt("Que cliente quieres ELIMINAR (numCliente)", 0,clientes.size()-1);

                                if (clientes.get(eliminar) instanceof Restaurante)
                                    ((Restaurante) clientes.get(eliminar)).mostrar();
                                else
                                    ((Persona) clientes.get(eliminar)).mostrar();

                                char respuesta = Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                if (respuesta == 'S' || respuesta == 's')
                                {
                                    clientes.remove(eliminar);
                                    if(clientes.get(eliminar) instanceof Restaurante)
                                        System.out.println("¡¡¡ RESTAURANTE ELIMINADO !!!");
                                    else
                                        System.out.println("¡¡¡ CLIENTE ELIMINADO !!!");
                                } //CLIENTE ELIMINADO
                                else
                                    System.out.println("No se ha eliminado el cliente seleccionado");

                                break;

                            case 0:break;

                            default: System.out.println("\nOpcion Incorrecta (0 a 4)");
                        }
                    }while(menu4!=0);
                    break;

                case 4:
                    do //OPCIONES QUE PODEMOS HACER CON LOS PROVEEDORES
                    {
                        System.out.println("\nOPCIONES PROVEEDORES:");
                        System.out.println("1.Consultar informacion Proveedor");
                        System.out.println("2.Nuevo Proveedor");
                        System.out.println("3.Modificar Informacion Proveedor");
                        System.out.println("4.Eliminar Proveedor");
                        System.out.println("0.ATRAS");

                        menu5=Utils.preguntarInt("\nQue quieres hacer con los proveedores: ", 0,4);

                        switch(menu5) //CASE DE LAS OPCIONES DE LOS PROVEEDORES
                        {
                            case 1: //Consultar un proveedor
                                System.out.println("****PROVEEDORES ALMACENADOS****");
                                for(int i=0; i<proveedores.size(); i++)
                                    System.out.println("Proveedor-" + i + " -> " + proveedores.get(i).getFecha()+" // "+proveedores.get(i).getNomEmp());

                                    int mostrar=Utils.preguntarInt("Que proveedor quieres CONSULTAR (numProveedor)", 0,proveedores.size()-1);

                                    proveedores.get(mostrar).mostrar();

                                break;

                            case 2:
                                System.out.println("ALMACENAR NUEVO PROVEEDOR");

                                System.out.println("\nIntroduce datos completos del Nuevo PROVEEDOR: ");

                                String nomJefe = Utils.preguntarString("Nombre de la empresa: ");

                                String nom = Utils.preguntarString("Nombre del jefe o del encargado en contacto:");

                                int telf1 = Utils.preguntarInt("Numero telefono para contactar con el proveedor:", 0,1000000000);

                                int dir = Utils.preguntarInt("Numero de puesto del proveedor:", 0, 100);

                                String fA = Utils.preguntarString("Fecha de cuando registramos al proveedor en el sistema(dd/mm/yyyy)");

                                Proveedor p = new Proveedor(nomJefe, telf1,nom, dir, fA);

                                p.mostrar();

                                char respuesta=Utils.preguntarString("Desea almacenarlo en el sitema?(S/N)").charAt(0);

                                if(respuesta=='S' || respuesta=='s' )
                                {
                                    //ALMACENAR ORDENADO POR FECHA(de mas nuevo a mas viejo)
                                    Utils.proveedorOrdenado(p, proveedores);
                                    System.out.println("PROVEEDOR ALMACENADO CON EXITO");

                                }
                                else
                                    System.out.println("No se ha almacenado el cliente registrado");

                                break;

                            case 3://modificar informacion del proveedor
                                System.out.println("****PROVEEDORES ALMACENADOS");
                                for(int i=0; i<proveedores.size(); i++)
                                    System.out.println("Proveedor-" + i + " -> " + proveedores.get(i).getFecha()+" // "+proveedores.get(i).getNomEmp());

                                int editar=Utils.preguntarInt("Que proveedor quieres EDITAR (numProveedor)", 0, proveedores.size()-1);

                                proveedores.get(editar).mostrar();
                                proveedores.get(editar).cambiarDatos();

                                //ACTUALIZAMOS EL FICHERO
                                Utils.guardarProveedores(proveedores);

                                break;

                            case 4://eliminar un proveedor
                                System.out.println("****PROVEEDORES ALMACENADOS****");
                                for(int i=0; i<proveedores.size(); i++)
                                    System.out.println("Proveedor-" + i + " -> " + proveedores.get(i).getFecha()+" // "+proveedores.get(i).getNomEmp());

                                int eliminar=Utils.preguntarInt("Que proveedor quieres ELIMINAR (numProveedor)",0,proveedores.size()-1);
                                proveedores.get(eliminar).mostrar();

                                char respuesta1=Utils.preguntarString("¿Quieres eliminarlo?(S/N)").charAt(0);
                                if(respuesta1=='S' || respuesta1=='s' )
                                {
                                    proveedores.remove(eliminar);
                                    System.out.println("¡¡¡ PROVEEDOR ELIMINADO !!!");

                                    //almacenamos las actualizaciones en el fichero
                                    Utils.guardarProveedores(proveedores);

                                } //PROVEEDOR ELIMINADO
                                else
                                    System.out.println("No se ha eliminado el proveedor seleccionado");
                                break;

                            case 0:break;

                            default: System.out.println("\nOpcion Incorrecta (0 a 4)");
                        }
                    }while(menu5!=0);
                    break;

                case 5:
                    System.out.println("\nAbriendo el javadoc del proyecto ...");
                    abrirHTML();
                    break;

                case 0:
                    System.out.println("\nAdios, Gracias por su consulta");
                    break;

                default: System.out.println("\nOpcion Incorrecta (0 a 4)");
            }
        }while(menu1!=0);
    }

    /**
     * Abrimos con el navegador por defecto el archivo .html
     */
    private static void abrirHTML(){
        try {
            File objetofile = new File("./ARCHIVOS_JAVA/JavaDoc/index.html");
            Desktop.getDesktop().open(objetofile);
            System.out.println("... Se ha abierto el documento .html");
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}