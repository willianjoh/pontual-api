package com.api.pontualapi.dto;

import com.api.pontualapi.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ClienteDTO {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String cpf;

    @NotBlank
    private String contato;

    private String contatoFixo;

}
