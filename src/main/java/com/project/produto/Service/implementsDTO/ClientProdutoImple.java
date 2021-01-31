package com.project.produto.Service.implementsDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.produto.Model.Cliente;
import com.project.produto.Repository.ClienteRepository;
import com.project.produto.Service.ServiceDTO;
import com.project.produto.dto.Client_ProdutoDTO;

@Service
public class ClientProdutoImple implements ServiceDTO  {
    
	private ClienteRepository clienteRepository;
  	
	public ClientProdutoImple(ClienteRepository clienteRepository ) {
		 this.clienteRepository = clienteRepository;
 	}
	
	@Override
	public List<Client_ProdutoDTO> ObterDetalhes() {
 		return ((List<Cliente>) clienteRepository
 				.findAll())
 				.stream()
 				.map(this::convertToClientProdDTO)
 				                .collect(Collectors.toList());
	}	
	private Client_ProdutoDTO convertToClientProdDTO(Cliente cliente) {
		Client_ProdutoDTO clientProd = new Client_ProdutoDTO();
		clientProd.setCliId(cliente.getId());
		clientProd.setNome(cliente.getNome());
		clientProd.setEmail(cliente.getEmail());
		clientProd.setTelefone(cliente.getTelefone());
		return clientProd;
		
 	}
	
}
