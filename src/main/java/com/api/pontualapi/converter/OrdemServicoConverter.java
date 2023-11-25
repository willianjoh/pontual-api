package com.api.pontualapi.converter;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.model.Servico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class OrdemServicoConverter {

    @Autowired
    private ServicoConverter servicoConverter;

    @Autowired
    private ClienteConverter clienteConverter;

    public OrdemServico converterToEntity(OrdemServicoDTO servicoDTO) {
        OrdemServico servico = new OrdemServico();
        servico.setId(servicoDTO.getId());
        servico.setCodigoIdentificador(servicoDTO.getCodigoIdentificador());
        servico.setServico(servicoConverter.converterToEntity(servicoDTO.getServico()));
        servico.setCliente(clienteConverter.converterToEntity(servicoDTO.getCliente()));
        servico.setDataOrcamento(servicoDTO.getDataOrcamento());
        servico.setDataEntrega(servicoDTO.getDataEntrega());
        servico.setStatus(servicoDTO.getStatus());
        servico.setPreco(servicoDTO.getPreco());
        servico.setFormaPagamento(servicoDTO.getFormaPagamento());
        servico.setQdtParcelas(servicoDTO.getQdtParcelas());
        servico.setPrecoParcela(servicoDTO.getPrecoParcela());
        servico.setObservacoes(servicoDTO.getObservacoes());
        return servico;
    }

    public OrdemServicoDTO converterDTO(OrdemServico ordemServico){
        OrdemServicoDTO servicoDTO = new OrdemServicoDTO();
        servicoDTO.setId(ordemServico.getId());
        servicoDTO.setCodigoIdentificador(ordemServico.getCodigoIdentificador());
        servicoDTO.setServico(servicoConverter.converterDTO(ordemServico.getServico()));
        servicoDTO.setCliente(clienteConverter.converterDTO(ordemServico.getCliente()));
        servicoDTO.setDataOrcamento(ordemServico.getDataOrcamento());
        servicoDTO.setDataEntrega(ordemServico.getDataEntrega());
        servicoDTO.setStatus(ordemServico.getStatus());
        servicoDTO.setPreco(ordemServico.getPreco());
        servicoDTO.setFormaPagamento(ordemServico.getFormaPagamento());
        servicoDTO.setQdtParcelas(ordemServico.getQdtParcelas());
        servicoDTO.setPrecoParcela(ordemServico.getPrecoParcela());
        servicoDTO.setObservacoes(ordemServico.getObservacoes());
        return servicoDTO;
    }

}
