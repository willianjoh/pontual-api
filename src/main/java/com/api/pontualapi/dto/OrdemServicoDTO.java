package com.api.pontualapi.dto;

import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
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
    private String codigoIdentificador;

    @NotBlank
    private ClienteDTO cliente;

    @NotBlank
    private ServicoDTO servico;

    @NotBlank
    private LocalDateTime dataOrcamento;

    @NotBlank
    private LocalDateTime dataEntrega;

    @NotBlank
    private BigDecimal preco;

    @NotBlank
    private StatusOrdemServicoEnum status;

    @NotBlank
    private StatusPagamentoEnum statusPagamento;

    @NotBlank
    private FormaPagamentoEnum formaPagamento;

    private Long qdtParcelas;

    private BigDecimal precoParcela;

    private String observacoes;

    public OrdemServicoDTO(Integer id, String codigoIdentificador, ClienteDTO cliente, ServicoDTO servico, LocalDateTime dataOrcamento, LocalDateTime dataEntrega, BigDecimal preco, StatusOrdemServicoEnum status, StatusPagamentoEnum statusPagamento, FormaPagamentoEnum formaPagamento, Long qdtParcelas, BigDecimal precoParcela, String observacoes) {
        this.id = id;
        this.codigoIdentificador = codigoIdentificador;
        this.cliente = cliente;
        this.servico = servico;
        this.dataOrcamento = dataOrcamento;
        this.dataEntrega = dataEntrega;
        this.preco = preco;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.formaPagamento = formaPagamento;
        this.qdtParcelas = qdtParcelas;
        this.precoParcela = precoParcela;
        this.observacoes = observacoes;
    }
}
