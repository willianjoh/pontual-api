package com.api.pontualapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private String id;

    @NotNull
    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String nome;

    @NotNull
    @Size(max = 150)
    @Column(unique = true, length = 150)
    private String cpf;

    @Email
    @Size(max = 150)
    @Column(length = 150)
    private String email;

    @NotNull
    @Size(max = 15)
    @Column(length = 150, nullable = false)
    private String celular;
}
