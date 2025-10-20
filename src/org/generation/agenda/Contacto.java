package org.generation.agenda;

public class Contacto {
    private String name;
    private String apellido;
    private String telefono;


    public Contacto(String name, String apellido, String telefono) {
        this.name = name;
        this.apellido = apellido;
        this.telefono = telefono;

        //Getters
    }

    public String getName() {
        return name;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getApellido() {
        return apellido;
    }
}
