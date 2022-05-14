package br.com.clinicaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaback.model.Prioridade;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Long>{

	Prioridade findByDescricaoPrioridade(String descricaoPrioridade);
}
