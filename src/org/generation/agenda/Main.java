package org.generation.agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("👉 Ingresa el tamaño máximo de la agenda (o presiona Enter para usar 10): ");
        String entrada = sc.nextLine();
        int tamano = entrada.isEmpty() ? 10 : Integer.parseInt(entrada);

        Agenda agenda = new Agenda(tamano);

        while (true) {
            System.out.println("""
                    
========= 📞 AGENDA TELEFÓNICA =========
1. Añadir contacto
2. Listar contactos
3. Buscar contacto
4. Eliminar contacto
5. Modificar teléfono
6. Verificar si la agenda está llena
7. Ver espacios libres
8. Salir
=======================================
""");

            System.out.print("Selecciona una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    agenda.anadirContacto(new Contacto(name, apellido, telefono));
                }

                case "2" -> agenda.listarContactos();

                case "3" -> {
                    System.out.print("Nombre a buscar: ");
                    String name = sc.nextLine();
                    System.out.print("Apellido a buscar: ");
                    String apellido = sc.nextLine();
                    agenda.buscarContacto(name, apellido);
                }

                case "4" -> {
                    System.out.print("Nombre a eliminar: ");
                    String name = sc.nextLine();
                    System.out.print("Apellido a eliminar: ");
                    String apellido = sc.nextLine();
                    agenda.eliminarContacto(name, apellido);
                }

                case "5" -> {
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();
                    agenda.modificarTelefono(name, apellido, nuevoTelefono);
                }

                case "6" -> {
                    if (agenda.agendaLlena()) System.out.println("🚫 La agenda está llena.");
                    else System.out.println("✅ Aún hay espacio disponible.");
                }

                case "7" -> agenda.espaciosLibres();

                case "8" -> {
                    System.out.println("👋 Saliendo del programa...");
                    sc.close();
                    return;
                }

                default -> System.out.println("❌ Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
