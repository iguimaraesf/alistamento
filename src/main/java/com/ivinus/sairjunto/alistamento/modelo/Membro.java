package com.ivinus.sairjunto.alistamento.modelo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Membro extends Auditavel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID id;

    @Column(length = 200, nullable = true)
    private String nome;

    @Column(length = 200, nullable = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    private LocalDate dataFinalRestricao;

    private LocalDateTime dataConfirmacao;
}
