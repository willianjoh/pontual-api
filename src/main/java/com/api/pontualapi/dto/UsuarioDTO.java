package com.api.pontualapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpfCnpj;
    @NotBlank
    private String login;
    @NotBlank
    private String senha;
}
