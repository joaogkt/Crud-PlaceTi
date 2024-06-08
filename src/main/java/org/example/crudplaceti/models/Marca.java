package org.example.crudplaceti.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String codigoDenatran;
    private boolean ativo;

    @OneToMany(mappedBy = "marca")
    private List<Modelo> modelos;
    public Marca() {}
    public Marca(String nome, String codigoDenatran, boolean ativo) {}

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
    public String getCodigoDenatran() {
        return codigoDenatran;
    }
    public void setCodigoDenatran(String codigoDenatran) {
        this.codigoDenatran = codigoDenatran;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
}
