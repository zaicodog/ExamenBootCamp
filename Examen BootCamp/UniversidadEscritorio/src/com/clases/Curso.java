package com.clases;

public class Curso {
    private int id;
    private String nombre;
    private double nota;

    public Curso(int id, String nombre, double nota) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }
}