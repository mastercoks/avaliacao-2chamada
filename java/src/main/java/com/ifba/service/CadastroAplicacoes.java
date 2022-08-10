package com.ifba.service;

import java.io.Serializable;
import java.util.Date;

import com.ifba.model.Aplicacao;
import com.ifba.repository.Aplicacoes;

public class CadastroAplicacoes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Aplicacoes aplicacoes;
	 
	public CadastroAplicacoes(Aplicacoes aplicacoes) {
		this.aplicacoes = aplicacoes;
	}
	
	public void salvar(Aplicacao aplicacao) throws NegocioException {		
		if (aplicacao.getPessoa() == null) {
			throw new NegocioException("Pessoa é obrigatória.");
		}	
		if (aplicacao.getVacina() == null) {
			throw new NegocioException("Vacina é obrigatória.");
		}
		if (aplicacao.getNumDose() == null) {
			throw new NegocioException("Número de doses é obrigatória.");
		}
		if (!(aplicacao.getNumDose() instanceof Integer)) {
			throw new NegocioException("Número de doses precisa ser número.");
		}
		if (aplicacao.getNumDose() <= 0) {
			throw new NegocioException("Número de doses precisa ser maior que 0.");
		}
		if (aplicacao.getDataHora() == null) {
			throw new NegocioException("Data da aplicação é obrigatório.");
		}
		if (!(aplicacao.getDataHora() instanceof Date)) {
			throw new NegocioException("Data da aplicação precisa ser uma data.");
		}
		if (aplicacao.getDataHora().after(new Date())) {
			throw new NegocioException("Data da aplicação não pode ser uma data futura.");
		}
		if (aplicacao.getNumDose() > aplicacao.getVacina().getDoses()) {
			throw new NegocioException("Número de Dose da aplicacao acima do número de doses da vacina.");			
		}
		if (!(aplicacoes.validar(aplicacao))) {
			throw new NegocioException("Aplicação já existente.");
		}
		this.aplicacoes.guardar(aplicacao);
	}
	
	public void excluir(Aplicacao aplicacao) throws NegocioException {
		aplicacao = this.aplicacoes.porId(aplicacao.getId());
		
		this.aplicacoes.excluir(aplicacao);
	}

}
