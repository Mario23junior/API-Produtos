package com.project.produto.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 40)
	@NotEmpty(message = "{campo.nome.Produto.obrigatorio}")
	private String nome;
	
	@NotEmpty(message = "{campo.descricao.Produto.obrigatorio}")
	private String descricao;
	
	@NotEmpty(message = "{campo.preco.Produto.obrigatorio}")
	private BigDecimal preco;
	
	@NotEmpty(message = "{campo.vendido.Produto.obrigatorio}")
	private boolean vendido;
	
	@NotEmpty(message = "{campo.quantidade.Produto.obrigatorio}")
	private Integer quantidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
