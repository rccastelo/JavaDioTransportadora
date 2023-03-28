package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteHistorico;
import br.com.dio.transportadora.entity.PacoteHistoricoId;
import br.com.dio.transportadora.interfaces.repository.IPacoteHistoricoRepository;
import br.com.dio.transportadora.interfaces.service.IPacoteHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PacoteHistoricoService implements IPacoteHistoricoService {
    @Autowired
    private final IPacoteHistoricoRepository repository;
    @Autowired
    private final PacoteService pacoteService;

    public PacoteHistoricoService(IPacoteHistoricoRepository repository,
                                  PacoteService pacoteService) {
        this.repository = repository;
        this.pacoteService = pacoteService;
    }

    @Override
    public List<PacoteHistorico> listar() {
        return repository.findAll();
    }

    @Override
    public List<PacoteHistorico> consultarPorPacoteId(Long pacote_id) {
        return repository.consultarPorPacoteId(pacote_id);
    }

    @Override
    public PacoteHistorico incluir(Long pacote_id, PacoteHistorico pacoteHistorico) {
        Pacote pacote = pacoteService.consultar(pacote_id);

        if (pacote == null) return null;

        PacoteHistoricoId phid = new PacoteHistoricoId();
        phid.setPacote(pacote);
        phid.setDataHora(LocalDateTime.now());

        pacoteHistorico.setId(phid);

        return repository.save(pacoteHistorico);
    }
}
