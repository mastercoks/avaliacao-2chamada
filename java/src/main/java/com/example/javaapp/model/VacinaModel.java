package com.example.javaapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vacina", schema = "avaliacao-ativ02-2chamada", catalog = "")
public class VacinaModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "doses")
    private Short doses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Short getDoses() {
        return doses;
    }

    public void setDoses(Short doses) {
        this.doses = doses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacinaModel that = (VacinaModel) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(doses, that.doses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, doses);
    }
}
