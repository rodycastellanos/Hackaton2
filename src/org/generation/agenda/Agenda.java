package org.generation.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private int tamanoMaximo;

    public Agenda() {
        this(10); // tamaño por defecto
    }

    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        this.contactos = new ArrayList<>();
    }

    // ---------------- Métodos principales ---------------- //

    public void anadirContacto(Contacto c) {
        if (c.getName().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
            System.out.println("❌ El nombre y el apellido no pueden estar vacíos.");
            return;
        }
        if (c.getName().matches(".*[^a-zA-ZáéíóúÁÉÍÓÚñÑ ].*")) {
            System.out.println("⚠️ El nombre y el apellido no pueden contener símbolos o números.");
            return;
        }
        if (c.getApellido().matches(".*[^a-zA-ZáéíóúÁÉÍÓÚñÑ ].*")) {
            System.out.println("⚠️ El nombre y el apellido no pueden contener símbolos o números.");
            return;
        }
        if (agendaLlena()) {
            System.out.println("❌ La agenda está llena. No se pueden agregar más contactos.");
            return;
        }
        if (existeContacto(c)) {
            System.out.println("⚠️ Ya existe un contacto con ese nombre y apellido.");
            return;
        }

        contactos.add(c);
        System.out.println("✅ Contacto añadido correctamente.");
    }

    public boolean existeContacto(Contacto c) {
        return contactos.stream().anyMatch(contacto ->
                contacto.getName().equalsIgnoreCase(c.getName()) &&
                        contacto.getApellido().equalsIgnoreCase(c.getApellido())
        );
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("📭 No hay contactos en la agenda.");
            return;
        }

        // Ordenar por name y apellido
        Collections.sort(contactos, Comparator
                .comparing(Contacto::getName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\n📖 Lista de contactos:");
        for (Contacto c : contactos) {
            System.out.println("  " + c.getName() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    public void buscarContacto(String name, String apellido) {
        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(name) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("🔎 Teléfono de " + name + " " + apellido + ": " + c.getTelefono());
                return;
            }
        }
        System.out.println("❌ Contacto no encontrado.");
    }

    public void eliminarContacto(String name, String apellido) {
        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(name) && c.getApellido().equalsIgnoreCase(apellido)) {
                contactos.remove(c);
                System.out.println("🗑️ Contacto eliminado correctamente.");
                return;
            }
        }
        System.out.println("❌ No se encontró el contacto a eliminar.");
    }

    public void modificarTelefono(String name, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("✅ Teléfono actualizado correctamente.");
                return;
            }
        }
        System.out.println("❌ No se encontró el contacto para modificar.");
    }

    public boolean agendaLlena() {
        return contactos.size() >= tamanoMaximo;
    }

    public void espaciosLibres() {
        int libres = tamanoMaximo - contactos.size();
        System.out.println("📦 Espacios libres: " + libres);
    }
}
