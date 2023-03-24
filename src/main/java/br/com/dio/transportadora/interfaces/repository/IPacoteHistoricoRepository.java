package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.PacoteHistorico;
import br.com.dio.transportadora.entity.PacoteHistoricoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacoteHistoricoRepository extends JpaRepository<PacoteHistorico, PacoteHistoricoId> {
}
