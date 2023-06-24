package com.api.pontualapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuario")
@Getter @Setter
@NoArgsConstructor(force = true)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = true)
    private String nome;

    @Column(length = 150, nullable = true)
    private String sobrenome;

    @Column(unique = true, length = 150, nullable = true)
    private String cpfCnpj;

    @Column(unique = true, length = 150, nullable = true)
    private String email;

    @Column(length = 150, nullable = true)
    private String senha;

}
