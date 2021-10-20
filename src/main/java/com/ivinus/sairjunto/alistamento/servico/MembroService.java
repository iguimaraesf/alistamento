package com.ivinus.sairjunto.alistamento.servico;

import com.ivinus.sairjunto.alistamento.bd.MembroRepository;
import com.ivinus.sairjunto.alistamento.modelo.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class MembroService {
    private MembroRepository membroRepository;
    @Autowired
    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    public SituacaoMembro situacao(String codigo) {
        Optional<Membro> opc = membroRepository.findById(UUID.fromString(codigo));
        return opc.isEmpty() ? SituacaoMembro.NAO_CONFIRMADO : calcularSituacao(opc.get());
    }

    private SituacaoMembro calcularSituacao(Membro membro) {
        if (membro.getDataConfirmacao() == null) {
            return SituacaoMembro.NAO_CONFIRMADO;
        }
        if (membro.getDataFinalRestricao() != null && membro.getDataFinalRestricao().isAfter(LocalDate.now())) {
            return SituacaoMembro.RESTRITO;
        }
        return SituacaoMembro.LIBERADO;
    }
}
