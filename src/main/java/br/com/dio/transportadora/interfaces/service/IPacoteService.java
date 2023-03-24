package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteForm;

import java.util.List;

public interface IPacoteService {
    List<Pacote> listar();
    Pacote consultar(Long id);
    Pacote incluir(PacoteForm pacote);
    Pacote alterar(Long id, PacoteForm pacote);
    void excluir(Long id);
}
