package com.api.pontualapi.service;

import com.api.pontualapi.converter.ClienteConverter;
import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteConverter clienteConverter;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(ClienteDTO clienteDTO) {
        if (clienteExist(clienteDTO.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado na base.");
        }
        return clienteRepository.save(clienteConverter.converterToEntity(clienteDTO));
    }

    private Boolean clienteExist(String cpf) {
        return clienteRepository.existsClienteByCpf(cpf);
    }
}
