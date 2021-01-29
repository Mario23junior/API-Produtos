package com.project.produto.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.produto.DTO.ClienteProdutoDTO;

@Service
public interface ClientPedidoService {
    
	List<ClienteProdutoDTO> obterDetalhes();
}
