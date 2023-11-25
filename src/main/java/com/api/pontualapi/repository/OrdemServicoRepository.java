package com.api.pontualapi.repository;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.model.Servico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
    Boolean existsOrdemServicoByCodigoIdentificador(String codigoIdentificador);

//    @Query("SELECT NEW com.api.pontualapi.dto.ServicoDTO(" +
//            "servico.id, servico.codigo, servico.tipo, servico.preco, servico.descricao) " +
//            "from Servico servico " +
//            "where (lower(servico.tipo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
//            "(lower(servico.codigo) like concat('%', lower(:filter), '%') or :filter is null ) or " +
//            "(lower(servico.descricao) like concat('%', lower(:filter), '%') or :filter is null )")
//    Page<OrdemServicoDTO> buscaTodasOrdensServicos(String filter, Pageable pageable);
}
