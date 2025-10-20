package org.generation.agenda;

import java.util.ArrayList;

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