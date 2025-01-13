package com.api.pontualapi.model;

import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String id;

    @Column(length = 15, nullable = false)
    private String codigoIdentificador;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @NotNull
    @Column(nullable = false, length = 255)
    private String servico;

    @Column(nullable = false)
    private LocalDate dataOrcamento;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    @Column(nullable = false, scale = 2, precision = 19)
    private BigDecimal preco;

    @Column(nullable = false)
    private StatusOrdemServicoEnum status;

    @Column(nullable = false)
    private StatusPagamentoEnum statusPagamento;

    @Column(nullable = false)
    private FormaPagamentoEnum formaPagamento;

    @Column()
    private Long qdtParcelas;

    @Column(scale = 2, precision = 19)
    private BigDecimal precoParcela;

    @Column(length = 255)
    private String observacoes;
}
