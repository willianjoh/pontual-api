package com.api.pontualapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter @Setter
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String cpf;

    private String email;

    @NotBlank
    private String celular;

    private String fixo;

    public ClienteDTO(Integer id, String nome, String sobrenome, String cpf, String email, String celular, String fixo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.fixo = fixo;
    }
}
