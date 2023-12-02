package com.api.pontualapi.repository;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Boolean existsClienteByCpf(String cpf);

    @Query("SELECT NEW com.api.pontualapi.dto.ClienteDTO(" +
            "cliente.id, cliente.nome, cliente.sobrenome, cliente.cpf, cliente.email, cliente.celular, cliente.fixo) " +
            "from Cliente cliente " +
            "where (lower(cliente.nome) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.sobrenome) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.cpf) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.email) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.celular) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.fixo) like concat('%', lower(:filter), '%') or :filter is null )")
    Page<ClienteDTO> buscaTodosClientes(@Param("filter") String filter, Pageable pageable);

    @Query("SELECT NEW com.api.pontualapi.dto.ClienteListDTO(" +
            "cliente.id, cliente.nome, cliente.sobrenome) " +
            "from Cliente cliente")
    List<ClienteListDTO> listClientes();

}
