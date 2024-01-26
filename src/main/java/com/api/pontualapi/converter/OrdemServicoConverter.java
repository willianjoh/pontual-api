package com.api.pontualapi.converter;

import com.api.pontualapi.dto.OrdemServicoDTO;
import com.api.pontualapi.dto.ServicoDTO;
import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.OrdemServico;
import com.api.pontualapi.model.Servico;
import com.api.pontualapi.repository.ClienteRepository;
import com.api.pontualapi.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.flow.SwitchCase;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Service
public class OrdemServicoConverter {

    @Autowired
    private ServicoConverter servicoConverter;

    @Autowired
    private ClienteConverter clienteConverter;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    ServicoRepository servicoRepository;

    public OrdemServico converterToEntity(OrdemServicoDTO servicoDTO) {
        OrdemServico servico = new OrdemServico();
        Cliente cliente = clienteRepository.getReferenceById(servicoDTO.getCliente().getId());
        Servico tipoServico = servicoRepository.getReferenceById(servicoDTO.getTipoServico().getId());

        servico.setId(servicoDTO.getId());
        servico.setCodigoIdentificador(servicoDTO.getCodigo());
        servico.setServico(tipoServico);
        servico.setCliente(cliente);
        servico.setDataOrcamento(servicoDTO.getDataOrcamento());
        servico.setDataEntrega(servicoDTO.getDataEntrega());
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
        servicoDTO.setTipoServico(servicoConverter.converterDTO(ordemServico.getServico()));
        servicoDTO.setCliente(clienteConverter.converterDTO(ordemServico.getCliente()));
        servicoDTO.setDataOrcamento(ordemServico.getDataOrcamento());
        servicoDTO.setDataEntrega(ordemServico.getDataEntrega());
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
