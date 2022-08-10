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
import com.ifba.repository.Aplicacoes;
import com.ifba.service.CadastroAplicacoes;
import com.ifba.service.NegocioException;
import com.ifba.util.JpaUtil;

@ManagedBean(name = "consulta_aplicacoes")
@ViewScoped
public class ConsultaAplicacoesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Aplicacao> aplicacoes;
	private Aplicacao aplicacaoSelecionada;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getManager();
		Aplicacoes aplicacoes = new Aplicacoes(manager);
		
		this.aplicacoes = aplicacoes.todos();
		
		manager.close();
	}
	
	public List<Aplicacao> getAplicacoes() {
		return this.aplicacoes;
	}
	
	public Aplicacao getAplicacaoSelecionada() {
		return this.aplicacaoSelecionada;
	}
	
	public void setAplicacaoSelecionada(Aplicacao aplicacaoSelecionada) {
		this.aplicacaoSelecionada = aplicacaoSelecionada;
	}
	
	public void excluir() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroAplicacoes cadastro = new CadastroAplicacoes(new Aplicacoes(manager));
			cadastro.excluir(this.aplicacaoSelecionada);
			
			context.addMessage(null, new FacesMessage("Aplicacao excluida com sucesso!"));
			
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
