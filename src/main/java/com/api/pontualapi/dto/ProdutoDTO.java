package com.api.pontualapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO {

    private Integer id;
    @NotBlank
    private String codigo;

    @NotBlank
    private String nome;

    @NotBlank
    private String modelo;

    private String descricao;

    @NotBlank
    private BigDecimal valor;

    public ProdutoDTO(Integer id, String codigo, String nome, String modelo, String descricao, BigDecimal valor) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valor = valor;
    }
}
