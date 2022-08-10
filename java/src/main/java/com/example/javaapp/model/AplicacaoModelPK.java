package com.example.javaapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class AplicacaoModelPK implements Serializable {
    @Column(name = "idPessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;
    @Column(name = "idVacina")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVacina;
    @Column(name = "numDose")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short numDose;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    public Short getNumDose() {
        return numDose;
    }

    public void setNumDose(Short numDose) {
        this.numDose = numDose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AplicacaoModelPK that = (AplicacaoModelPK) o;
        return Objects.equals(idPessoa, that.idPessoa) && Objects.equals(idVacina, that.idVacina) && Objects.equals(numDose, that.numDose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idVacina, numDose);
    }
}
