package br.com.clinicaback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaback.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByOrderByPrioridadeIdAsc();

}
