package com.example.demo.entities;

public class Pessoa {
    private static int contador = 1; // Para gerar IDs automáticos

    private int id;
    private String nome;

    public Pessoa(String nome) {
        this.id = contador++;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
