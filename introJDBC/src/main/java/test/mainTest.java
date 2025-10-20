/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.personaDAO;
import domain.persona;
import java.util.List;
import java.util.Scanner;
import java.sql.*;


public class mainTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        personaDAO dao = new personaDAO();
        int opcion = 0;

        do {
          
            System.out.println("1.listar personas");
            System.out.println("2.insertar nueva persona");
            System.out.println("3.actualizar persona");
            System.out.println("4.eliminar persona");
            System.out.println("5.salir");
            System.out.print("elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    listarPersonas(dao);
                    break;

                case 2:
                    insertarPersona(dao, sc);
                    break;

                case 3:
                    actualizarPersona(dao, sc);
                    break;

                case 4:
                    eliminarPersona(dao, sc);
                    break;

                case 5:
                    System.out.println("acabo");
                    break;

                default:
                    System.out.println("opcion no encontrada");
            }

        } while (opcion != 5);

        sc.close();
    }


    private static void listarPersonas(personaDAO dao) {
        try {
            System.out.println("tabla de personas");
            List<persona> personas = dao.seleccionar();
            for (persona p : personas) {
                System.out.println(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void insertarPersona(personaDAO dao, Scanner sc) {
        System.out.println("ingrese, nombre, apellido, email y telefono");
        System.out.print("nombre");
        String nombre = sc.nextLine();
        System.out.print("apellido");
        String apellido = sc.nextLine();
        System.out.print("email");
        String email = sc.nextLine();
        System.out.print("teléfono");
        String telefono = sc.nextLine();

        persona nueva = new persona(nombre, apellido, email, telefono);
        int registros = dao.insertar(nueva);

        if (registros > 0) {
            System.out.println("se inserto la persona");
        } else {
            System.out.println("");
        }
    }

    private static void actualizarPersona(personaDAO dao, Scanner sc) {
        System.out.println("actualizar registro");
        System.out.print("ingrese el id");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("nombre");
        String nombre = sc.nextLine();
        System.out.print("apellido");
        String apellido = sc.nextLine();
        System.out.print("email");
        String email = sc.nextLine();
        System.out.print("telefono");
        String telefono = sc.nextLine();

        persona p = new persona(id, nombre, apellido, email, telefono);
        int registros = dao.Actializar(p);

        if (registros > 0) {
            System.out.println("se actualizo el registro");
        } else {
            System.out.println("no se encontro el id");
        }
    }

    private static void eliminarPersona(personaDAO dao, Scanner sc) {
        System.out.println("eliminar registro");
        System.out.print("ingrese el id de la persona a eliminar");
        int id = sc.nextInt();

        persona p = new persona(id);
        int registros = dao.Borrar(p);

        if (registros > 0) {
            System.out.println("persona eliminada.");
        } else {
            System.out.println("no se encontro el id");
        }
    }
}
