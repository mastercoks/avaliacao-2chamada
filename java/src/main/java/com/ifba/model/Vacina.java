package com.ifba.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacina")
public class Vacina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer doses;

	public Vacina() {
	}
	
	public Vacina(String nome, Integer doses) {
		this.nome = nome;
		this.doses = doses;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDoses() {
		return doses;
	}
	
	public void setDoses(Integer doses) {
		this.doses = doses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doses, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(doses, other.doses) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Vacina [id=" + id + ", nome=" + nome + ", doses=" + doses + "]";
	}
	
	
	
}
