package com.api.pontualapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "servico")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private Integer codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @Column(length = 150, nullable = false)
    private String tipo;

    @Column(length = 150, nullable = false)
    private Long valor;

    @Column(length = 255)
    private String descricao;
}
