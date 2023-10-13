package com.api.pontualapi.converter;

import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ServicoConverter {

    public Servico converterToEntity(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        servico.setCodigo(servicoDTO.getCodigo());
        servico.setTipo(servicoDTO.getTipo());
        servico.setPreco(servicoDTO.getPreco());
        servico.setDescricao(servicoDTO.getDescricao());
        return servico;
    }

    public ServicoDTO converterDTO(Servico servico){
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setId(servico.getId());
        servicoDTO.setCodigo(servico.getCodigo());
        servicoDTO.setTipo(servico.getTipo());
        servicoDTO.setPreco(servico.getPreco());
        servicoDTO.setDescricao(servico.getDescricao());
        return servicoDTO;
    }

}
