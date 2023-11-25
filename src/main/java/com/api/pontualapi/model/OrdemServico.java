package com.api.pontualapi.model;

import com.api.pontualapi.enums.FormaPagamentoEnum;
import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import com.api.pontualapi.enums.StatusPagamentoEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ordem_servico")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OrdemServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String codigoIdentificador;

    @OneToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne()
    @JoinColumn(name = "servico_id", referencedColumnName = "id")
    private Servico servico;

    @Column(nullable = false)
    private LocalDateTime dataOrcamento;

    @Column(nullable = false)
    private LocalDateTime dataEntrega;

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
