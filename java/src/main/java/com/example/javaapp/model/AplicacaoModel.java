package com.example.javaapp.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "aplicacao", schema = "avaliacao-ativ02-2chamada", catalog = "")
@IdClass(AplicacaoModelPK.class)
public class AplicacaoModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPessoa")
    private Integer idPessoa;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVacina")
    private Integer idVacina;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numDose")
    private Short numDose;
    @Basic
    @Column(name = "dataHora")
    private Timestamp dataHora;

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

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AplicacaoModel that = (AplicacaoModel) o;
        return Objects.equals(idPessoa, that.idPessoa) && Objects.equals(idVacina, that.idVacina) && Objects.equals(numDose, that.numDose) && Objects.equals(dataHora, that.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, idVacina, numDose, dataHora);
    }
}
