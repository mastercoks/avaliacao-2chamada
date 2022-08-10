package com.ifba.service;

import java.io.Serializable;

import com.ifba.model.Vacina;
import com.ifba.repository.Vacinas;

public class CadastroVacinas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Vacinas vacinas;
	
	public CadastroVacinas(Vacinas vacinas) {
		this.vacinas = vacinas;
	}
	
	public void salvar(Vacina vacina) throws NegocioException {		
		if (vacina.getNome() == null || vacina.getNome().isEmpty()) {
			throw new NegocioException("Nome é obrigatório.");
		}
		if (vacina.getDoses() == null) {
			throw new NegocioException("Número de doses é obrigatória.");
		}
		if (!(vacina.getDoses() instanceof Integer)) {
			throw new NegocioException("Número de doses precisa ser número.");
		}
		if (vacina.getDoses() <= 0) {
			throw new NegocioException("Número de doses precisa ser maior que 0.");
		}
		this.vacinas.guardar(vacina);
	}
	
	public void excluir(Vacina vacina) throws NegocioException {		
		this.vacinas.excluir(vacina);
	}

}
