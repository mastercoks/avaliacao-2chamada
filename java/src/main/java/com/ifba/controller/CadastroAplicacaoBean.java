package com.ifba.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ifba.model.Aplicacao;
import com.ifba.model.Pessoa;
import com.ifba.model.Vacina;
import com.ifba.repository.Aplicacoes;
import com.ifba.repository.Pessoas;
import com.ifba.repository.Vacinas;
import com.ifba.service.CadastroAplicacoes;
import com.ifba.service.NegocioException;
import com.ifba.util.JpaUtil;

@ManagedBean(name = "cadastro_aplicacao")
@ViewScoped
public class CadastroAplicacaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Aplicacao aplicacao = new Aplicacao();
	private List<Pessoa> pessoas;
	private List<Vacina> vacinas;
	
	public void prepararCadastro() {
		if (this.aplicacao == null) {			
			this.aplicacao = new Aplicacao();
		}
		EntityManager manager = JpaUtil.getManager();
		try {
			Pessoas pessoas = new Pessoas(manager);
			Vacinas vacinas = new Vacinas(manager);
			this.pessoas = pessoas.todos();
			this.vacinas = vacinas.todos();			
		} finally {
			manager.close();
		}
	}
	
	public void salvar() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroAplicacoes cadastro = new CadastroAplicacoes(new Aplicacoes(manager));
			cadastro.salvar(this.aplicacao);
			
			context.addMessage(null, new FacesMessage("Aplicacao salva com sucesso!"));
			
			trx.commit();
			
			this.aplicacao = new Aplicacao();
		} catch (NegocioException e) {
			trx.rollback();
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	public Aplicacao getAplicacao() {
		return this.aplicacao;
	}
	
	public void setAplicacao(Aplicacao vacina) {
		this.aplicacao = vacina;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	
}
