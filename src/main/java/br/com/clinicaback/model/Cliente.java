package br.com.clinicaback.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToOne
	@JoinColumn(name = "prioridade_id", referencedColumnName = "id")
	private Prioridade prioridade;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id; 
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Prioridade getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Cliente() {
	}
	public Cliente(String nome, Prioridade prioridade) {
		this.nome = nome;
		this.prioridade = prioridade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataCriacao, id, nome, prioridade);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(prioridade, other.prioridade);
	}
	
	
	
}
