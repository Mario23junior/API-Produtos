package com.project.produto.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 
	
}
