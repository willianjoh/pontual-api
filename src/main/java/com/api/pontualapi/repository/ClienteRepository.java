package com.api.pontualapi.repository;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findClienteByCpf(String cpf);

    Boolean existsClienteByCpf(String cpf);

}
