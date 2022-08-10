package com.ifba.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ifba.model.Vacina;

public class Vacinas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Vacinas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Vacina porId(Long id) {
		return manager.find(Vacina.class, id);
	}
	
	public List<Vacina> todos() {
		TypedQuery<Vacina> query = manager.createQuery("from Vacina", Vacina.class);
		return query.getResultList();
	}
	
	public void adicionar(Vacina vacina) {
		this.manager.persist(vacina);
	}
	
	public Vacina guardar(Vacina vacina) {
		return this.manager.merge(vacina);
	}
	
	public void excluir(Vacina vacina) {
		this.manager.remove(vacina);
	}
 	
}
