package com.api.pontualapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String sobrenome;

    @Column(unique = true, length = 150)
    private String cpf;

    @Column(length = 150, nullable = false)
    private String telefone;

    @Column(length = 150)
    private String telefoneFixo;

}
