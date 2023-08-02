package com.api.pontualapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
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

    @Column(length = 150)
    private String email;

    @Column(length = 150, nullable = false)
    private String celular;

    @Column(length = 150)
    private String fixo;

}
