package br.com.clinicaback.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.clinicaback.controller.DTO.ClienteDTO;
import br.com.clinicaback.controller.form.CLientForm;
import br.com.clinicaback.model.Cliente;
import br.com.clinicaback.repository.ClienteRepository;
import br.com.clinicaback.repository.PrioridadeRepository;

@RestController
@RequestMapping("/clientes")

public class ClientesController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PrioridadeRepository prioridadeRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<ClienteDTO> lista() {

			List<Cliente> clientes = clienteRepository.findByOrderByPrioridadeIdAsc();
			return ClienteDTO.converte(clientes);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/novo")
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid CLientForm form, UriComponentsBuilder uriBuilder) {
		Cliente novoCliente = form.converter(prioridadeRepository);
		clienteRepository.save(novoCliente);

		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(novoCliente));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
