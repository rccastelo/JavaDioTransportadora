package br.com.dio.transportadora.interfaces.repository;

import br.com.dio.transportadora.entity.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacoteRepository extends JpaRepository<Pacote, Long> {
}
