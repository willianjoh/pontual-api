package com.api.pontualapi.converter;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ClienteConverter {

    public Cliente converterToEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setTelefone(clienteDTO.getContato());
        cliente.setTelefoneFixo(clienteDTO.getContatoFixo() != null ? clienteDTO.getContatoFixo() : null);
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        return cliente;
    }

    public ClienteDTO converterDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setSobrenome(cliente.getSobrenome());
        clienteDTO.setCpf(cliente.getCpf());
        clienteDTO.setContato(cliente.getTelefone());
        clienteDTO.setContatoFixo(cliente.getTelefoneFixo() != null ? cliente.getTelefoneFixo() : null);
        clienteDTO.setEmail(cliente.getEmail());
        return clienteDTO;
    }
}
