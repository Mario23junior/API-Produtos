package com.project.produto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.produto.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

}
