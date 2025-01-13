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

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Boolean existsClienteByCpf(String cpf);

    @Query("SELECT NEW com.api.pontualapi.dto.ClienteDTO(" +
            "cliente.id, cliente.nome, cliente.cpf, cliente.email, cliente.celular) " +
            "from Cliente cliente " +
            "where (lower(cliente.nome) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.cpf) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.email) like concat('%', lower(:filter), '%') or :filter is null ) or " +
            "(lower(cliente.celular) like concat('%', lower(:filter), '%') or :filter is null)")
    Page<ClienteDTO> buscaTodosClientes(@Param("filter") String filter, Pageable pageable);

    @Query("SELECT NEW com.api.pontualapi.dto.ClienteListDTO(" +
            "cliente.id, cliente.nome) " +
            "from Cliente cliente")
    List<ClienteListDTO> listClientes();

}
