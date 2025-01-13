package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ClienteListDTO {

    private String id;

    private String nome;

    public ClienteListDTO(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
