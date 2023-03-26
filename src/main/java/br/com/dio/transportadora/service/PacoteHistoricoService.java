package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteEndereco;
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
    @Autowired
    private final PacoteEnderecoService pacoteEnderecoService;

    public PacoteHistoricoService(IPacoteHistoricoRepository repository,
                                  PacoteService pacoteService,
                                  PacoteEnderecoService pacoteEnderecoService) {
        this.repository = repository;
        this.pacoteService = pacoteService;
        this.pacoteEnderecoService = pacoteEnderecoService;
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
    public PacoteHistorico incluir(Long pacote_id) {
        Pacote pacote = pacoteService.consultar(pacote_id);

        if (pacote == null) return null;

        PacoteEndereco endereco = pacoteEnderecoService.consultarPorPacoteId(pacote_id);

        if (endereco == null) return null;

        PacoteHistorico historico = movimentarParaProximoEndereco(endereco);

        PacoteHistoricoId phid = new PacoteHistoricoId();
        phid.setPacote(pacote);
        phid.setDataHora(LocalDateTime.now());
        historico.setId(phid);

        return repository.save(historico);
    }

    private PacoteHistorico movimentarParaProximoEndereco(PacoteEndereco pacoteEndereco) {
        PacoteHistorico destino = new PacoteHistorico();

        destino.setCep("98765-432");
        destino.setNumero("345");
        destino.setComplemento("Complemento");
        destino.setTipo("Tipo");

        return destino;
    }
}
