package com.api.pontualapi.service;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.enums.TipoOperacaoEnum;
import com.api.pontualapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository  clienteRepository;

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAllClientes();
    }
}
