package br.com.clinicaback.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clinicaback.model.Cliente;
import br.com.clinicaback.model.Prioridade;
import br.com.clinicaback.repository.PrioridadeRepository;

public class CLientForm {

	@NotNull @NotEmpty 
	private String nome;
	
	@NotNull @NotEmpty 
	private String descricaoPrioridade;

	public Cliente converter(PrioridadeRepository prioridadeRepository) {
		Prioridade prioridade = prioridadeRepository.findByDescricaoPrioridade(descricaoPrioridade);
		return new Cliente(nome, prioridade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoPrioridade() {
		return descricaoPrioridade;
	}

	public void setDescricaoPrioridade(String descricaoPrioridade) {
		this.descricaoPrioridade = descricaoPrioridade;
	}

	
}
