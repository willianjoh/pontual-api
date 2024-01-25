package com.api.pontualapi.repository;

import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.dto.ServicoListDTO;
import com.api.pontualapi.model.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
    Boolean existsServicoByCodigo(String codigo);

    @Query("SELECT NEW com.api.pontualapi.dto.ServicoDTO(" +
            "servico.id, servico.codigo, servico.tipo, servico.preco, servico.descricao) " +
            "from Servico servico " +
            "where (lower(servico.tipo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(servico.codigo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(servico.descricao) like concat('%', lower(:filter), '%') or :filter is null )")
    Page<ServicoDTO> buscaTodosServicos(String filter, Pageable pageable);

    @Query("SELECT NEW com.api.pontualapi.dto.ServicoListDTO(" +
            "servico.id, servico.codigo, servico.tipo) " +
            "from Servico servico")
    List<ServicoListDTO> listServicos();
}
