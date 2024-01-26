package com.api.pontualapi.dto;

import com.api.pontualapi.converter.ClienteConverter;
import com.api.pontualapi.converter.ServicoConverter;
import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
import com.api.pontualapi.model.Cliente;
import com.api.pontualapi.model.Servico;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class OrdemServicoDTO {

    private Integer id;

    @NotBlank
    private String codigo;

    @NotBlank
    private ClienteDTO cliente;

    @NotBlank
    private ServicoDTO tipoServico;

    @NotBlank
    private LocalDateTime dataOrcamento;

    @NotBlank
    private LocalDateTime dataEntrega;

    @NotBlank
    private BigDecimal valorServico;

    @NotBlank
    private String status;

    @NotBlank
    private String statusPagamento;

    @NotBlank
    private String formaPagamento;

    private Long qtdParcelas;

    private BigDecimal valorParcela;

    private String observacao;

    public OrdemServicoDTO(Integer id, String codigoIdentificador, Cliente cliente, Servico servico, LocalDateTime dataOrcamento, LocalDateTime dataEntrega, BigDecimal valor, StatusOrdemServicoEnum statusServico, StatusPagamentoEnum statusPagamento, FormaPagamentoEnum formaPagamento, Long qtdParcelas, BigDecimal valorParcela, String observacao) {
        this.id = id;
        this.codigo = codigoIdentificador;
        this.cliente = new ClienteConverter().converterDTO(cliente);
        this.tipoServico = new ServicoConverter().converterDTO(servico);
        this.dataOrcamento = dataOrcamento;
        this.dataEntrega = dataEntrega;
        this.valorServico = valor;
        this.status = statusServico.getLabel();
        this.statusPagamento = statusPagamento.getLabel();
        this.formaPagamento = formaPagamento.getLabel();
        this.qtdParcelas = qtdParcelas;
        this.valorParcela = valorParcela;
        this.observacao = observacao;
    }
}
