package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.PacoteEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacoteEnderecoRepository extends JpaRepository<PacoteEndereco, Long> {
}
