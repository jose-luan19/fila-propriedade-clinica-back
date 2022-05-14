package br.com.clinicaback.controller.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.clinicaback.model.Cliente;

public class ClienteDTO {

	private Long id;
	private String nome;
	private Long prioridade;
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.prioridade = cliente.getPrioridade().getId();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Long prioridade) {
		this.prioridade = prioridade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public static List<ClienteDTO> converte(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
	
	
	
	
	
}
