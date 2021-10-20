package com.ivinus.sairjunto.alistamento.passos;

import com.github.javafaker.Faker;
import com.ivinus.sairjunto.alistamento.bd.MembroRepository;
import com.ivinus.sairjunto.alistamento.helper.DadosFalsosHelper;
import com.ivinus.sairjunto.alistamento.modelo.Membro;
import com.ivinus.sairjunto.alistamento.servico.MembroService;
import com.ivinus.sairjunto.alistamento.servico.SituacaoMembro;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

public class TiposDeUsuario {
    @Autowired
    MembroRepository repository;
    @Autowired
    MembroService service;

    private Membro membro;
    private String codigo;

    @Before
    public void setUp() {
        membro = new Membro();
        membro.setEmail("ze@mail.com");
        membro.setNome("Zé do Caixão");
        membro.setSenha("123");
        membro.setDataCriacao(LocalDateTime.now());
        membro.setDataNascimento(DadosFalsosHelper.dataNoPassado());
    }
    @Dado("o código do membro é {string}")
    public void o_código_do_membro_é(String tipoCodigo) {
        codigo = tipoCodigo;
    }
    @Dado("a data final de restrição é {string}")
    public void a_data_final_de_restrição_é(String tipoDataFimRestricao) {
        if ("passado".equalsIgnoreCase(tipoDataFimRestricao)) {
            membro.setDataFinalRestricao(DadosFalsosHelper.dataNoPassado());
        } else if ("futuro".equalsIgnoreCase(tipoDataFimRestricao)) {
            membro.setDataFinalRestricao(DadosFalsosHelper.dataNoFuturo());
        }
    }
    @Dado("a data da confirmação é {string}")
    public void a_data_da_confirmação_é(String tipoDataConfirmacao) {
        if ("passado".equalsIgnoreCase(tipoDataConfirmacao)) {
            membro.setDataConfirmacao(DadosFalsosHelper.dataHoraNoPassado());
        } else if ("futuro".equalsIgnoreCase(tipoDataConfirmacao)) {
            membro.setDataConfirmacao(DadosFalsosHelper.dataHoraNoFuturo());
        }
    }
    @Então("a situação do membro é {string}")
    public void a_situação_do_membro_é(String sitString) {
        repository.deleteAll();
        Membro membroX = repository.save(membro);
        if ("existente".equalsIgnoreCase(codigo)) {
            codigo = membroX.getId().toString();
        } else {
            codigo = UUID.randomUUID().toString();
        }
        SituacaoMembro situacao = service.situacao(codigo);
        SituacaoMembro esperado = SituacaoMembro.valueOf(sitString);
        Assertions.assertEquals(esperado, situacao);
    }
}
