package com.api.pontualapi.repository;

import com.api.pontualapi.dto.ProdutoDTO;
import com.api.pontualapi.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {
    Boolean existsProdutoByCodigo(String codigo);

    @Query("SELECT NEW com.api.pontualapi.dto.ProdutoDTO(" +
            "produto.id, produto.codigo, produto.nome, produto.modelo, produto.descricao, produto.valor) " +
            "from Produto produto " +
            "where (lower(produto.codigo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(produto.nome) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(produto.modelo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(produto.descricao) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(produto.valor) like concat('%', lower(:filter), '%') or :filter is null )")
    Page<ProdutoDTO> buscaTodosProdutos(@Param("filter") String filter, Pageable pageable);
}
