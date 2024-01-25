package com.api.pontualapi.service;

import com.api.pontualapi.converter.ClienteConverter;
import com.api.pontualapi.converter.OrdemServicoConverter;
import com.api.pontualapi.converter.ServicoConverter;
import com.api.pontualapi.dto.ClienteDTO;
import com.api.pontualapi.dto.ClienteListDTO;
import com.api.pontualapi.dto.FilterDTO;
import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.repository.ClienteRepository;
import com.api.pontualapi.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private OrdemServicoConverter ordemServicoConverter;

    @Autowired
    private ServicoConverter servicoConverter;

    @Autowired
    private ClienteConverter clienteConverter;


    public Page<OrdemServicoDTO> findAllPage(Pageable pageable, FilterDTO filtro) {
        return ordemServicoRepository.buscarTodos(filtro.getFilter(), pageable);
    }

    public OrdemServicoDTO save(OrdemServicoDTO ordemServicoDTO) {
        if (ordemServicoExiste(ordemServicoDTO.getCodigoIdentificador())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ordem de Serviço: " + ordemServicoDTO.getCodigoIdentificador() + " já cadastrada na base.");
        }
        return ordemServicoConverter.converterDTO(ordemServicoRepository.save(ordemServicoConverter.converterToEntity(ordemServicoDTO)));
    }

    public OrdemServicoDTO update(OrdemServicoDTO ordemServicoDTO) {
        OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoDTO.getId()).orElseThrow(null);
        if (Objects.isNull(ordemServico)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Serviço inexistente.");
        }

        ordemServico.setCodigoIdentificador(ordemServicoDTO.getCodigoIdentificador());
        ordemServico.setServico(servicoConverter.converterToEntity(ordemServicoDTO.getServico()));
        ordemServico.setCliente(clienteConverter.converterToEntity(ordemServicoDTO.getCliente()));
        ordemServico.setDataOrcamento(ordemServicoDTO.getDataOrcamento());
        ordemServico.setDataEntrega(ordemServicoDTO.getDataEntrega());
        ordemServico.setStatus(ordemServicoDTO.getStatus());
        ordemServico.setPreco(ordemServicoDTO.getPreco());
        ordemServico.setFormaPagamento(ordemServicoDTO.getFormaPagamento());
        ordemServico.setQdtParcelas(ordemServicoDTO.getQdtParcelas());
        ordemServico.setPrecoParcela(ordemServicoDTO.getPrecoParcela());
        ordemServico.setObservacoes(ordemServicoDTO.getObservacoes());

        return ordemServicoConverter.converterDTO(ordemServicoRepository.save(ordemServico));
    }

   private Boolean ordemServicoExiste(String codigo) {
        return ordemServicoRepository.existsOrdemServicoByCodigoIdentificador(codigo);
    }

    public void delete(Integer id) {
        OrdemServico ordemServico = ordemServicoRepository.findById(id).orElseThrow(null);
        if (!Objects.isNull(ordemServico)) {
            ordemServicoRepository.delete(ordemServico);
        }
    }

    public void deleteAll(List<Integer> ids) {
        ordemServicoRepository.deleteAllById(ids);
    }
}
