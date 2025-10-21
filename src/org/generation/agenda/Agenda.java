package org.generation.agenda;

import java.util.ArrayList;

    /**
     * Agenda de Contactos usando ArrayList
     * Implementa un límite máximo controlado manualmente porque lo pide la tarea
     */
    public class Agenda{
        // ========== ATRIBUTOS ==========
        private ArrayList<Contacto> contactos;
        private int tamanoMaximo;

        // ========== CONSTRUCTORES ==========

        /**
         * Constructor con tamaño personalizado
         * @param tamanoMaximo Capacidad máxima de la agenda
         */
        public Agenda(int tamanoMaximo) {
            this.tamanoMaximo = tamanoMaximo;
            this.contactos = new ArrayList<>();

        }

        /**
         * Constructor con tamaño por defecto (10)
         */
        public Agenda() {
            this(10);
        }

        // ========== MÉTODOS PÚBLICOS ==========

        /**
         * Añade un contacto a la agenda
         */
        public void anadirContacto(Contacto c) {
            if (existeContacto(c)) {
                System.out.println("El contacto '" + c.getNombre() + "' ya existe.");
                return;
            }

            if (agendaLlena()) {
                System.out.println("No se puede añadir. La agenda está llena.");
                return;
            }

            if (c.getNombre().trim().isEmpty()) {
                System.out.println("❌ El nombre y el apellido no pueden estar vacíos.");
                return;
            }

            if (c.getNombre().matches(".*[^a-zA-ZáéíóúÁÉÍÓÚñÑ ].*")) {
                System.out.println("⚠️ El nombre y el apellido no pueden contener símbolos o números.");
                return;
            }
            contactos.add(c);
            System.out.println("Contacto '" + c.getNombre() + "' añadido.");
        }

        /**
         * Verifica si un contacto existe en la agenda
         */
        public boolean existeContacto(Contacto c) {
            return contactos.contains(c);
        }

        /**
         * Lista todos los contactos de la agenda
         */
        public void listarContactos() {
            if (contactos.isEmpty()) {
                System.out.println("La agenda está vacía.");
                return;
            }

            System.out.println("\n ===== LISTA DE CONTACTOS =====");
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println((i + 1) + ". " + contactos.get(i));
            }
            System.out.println("=================================");
            System.out.println("Total: " + contactos.size() + "/" + tamanoMaximo);
            System.out.println();
        }

        /**
         * Busca un contacto por nombre y muestra su información
         */
        public void buscaContacto(String nombre) {
            for (Contacto c : contactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("📞 Encontrado: " + c);
                    return;
                }
            }
            System.out.println("No se encontró '" + nombre + "'.");
        }

        /**
         * Elimina un contacto de la agenda
         */
        public void eliminarContacto(Contacto c) {
            if (contactos.remove(c)) {
                System.out.println("Contacto '" + c.getNombre() + "' eliminado.");
            } else {
                System.out.println("El contacto no existe en la agenda.");
            }
        }

        /**
         * Indica si la agenda está llena
         */
        public boolean agendaLlena() {
            return contactos.size() >= tamanoMaximo;
        }

        /**
         * Devuelve la cantidad de espacios libres
         */
        public int espaciosLibres() {
            return tamanoMaximo - contactos.size();
        }


        /*
        * Modifica el número del teléfono
        * */

        public void modificarTelefono(String nombre, String nuevoTelefono) {
            for (Contacto c : contactos) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    c.setTelefono(nuevoTelefono);
                    System.out.println("Teléfono de '" + nombre + "' actualizado correctamente.");
                    return;
                }
            }
            System.out.println("No se encontró el contacto con el nombre '" + nombre + "'.");
        }


    }