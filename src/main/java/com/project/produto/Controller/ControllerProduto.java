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
	
	@GetMapping("/{id}")
	public Produto obterProdutoPorId(@PathVariable Integer id) {
		return produtoRepository
				     .findById(id)
				     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Produto não encontrado"));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProd(@PathVariable Integer id, @RequestBody Produto produto) {
		 produtoRepository.findById(id)
		                  .map(prodBody -> {
		                	  produto.setId(prodBody.getId());
		                	  produtoRepository.save(produto);
		                	  return prodBody;
		                  }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado"));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCli(@PathVariable Integer id) {
		produtoRepository.findById(id)
		                 .map(deletecli -> {
		                	  produtoRepository.delete(deletecli);
		                	  return deletecli;
		                 }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT ,"Produto não encontrado para deletação"));
 	}
	
	@GetMapping
	public List<Produto> buscarTodos(Produto produtoAll) {
		ExampleMatcher matcher = ExampleMatcher
				              .matching()
				              .withIgnoreCase()
				              .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Produto> example = Example.of(produtoAll, matcher);
		return produtoRepository.findAll(example);
	}
	
	
}












