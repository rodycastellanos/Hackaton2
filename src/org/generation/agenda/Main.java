package org.generation.agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda;

        System.out.println("Bienvenido a tu Agenda de Contactos");
        System.out.print("¿Deseas configurar el tamaño de la agenda? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("s")) {
            System.out.print("Ingresa el tamaño de la agenda: ");
            int tamano = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            agenda = new Agenda(tamano);
            System.out.println("Agenda creada con capacidad de " + tamano + " contactos.\n");
        } else {
            agenda = new Agenda(); // Tamaño por defecto (10)
            System.out.println("Agenda creada con capacidad por defecto (10 contactos).\n");
        }


        int opcion;
        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar el salto de línea
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor ingresa un número.");
                scanner.nextLine(); // limpiar la entrada incorrecta
                opcion = -1; // fuerza repetir el menú
            }


            switch (opcion) {
                case 1: // Añadir Contacto
                    System.out.print("Introduce el nombre del contacto: ");
                    String nombreAnadir = scanner.nextLine();
                    System.out.print("Introduce el teléfono del contacto: ");
                    String telefonoAnadir = scanner.nextLine();
                    agenda.anadirContacto(new Contacto(nombreAnadir, telefonoAnadir));
                    break;
                case 2: // Comprobar si existe
                    System.out.print("Introduce el nombre del contacto a buscar: ");
                    String nombreExiste = scanner.nextLine();
                    if (agenda.existeContacto(new Contacto(nombreExiste, ""))) {
                        System.out.println("El contacto SÍ existe en la agenda.");
                    } else {
                        System.out.println("El contacto NO existe en la agenda.");
                    }
                    break;
                case 3: // Listar Contactos
                    agenda.listarContactos();
                    break;
                case 4: // Buscar Contacto
                    System.out.print("Introduce el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    agenda.buscaContacto(nombreBuscar);
                    break;
                case 5: // Eliminar Contacto
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombreEliminar, ""));
                    break;
                case 6: // Ver si la agenda está llena
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está completamente llena.");
                    } else {
                        System.out.println("Aún hay espacio en la agenda.");
                    }
                    break;
                case 7: // Ver espacios libres
                    System.out.println("Quedan " + agenda.espaciosLibres() + " espacios libres en la agenda.");
                    break;
                case 0: // Salir
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
            System.out.println(); // Línea en blanco para separar iteraciones del menú

        } while (opcion != 0);

        scanner.close(); // Buena práctica: cerrar el scanner al final
    }

    public static void mostrarMenu() {
        System.out.println("========= MENÚ AGENDA =========");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Comprobar si un contacto existe");
        System.out.println("3. Listar todos los contactos");
        System.out.println("4. Buscar contacto por nombre");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. Comprobar si la agenda está llena");
        System.out.println("7. Ver espacios libres");
        System.out.println("0. Salir");
        System.out.println("=============================");
    }
}