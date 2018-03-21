/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import acciones.AsignarTelefono;
import acciones.ConsultarModelosCelular;
import acciones.ConsultarTelefonoCliente;
import acciones.RegistrarCliente;
import clases.Cliente;
import clases.ModeloCelular;
import clases.UsuarioModelo;
import java.util.Scanner;

/**
 *
 * @author Christian
 */
public class Main {
    static ConsultarModelosCelular consultaModelos = new ConsultarModelosCelular();
    static RegistrarCliente registraClientes = new RegistrarCliente();
    static AsignarTelefono asignaTel = new AsignarTelefono();
    static ConsultarTelefonoCliente consultaTelCliente = new ConsultarTelefonoCliente();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        while(true){
                System.out.println(
                    "====================================================="+
                    "\n                Menú Principal"+
                    "\n==================================================="+
                    "\n|  1) Registrar un nuevo Cliente                  |"+
                    "\n|  2) Consultar modelos de Teléfono Disponibles   |"+
                    "\n|  3) Asignar modelos de Teléfono a Clientes      |"+        
                    "\n|  4) Salir                                       |"+
                    "\n==================================================="
                );
            System.out.print("Selecciona una opción: ");
            String opcion = sc.nextLine();
            
            if("1".equals(opcion)){
                insertaCliente(lecturaDatosCliente());
            }
            if("2".equals(opcion)){
                System.out.println("=====================================================");
                System.out.println("        *** Lista de Modelos de Teléfono ***");
                System.out.println("=====================================================");
                despliegaModelos();
                System.out.print("\nDeseas asignar algún Modelo de Teléfono a un Cliente (Y/N): ");
                String bool = sc.nextLine();
                if("Y".equals(bool)){
                    System.out.println("=====================================================");
                    System.out.println("        ***       Lista de Clientes      ***");
                    System.out.println("=====================================================");
                    despliegaClientes();
                    asignar();
                }
            }
            if("3".equals(opcion)){
                System.out.println("=====================================================");
                System.out.println("        ***       Lista de Clientes      ***");
                System.out.println("=====================================================");
                despliegaClientes();
                System.out.println("=====================================================");
                System.out.println("        *** Lista de Modelos de Teléfono ***");
                System.out.println("=====================================================");
                despliegaModelos();
                asignar();
            }
            if("4".equals(opcion)){
                break;
            }
        }
    }
    
    public static Cliente lecturaDatosCliente(){
        Cliente cliente = new Cliente();
        System.out.println("\n=====================================================");
        System.out.println("            Ingresa los datos del Cliente");
        System.out.println("=====================================================");
        System.out.print("Ingresa la clave del Cliente: ");
        cliente.setClaveIdent(sc.nextLine());
        System.out.print("Ingresa el Primer Apellido: ");
        cliente.setPrimerApellido(sc.nextLine());
        System.out.print("Ingresa el Segundo Apellido: ");
        cliente.setSegundoApellido(sc.nextLine());
        System.out.print("Ingresa el Nombre: ");
        cliente.setNombre(sc.nextLine());
        System.out.print("Ingresa la Fecha de Apertura (YYYY-MM-DD): ");
        cliente.setFechaApertura(sc.nextLine());
        return cliente;
    }
    
    public static void insertaCliente(Cliente cliente){
        registraClientes.registrarNuevoCliente(cliente);
        System.out.println("\nRegistro de nuevo Cliente Exitosa!!!");
        cliente.imprimeCliente();
    }
    
    public static void despliegaModelos(){
        consultaModelos.despliegaListaModelos();
    }
    
    public static ModeloCelular buscaClaveModelo(){
        System.out.print("Ingresa la Clave del Modelo de Celular que deseas asignar: ");
        String clave = sc.nextLine();
        return consultaModelos.buscarModeloPorClave(clave);
    }
    
    public static void despliegaClientes(){
        registraClientes.despliegaListaCliente();
    }
    
    public static Cliente buscaClaveCliente(){
        System.out.print("Ingresa la Clave del Cliente al que deseas asignarle un Modelo de Celular: ");
        String clave = sc.nextLine();
        return registraClientes.buscarClientePorClave(clave);
    }
    
    public static void despliegaUsuarioModelo(){
        consultaTelCliente.despliegaListaUsuarioModelo();
    }
    
    public static void asignar(){       
        System.out.print("\nIngresa la Fecha en que se realiza la Compra (YYYY-MM-DD): ");
        String fecha = sc.nextLine();
        UsuarioModelo usm = asignaTel.asignarTel(buscaClaveCliente(), buscaClaveModelo(), fecha);
        System.out.println("\nAsignación Exitosa!!!");
        usm.imprimeUsuarioModelo();
    }
}