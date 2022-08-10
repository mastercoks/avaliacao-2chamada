package com.ifba.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ifba.model.Pessoa;
import com.ifba.repository.Pessoas;
import com.ifba.service.CadastroPessoas;
import com.ifba.service.NegocioException;
import com.ifba.util.JpaUtil;

@ManagedBean(name = "consulta_pessoas")
@ViewScoped
public class ConsultaPessoasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getManager();
		Pessoas pessoas = new Pessoas(manager);
		
		this.pessoas = pessoas.todos();
		
		manager.close();
	}
	
	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}
	
	public Pessoa getPessoaSelecionada() {
		return this.pessoaSelecionada;
	}
	
	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	
	public void excluir() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroPessoas cadastro = new CadastroPessoas(new Pessoas(manager));
			cadastro.excluir(this.pessoaSelecionada);
			
			context.addMessage(null, new FacesMessage("Pessoa excluida com sucesso!"));
			
			trx.commit();
			
			this.consultar();
		} catch (NegocioException e) {
			trx.rollback();
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}		
	}
	
}
