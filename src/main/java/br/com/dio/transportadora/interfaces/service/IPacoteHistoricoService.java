package br.com.dio.transportadora.interfaces.service;

import br.com.dio.transportadora.entity.PacoteHistorico;

import java.util.List;

public interface IPacoteHistoricoService {
    List<PacoteHistorico> listar();
    List<PacoteHistorico> consultarPorPacoteId(Long pacote_id);
    PacoteHistorico incluir(Long pacote_id, PacoteHistorico pacoteHistorico);
}
