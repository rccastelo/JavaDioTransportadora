package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.PacoteHistorico;
import br.com.dio.transportadora.entity.PacoteHistoricoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacoteHistoricoRepository extends JpaRepository<PacoteHistorico, PacoteHistoricoId> {
    @Query(value = "SELECT ph.pacote_id, ph.dataHora, ph.cep, ph.numero, ph.complemento, ph.tipo, " +
            "ph.bairro, ph.uf, ph.logradouro, " +
            "p.id as p_id, p.descricao, p.volumeM3, p.pesoGrama, p.pessoa_id, p.situacao " +
            "FROM tb_pacote_historico ph " +
            "INNER JOIN tb_pacote p ON p.id = ph.pacote_id " +
            "WHERE p.id = :pacote_id", nativeQuery = true)
    List<PacoteHistorico> consultarPorPacoteId(Long pacote_id);
}
