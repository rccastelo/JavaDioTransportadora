package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.PacoteEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacoteEnderecoRepository extends JpaRepository<PacoteEndereco, Long> {
    @Query(value = "SELECT pe.id as pe_id, pe.pacote_id, pe.origemCep, pe.origemNumero, pe.origemComplemento, " +
            "pe.destinoCep, pe.destinoNumero, pe.destinoComplemento, p.id as p_id, " +
            "p.descricao, p.volumeM3, p.pesoGrama, p.pessoa_id, p.situacao " +
            "FROM tb_pacote_endereco pe " +
            "INNER JOIN tb_pacote p ON p.id = pe.pacote_id " +
            "WHERE p.id = :pacote_id", nativeQuery = true)
    PacoteEndereco consultarPorPacoteId(Long pacote_id);
}
