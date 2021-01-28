package com.project.produto.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.produto.Model.Produto;
import com.project.produto.Resitory.ProdutoRepository;

@RestController
@RequestMapping("/api/gerence/product")
public class ControllerProduto {
    
	private ProdutoRepository produtoRepository;
	
	public ControllerProduto(ProdutoRepository produtoRepository) {
		 this.produtoRepository = produtoRepository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvar(@RequestBody Produto produto) { 
		return produtoRepository.save(produto);
	}
	

}












