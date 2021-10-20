package com.ivinus.sairjunto.alistamento.bd;

import com.ivinus.sairjunto.alistamento.modelo.Membro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MembroRepository extends CrudRepository<Membro, UUID> {
}
