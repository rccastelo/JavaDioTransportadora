package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.PacoteEndereco;
import br.com.dio.transportadora.entity.PacoteEnderecoForm;

import java.util.List;

public interface IPacoteEnderecoService {
    List<PacoteEndereco> listar();
    PacoteEndereco consultar(Long id);
    PacoteEndereco consultarPorPacoteId(Long pacote_id);
    PacoteEndereco incluir(PacoteEnderecoForm pacote);
    PacoteEndereco alterar(Long id, PacoteEnderecoForm pacote);
    void excluir(Long id);
}
