package com.ifba.service;

import java.io.Serializable;
import java.util.Date;

import com.ifba.model.Pessoa;
import com.ifba.repository.Pessoas;

public class CadastroPessoas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Pessoas pessoas;
	
	public CadastroPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
	public void salvar(Pessoa pessoa) throws NegocioException {		
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			throw new NegocioException("Nome é obrigatório.");
		}
		if (pessoa.getNascimento() == null) {
			throw new NegocioException("Data de nascimento é obrigatório.");
		}
		if (!(pessoa.getNascimento() instanceof Date)) {
			throw new NegocioException("Data de nascimento precisa ser uma data.");
		}
		if (pessoa.getNascimento().after(new Date())) {
			throw new NegocioException("Data de nascimento não pode ser uma data futura.");
		}
		this.pessoas.guardar(pessoa);
	}
	
	public void excluir(Pessoa pessoa) throws NegocioException {
		pessoa = this.pessoas.porId(pessoa.getId());
//		if (vacina)
		
		this.pessoas.excluir(pessoa);
	}

}
