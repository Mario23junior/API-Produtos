package com.project.produto.Controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
import com.project.produto.Repository.ClienteRepository;
import com.project.produto.Service.ServiceDTO;
import com.project.produto.dto.Client_ProdutoDTO;

@RestController
@RequestMapping("/api/gerence/client")
public class ClienteController {
     
	 private ClienteRepository clienteRepository;
	 private ServiceDTO serviceRepo;
 	 
	 public ClienteController(ClienteRepository clienteRepository, ServiceDTO serviceRepo) {
		 this.clienteRepository = clienteRepository;
		 this.serviceRepo = serviceRepo;
  	}
	 
	 @GetMapping("/log")
	 public List<Client_ProdutoDTO> datasAllClientProd() {
		 List<Client_ProdutoDTO> produtoCliLog = serviceRepo.ObterDetalhes();
		 return produtoCliLog;
	 }
	 
	
	@GetMapping("/{id}")
	public Cliente obterPorId(@PathVariable Integer id) {
		 return clienteRepository
				         .findById(id)
				         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado na base"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCli(@RequestBody Cliente cliente) {
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
	
	
	@GetMapping
	public List<Cliente> BuscarTodos(Cliente clienteAll) {
		ExampleMatcher matcher = ExampleMatcher
				           .matching()
				           .withIgnoreCase()
				           .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		 Example<Cliente> listar = Example.of(clienteAll, matcher);
		return clienteRepository.findAll(listar);
	}
 
}
