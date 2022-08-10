package com.ifba.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aplicacao") 
public class Aplicacao {
	
	@Id
	@GeneratedValue
	private Long id; 

	@ManyToOne(optional = false)
	@JoinColumn(name = "idPessoa")
	private Pessoa pessoa;

	@ManyToOne(optional = false)
	@JoinColumn(name = "idVacina")
	private Vacina vacina;
	
	@Column(nullable = false)
	private Integer numDose;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable =  false)
	private Date dataHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Integer getNumDose() {
		return numDose;
	}

	public void setNumDose(Integer numDose) {
		this.numDose = numDose;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataHora, pessoa, vacina, numDose);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aplicacao other = (Aplicacao) obj;
		return Objects.equals(dataHora, other.dataHora) && Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(vacina, other.vacina) && Objects.equals(numDose, other.numDose);
	}

	@Override
	public String toString() {
		return "Aplicacao [pessoa=" + pessoa + ", vacina=" + vacina + ", numDose=" + numDose + ", dataHora="
				+ dataHora + "]";
	}

}
