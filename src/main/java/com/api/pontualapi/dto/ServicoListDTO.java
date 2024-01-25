package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ServicoListDTO {

    private Integer id;

    private String codigo;

    private String tipo;

    public ServicoListDTO(Integer id, String codigo, String tipo) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
