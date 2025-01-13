package com.api.pontualapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
@NoArgsConstructor
public class ClienteDTO {

    private String id;

    @NotBlank
    private String nome;

    private String cpf;

    private String email;

    @NotBlank
    private String celular;


    public ClienteDTO(String id, String nome, String cpf, String email, String celular) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
    }
}
