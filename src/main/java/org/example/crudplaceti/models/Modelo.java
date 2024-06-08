package org.example.crudplaceti.models;

import jakarta.persistence.*;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private int ano;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Modelo() {}
    public Modelo(String nome, int ano, boolean ativo, Marca marca) {
        this.nome = nome;
        this.ano = ano;
        this.ativo = ativo;
        this.marca = marca;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
