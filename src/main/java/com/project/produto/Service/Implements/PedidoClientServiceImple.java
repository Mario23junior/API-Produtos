package com.project.produto.Service.Implements;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.produto.DTO.ClienteProdutoDTO;
import com.project.produto.Model.Cliente;
import com.project.produto.Model.Produto;
import com.project.produto.Resitory.ClienteRepository;
import com.project.produto.Service.ClientPedidoService;

@Service
public class PedidoClientServiceImple implements ClientPedidoService{
    
	private ClienteRepository clienteRepository;
	
	public PedidoClientServiceImple(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
 	}
	
	@Override
	public List<ClienteProdutoDTO> obterDetalhes() {
 		return ((List<Cliente>) 
 			 clienteRepository
 				   .findAll())
 				   .stream()
 				   .map(this::ConvertToClientProdDTO)
 				                 .collect(Collectors.toList());
	}
	
	
	private ClienteProdutoDTO ConvertToClientProdDTO(Cliente cliente) {
	   
		 ClienteProdutoDTO clientProdDTO = new ClienteProdutoDTO();
		 clientProdDTO.setClientId(cliente.getId());
		 clientProdDTO.setNome(cliente.getNome());
		 clientProdDTO.setEmail(cliente.getEmail());
		 clientProdDTO.setTelefone(cliente.getTelefone());
		 
		 Produto produto = cliente.getProdutos();
		 clientProdDTO.setNomeProd(produto.getNome());
		 clientProdDTO.setDescricao(produto.getDescricao());
		 clientProdDTO.setPreco(produto.getPreco());
		 clientProdDTO.setVendido(produto.isVendido());
		 clientProdDTO.setQuantidade(produto.getQuantidade());
		 return clientProdDTO;
		 
	}
}

















