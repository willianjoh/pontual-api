package com.api.pontualapi.service;

import com.api.pontualapi.converter.ClienteConverter;
import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteConverter clienteConverter;

    public Page<ClienteDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return clienteRepository.buscaTodosClientes(filtro.getFilter(), pageable);
    }

    public List<ClienteListDTO> listClientesOrdemServico() {
        return clienteRepository.listClientes();
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        if (clienteExist(clienteDTO.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado na base.");
        }
        return clienteConverter.converterDTO(clienteRepository.save(clienteConverter.converterToEntity(clienteDTO)));
    }

    public ClienteDTO update(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(clienteDTO.getId()).orElseThrow(null);
        if (Objects.isNull(cliente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente inexistente.");
        }

        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setFixo(clienteDTO.getFixo());

        return clienteConverter.converterDTO(clienteRepository.save(cliente));
    }

    private Boolean clienteExist(String cpf) {
        return clienteRepository.existsClienteByCpf(cpf);
    }

    public void delete(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(null);
        if (!Objects.isNull(cliente)) {
            clienteRepository.delete(cliente);
        }
    }

    public void deleteAll(List<Integer> ids) {
        clienteRepository.deleteAllById(ids);
    }
}
