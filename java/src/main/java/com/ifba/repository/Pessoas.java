package com.ifba.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ifba.model.Pessoa;

public class Pessoas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todos() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}
	
	public void adicionar(Pessoa pessoa) {
		this.manager.persist(pessoa);
	}
	
	public Pessoa guardar(Pessoa pessoa) {
		return this.manager.merge(pessoa);
	}
	
	public void excluir(Pessoa pessoa) {
		this.manager.remove(pessoa);
	}
 	
}
