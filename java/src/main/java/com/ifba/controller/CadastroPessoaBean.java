package com.ifba.controller;

import java.io.Serializable;

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

@ManagedBean(name = "cadastro_pessoa")
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	
	public void prepararCadastro() {
		if (this.pessoa == null) {
			this.pessoa = new Pessoa();
		}
	}
	
	public void salvar() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroPessoas cadastro = new CadastroPessoas(new Pessoas(manager));
			cadastro.salvar(this.pessoa);
			
			context.addMessage(null, new FacesMessage("Pessoa salva com sucesso!"));
			
			trx.commit();
			
			this.pessoa = new Pessoa();
		} catch (NegocioException e) {
			trx.rollback();
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public void setPessoa(Pessoa vacina) {
		this.pessoa = vacina;
	}
	
}
