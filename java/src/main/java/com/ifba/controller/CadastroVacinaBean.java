package com.ifba.controller;

import java.io.Serializable;

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

@ManagedBean(name = "cadastro_vacina")
@ViewScoped
public class CadastroVacinaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Vacina vacina = new Vacina();
	
	public void prepararCadastro() {
		if (this.vacina == null) {
			this.vacina = new Vacina();
		}
	}
	
	public void salvar() {
		EntityManager manager = JpaUtil.getManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();
			CadastroVacinas cadastro = new CadastroVacinas(new Vacinas(manager));
			cadastro.salvar(this.vacina);
			
			context.addMessage(null, new FacesMessage("Vacina salva com sucesso!"));
			
			trx.commit();
			
			this.vacina = new Vacina();
		} catch (NegocioException e) {
			trx.rollback();
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	public Vacina getVacina() {
		return this.vacina;
	}
	
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
}
