package com.api.pontualapi.repository;

import com.api.pontualapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {
}
