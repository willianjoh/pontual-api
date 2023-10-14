package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ServicoDTO {
    private Integer id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String tipo;

    @NotBlank
    private BigDecimal preco;

    private String descricao;

    public ServicoDTO(Integer id, String codigo, String tipo, BigDecimal preco, String descricao) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.descricao = descricao;
    }
}
