package br.com.clinicaback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Prioridade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricaoPrioridade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoPrioridade() {
		return descricaoPrioridade;
	}
	public void setDescricaoPrioridade(String descricaoPrioridade) {
		this.descricaoPrioridade = descricaoPrioridade;
	}
	public Prioridade(String descricaoPrioridade) {
		this.descricaoPrioridade = descricaoPrioridade;
	}
	public Prioridade() {
	}
	
	
	
	
}
