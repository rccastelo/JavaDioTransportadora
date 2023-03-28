package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.PacoteHistorico;

public interface IPacoteMovimentacaoService {
    PacoteHistorico atualizar(Long pacote_id);
}
