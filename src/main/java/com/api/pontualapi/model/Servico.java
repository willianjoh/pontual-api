package com.api.pontualapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String codigo;

    @Column(length = 150, nullable = false)
    private String tipo;

    @Column(length = 150, nullable = false)
    private BigDecimal valor;

    @Column(length = 255)
    private String descricao;
}
