package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vacina {
    private Integer id;
    private String nome;
    private Short doses;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "doses")
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
        Vacina vacina = (Vacina) o;
        return Objects.equals(id, vacina.id) && Objects.equals(nome, vacina.nome) && Objects.equals(doses, vacina.doses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, doses);
    }
}
