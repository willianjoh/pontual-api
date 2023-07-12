package com.api.pontualapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String sobrenome;

    @Column(unique = true, length = 150, nullable = false)
    private String cpfCnpj;

    @Column(unique = true, length = 150, nullable = false)
    private String login;

    @Column(length = 150, nullable = false)
    private String senha;

}
