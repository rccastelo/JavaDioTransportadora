package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {
}
