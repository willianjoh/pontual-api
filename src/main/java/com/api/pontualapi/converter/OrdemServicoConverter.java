package com.api.pontualapi.converter;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.repository.ClienteRepository;
import com.api.pontualapi.utils.DateConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class OrdemServicoConverter {

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private ClienteRepository clienteRepository;

    public OrdemServico converterToEntity(OrdemServicoDTO servicoDTO) {
        OrdemServico servico = new OrdemServico();

        Cliente cliente = clienteRepository.getReferenceById(servicoDTO.getCliente().getId());

        servico.setId(servicoDTO.getId());
        servico.setCodigoIdentificador(servicoDTO.getCodigo());
        servico.setServico(servicoDTO.getServico());
        servico.setCliente(cliente);

        servico.setDataOrcamento(DateConverter.stringToLocalDate(servicoDTO.getDataOrcamento()));
        servico.setDataEntrega(DateConverter.stringToLocalDate(servicoDTO.getDataEntrega()));

        servico.setStatus(StatusOrdemServicoEnum.valueOf(servicoDTO.getStatus()));
        servico.setFormaPagamento(setValueFormaPagamento(servicoDTO.getFormaPagamento()));
        servico.setStatusPagamento(StatusPagamentoEnum.valueOf(servicoDTO.getStatusPagamento()));
        servico.setPreco(servicoDTO.getValorServico());
        servico.setQdtParcelas(servicoDTO.getQtdParcelas());
        servico.setPrecoParcela(servicoDTO.getValorParcela());
        servico.setObservacoes(servicoDTO.getObservacao());

        return servico;
    }

    public FormaPagamentoEnum setValueFormaPagamento(String label) {
        if (Objects.equals(label, "Dinheiro")) {
            return FormaPagamentoEnum.DINHEIRO;
        }
        if (Objects.equals(label, "Débito")) {
            return FormaPagamentoEnum.DEBITO;
        }
        if (Objects.equals(label, "Crédito")) {
            return FormaPagamentoEnum.CREDITO;
        }
        if (Objects.equals(label, "Pix")) {
            return FormaPagamentoEnum.PIX;
        }
        return null;
    }

    public OrdemServicoDTO converterDTO(OrdemServico ordemServico) {
        OrdemServicoDTO servicoDTO = new OrdemServicoDTO();
        servicoDTO.setId(ordemServico.getId());
        servicoDTO.setCodigo(ordemServico.getCodigoIdentificador());
        servicoDTO.setServico(ordemServico.getServico());
        servicoDTO.setCliente(clienteConverter.converterDTO(ordemServico.getCliente()));

        servicoDTO.setDataOrcamento(DateConverter.localDateToString(ordemServico.getDataOrcamento()));
        servicoDTO.setDataEntrega(DateConverter.localDateToString(ordemServico.getDataEntrega()));

        servicoDTO.setStatus(ordemServico.getStatus().getLabel());
        servicoDTO.setValorServico(ordemServico.getPreco());
        servicoDTO.setStatusPagamento(ordemServico.getStatusPagamento().getLabel());
        servicoDTO.setFormaPagamento(ordemServico.getFormaPagamento().getLabel());
        servicoDTO.setQtdParcelas(ordemServico.getQdtParcelas());
        servicoDTO.setValorParcela(ordemServico.getPrecoParcela());
        servicoDTO.setObservacao(ordemServico.getObservacoes());

        return servicoDTO;
    }
}
