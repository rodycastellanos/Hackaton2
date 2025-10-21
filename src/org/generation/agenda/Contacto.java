package org.generation.agenda;

public class Contacto {
    //atributos privados
    private String nombre;
    private String telefono;

    //constructor
    public Contacto(String name, String telefono) {
        this.nombre = name;
        this.telefono = telefono;

        //Getters y Setters
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
 * Sobrescribimos equals() para definir cuándo dos contactos son iguales
 * Dos contactos son iguales si tienen el mismo nombre (case-insensitive)
 */
@Override
public boolean equals(Object obj) {
    // Si es el mismo objeto en memoria
    if (this == obj) {
        return true;
    }

    // Si el objeto es null o de diferente clase
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

    // Convertimos el objeto a Contacto y comparamos nombres
    Contacto contacto = (Contacto) obj;
    return this.nombre.equalsIgnoreCase(contacto.nombre);
}

/**
 * toString() para mostrar el contacto de forma legible
 */
@Override
public String toString() {
    return "Nombre: " + nombre + " | Teléfono: " + telefono;
}
}