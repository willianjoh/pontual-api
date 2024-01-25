package com.api.pontualapi.service;

import com.api.pontualapi.converter.ServicoConverter;
import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.dto.ServicoListDTO;
import com.api.pontualapi.model.Servico;
import com.api.pontualapi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoConverter servicoConverter;

    public Page<ServicoDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return servicoRepository.buscaTodosServicos(filtro.getFilter(), pageable);
    }

    public ServicoDTO save(ServicoDTO servicoDTO) {
        if (servicoExist(servicoDTO.getCodigo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Servico já cadastrado na base.");
        }
        return servicoConverter.converterDTO(servicoRepository.save(servicoConverter.converterToEntity(servicoDTO)));
    }

    public ServicoDTO update(ServicoDTO servicoDTO) {
        Servico servico = servicoRepository.findById(servicoDTO.getId()).orElseThrow(null);
        if (Objects.isNull(servico)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço inexistente.");
        }

        servico.setCodigo(servicoDTO.getCodigo());
        servico.setTipo(servicoDTO.getTipo());
        servico.setDescricao(servicoDTO.getDescricao());
        servico.setPreco(servicoDTO.getPreco());

        return servicoConverter.converterDTO(servicoRepository.save(servico));
    }

    private Boolean servicoExist(String codigo) {
        return servicoRepository.existsServicoByCodigo(codigo);
    }

    public void delete(Integer id) {
        Servico servico = servicoRepository.findById(id).orElseThrow(null);
        if (!Objects.isNull(servico)) {
            servicoRepository.delete(servico);
        }
    }

    public void deleteAll(List<Integer> ids) {
            servicoRepository.deleteAllById(ids);
    }

    public List<ServicoListDTO> listServicos() {
        return servicoRepository.listServicos();
    }
}
