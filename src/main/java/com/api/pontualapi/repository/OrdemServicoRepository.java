package com.api.pontualapi.repository;

import com.api.pontualapi.dto.ClienteDTO;
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

    @Query("SELECT NEW com.api.pontualapi.dto.OrdemServicoDTO(" +
            "ordemServico.id, ordemServico.codigoIdentificador,ordemServico.cliente, ordemServico.servico, ordemServico.dataOrcamento, ordemServico.dataEntrega," +
            " ordemServico.preco, ordemServico.status, ordemServico.statusPagamento, ordemServico.formaPagamento, ordemServico.qdtParcelas, ordemServico.precoParcela, ordemServico.observacoes) " +
            "from OrdemServico ordemServico " +
            "where (lower(ordemServico.codigoIdentificador) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(ordemServico.servico.descricao) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(ordemServico.dataOrcamento) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(ordemServico.dataEntrega) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(ordemServico.status) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(ordemServico.cliente.nome) like concat('%', lower(:filter), '%') or :filter is null )")
    Page<OrdemServicoDTO> buscarTodos(String filter, Pageable pageable);
}
