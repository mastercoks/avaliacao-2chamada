package com.ifba.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ifba.model.Vacina;
import com.ifba.repository.Vacinas;
import com.ifba.service.CadastroVacinas;
import com.ifba.service.NegocioException;
import com.ifba.util.JpaUtil;

@ManagedBean(name = "consulta_vacinas")
@ViewScoped
public class ConsultaVacinasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Vacina> vacinas;
	private Vacina vacinaSelecionada;
	
	public void consultar() {
		EntityManager manager = JpaUtil.getManager();
		Vacinas vacinas = new Vacinas(manager);
		
		this.vacinas = vacinas.todos();
		
		manager.close();
	}
	
	public List<Vacina> getVacinas() {
		return this.vacinas;
	}
	
	public Vacina getVacinaSelecionada() {
		return this.vacinaSelecionada;
	}
	
	public void setVacinaSelecionada(Vacina vacinaSelecionada) {
		this.vacinaSelecionada = vacinaSelecionada;
	}
	
	public void excluir() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroVacinas cadastro = new CadastroVacinas(new Vacinas(manager));
			cadastro.excluir(this.vacinaSelecionada);
			
			context.addMessage(null, new FacesMessage("Vacina excluida com sucesso!"));
			
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
