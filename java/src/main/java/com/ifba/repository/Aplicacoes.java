package com.ifba.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ifba.model.Aplicacao;

public class Aplicacoes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Aplicacoes(EntityManager manager) {
		this.manager = manager;
	}
	 
	public Aplicacao porId(Long id) {
		return manager.find(Aplicacao.class, id);
	}
	
	public boolean validar(Aplicacao aplicacao) {
		TypedQuery<Aplicacao> query = manager.createQuery(
			"from Aplicacao where idPessoa=:idPessoa and idVacina=:idVacina and numDose=:numDose",
			Aplicacao.class
		);
		query.setParameter("idPessoa", aplicacao.getPessoa().getId());
		query.setParameter("idVacina", aplicacao.getVacina().getId());
		query.setParameter("numDose", aplicacao.getNumDose());
		return  query.getResultList().isEmpty();
	}
	
	public List<Aplicacao> todos() {
		TypedQuery<Aplicacao> query = manager.createQuery("from Aplicacao", Aplicacao.class);
		return query.getResultList();
	}
	
	public void adicionar(Aplicacao aplicacao) {
		this.manager.persist(aplicacao);
	}
	
	public Aplicacao guardar(Aplicacao aplicacao) {
		return this.manager.merge(aplicacao);
	}
	
	public void excluir(Aplicacao aplicacao) {
		this.manager.remove(aplicacao);
	}
 	
}
