package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.Pessoa;
import br.com.dio.transportadora.entity.PessoaForm;

import java.util.List;

public interface IPessoaService {
    List<Pessoa> listar();
    Pessoa consultar(Long id);
    Pessoa incluir(PessoaForm pessoa);
    Pessoa alterar(Long id, PessoaForm pessoa);
    void excluir(Long id);
}
