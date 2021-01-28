package com.project.produto.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.produto.Model.Cliente;
import com.project.produto.Resitory.ClienteRepository;

@RestController
@RequestMapping("/api/gerence/product")
public class ClienteController {
     
	 private ClienteRepository clienteRepository;
	 
	 public ClienteController(ClienteRepository clienteRepository) {
		 this.clienteRepository = clienteRepository;
 	}
	 
	@GetMapping("/{id}")
	public Cliente obterPorId(@PathVariable Integer id) {
		 return clienteRepository
				         .findById(id)
				         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado na base"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarDados(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletaCli(@PathVariable Integer id) {
		clienteRepository.findById(id)
		                 .map(deleteCliente -> {
		                	 clienteRepository.delete(deleteCliente);
		                	 return deleteCliente;
		                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado para exclusao"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCli(@PathVariable Integer id ,@RequestBody Cliente cliente) {
		clienteRepository.findById(id)
		                 .map(clienteBody -> {
		                	 cliente.setId(clienteBody.getId());
		                	 clienteRepository.save(cliente);
		                	 return clienteBody;
		                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado na base"));
	}
 	
	
	
	 
	
	
	
	
}
