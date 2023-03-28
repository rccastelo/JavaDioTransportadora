package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.*;
import br.com.dio.transportadora.interfaces.service.IPacoteMovimentacaoService;
import br.com.dio.transportadora.interfaces.service.IViaCepService;
import br.com.dio.transportadora.repository.EnderecoFilialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PacoteMovimentacaoService implements IPacoteMovimentacaoService {
    @Autowired
    private final PacoteService pacoteService;
    @Autowired
    private final PacoteEnderecoService enderecoService;
    @Autowired
    private final PacoteHistoricoService historicoService;
    @Autowired
    private final IViaCepService cepService;
    @Autowired
    private final EnderecoFilialRepository filiaisRepository;

    public PacoteMovimentacaoService(PacoteService pacoteService,
                                     PacoteEnderecoService enderecoService,
                                     PacoteHistoricoService historicoService,
                                     IViaCepService cepService,
                                     EnderecoFilialRepository filiaisRepository) {
        this.pacoteService = pacoteService;
        this.enderecoService = enderecoService;
        this.historicoService = historicoService;
        this.cepService = cepService;
        this.filiaisRepository = filiaisRepository;
    }

    public PacoteHistorico atualizar(Long pacote_id) {
        PacoteHistorico historico = verificarMovimentacao(pacote_id);

        if (historico != null) {
            historicoService.incluir(pacote_id, historico);
            pacoteService.alterar(pacote_id, verificarSituacao(historico.getTipo()));

            return historico;
        } else {
            return null;
        }
    }

    private PacoteHistorico verificarMovimentacao(Long pacote_id) {
        PacoteHistorico novoHistorico = new PacoteHistorico();

        Pacote pacote = pacoteService.consultar(pacote_id);

        if (pacote == null) return null;

        PacoteEndereco endereco = enderecoService.consultarPorPacoteId(pacote_id);

        if (endereco == null) return null;

        List<PacoteHistorico> historicos = historicoService.consultarPorPacoteId(pacote_id);

        if ((historicos == null) || (historicos.isEmpty())) {
            EnderecoCep endOrigem = cepService.enderecoCep(endereco.getOrigemCep());

            novoHistorico.setCep(endereco.getOrigemCep());
            novoHistorico.setNumero(endereco.getOrigemNumero());
            novoHistorico.setComplemento(endereco.getOrigemComplemento());
            novoHistorico.setUf(endOrigem.getUf());
            novoHistorico.setBairro(endOrigem.getBairro());
            novoHistorico.setLogradouro(endOrigem.getLogradouro());
            novoHistorico.setTipo("cadastrado");
        } else {
            novoHistorico = verificarProximoTipo(endereco, obterUltimoHistorico(historicos));
        }

        return novoHistorico;
    }

    private PacoteHistorico obterUltimoHistorico(List<PacoteHistorico> historicos) {
        PacoteHistorico histAtual = null;
        LocalDateTime dhAtual = LocalDateTime.MIN;

        for (PacoteHistorico hist : historicos) {
            PacoteHistoricoId phid = hist.getId();

            if (phid.getDataHora().isAfter(dhAtual)) {
                dhAtual = phid.getDataHora();
                histAtual = hist;
            }
        }

        return histAtual;
    }

    private PacoteHistorico verificarProximoTipo(PacoteEndereco endereco, PacoteHistorico historicoAtual) {
        PacoteHistorico novoHistorico = new PacoteHistorico();

        if (historicoAtual.getTipo().equalsIgnoreCase("cadastrado")) {
            novoHistorico.setCep(historicoAtual.getCep());
            novoHistorico.setNumero(historicoAtual.getNumero());
            novoHistorico.setComplemento(historicoAtual.getComplemento());
            novoHistorico.setBairro(historicoAtual.getBairro());
            novoHistorico.setUf(historicoAtual.getUf());
            novoHistorico.setLogradouro(historicoAtual.getLogradouro());
            novoHistorico.setTipo("recebido");
        } else if (historicoAtual.getTipo().equalsIgnoreCase("recebido")) {
            novoHistorico = verificarProximoEndereco(endereco, historicoAtual);
            if (novoHistorico != null) novoHistorico.setTipo("enviado");
        } else if (historicoAtual.getTipo().equalsIgnoreCase("enviado")) {
            novoHistorico.setCep(historicoAtual.getCep());
            novoHistorico.setNumero(historicoAtual.getNumero());
            novoHistorico.setComplemento(historicoAtual.getComplemento());
            novoHistorico.setBairro(historicoAtual.getBairro());
            novoHistorico.setUf(historicoAtual.getUf());
            novoHistorico.setLogradouro(historicoAtual.getLogradouro());

            if ((historicoAtual.getCep().equalsIgnoreCase(endereco.getDestinoCep())) &&
                    (historicoAtual.getNumero().equalsIgnoreCase(endereco.getDestinoNumero()))) {
                novoHistorico.setTipo("entregue");
            } else {
                novoHistorico.setTipo("recebido");
            }
        } else {
            novoHistorico = null;
        }

        return novoHistorico;
    }

    private PacoteHistorico verificarProximoEndereco(PacoteEndereco endereco, PacoteHistorico historicoAtual) {
        PacoteHistorico novoHistorico = new PacoteHistorico();

        String cepOrigem = endereco.getOrigemCep();
        String cepAtual = historicoAtual.getCep();
        String cepDestino = endereco.getDestinoCep();
        EnderecoCep endOrigem = cepService.enderecoCep(cepOrigem);
        EnderecoCep endAtual = cepService.enderecoCep(cepAtual);
        EnderecoCep endDestino = cepService.enderecoCep(cepDestino);
        String ufOrigem = endOrigem.getUf();
        String ufAtual = endAtual.getUf();
        String ufDestino = endDestino.getUf();
        String numOrigem = endereco.getOrigemNumero();
        String numAtual = historicoAtual.getNumero();
        String numDestino = endereco.getDestinoNumero();

        if (cepAtual.equalsIgnoreCase(cepOrigem) &&
                ufAtual.equalsIgnoreCase(ufOrigem) &&
                numAtual.equalsIgnoreCase(numOrigem)) {
            novoHistorico.setCep(filiaisRepository.obterCep(endOrigem.getUf()));

            EnderecoCep endCep = cepService.enderecoCep(novoHistorico.getCep());

            novoHistorico.setNumero("0");
            novoHistorico.setComplemento("Filial " + endOrigem.getUf());
            novoHistorico.setUf(endCep.getUf());
            novoHistorico.setBairro(endCep.getBairro());
            novoHistorico.setLogradouro(endCep.getLogradouro());

            return novoHistorico;
        }

        if (!(ufAtual.equalsIgnoreCase(ufDestino))) {
            novoHistorico.setCep(filiaisRepository.obterCep(endDestino.getUf()));

            EnderecoCep endCep = cepService.enderecoCep(novoHistorico.getCep());

            novoHistorico.setNumero("0");
            novoHistorico.setComplemento("Filial " + endDestino.getUf());
            novoHistorico.setUf(endCep.getUf());
            novoHistorico.setBairro(endCep.getBairro());
            novoHistorico.setLogradouro(endCep.getLogradouro());

            return novoHistorico;
        } else if (!(cepAtual.equalsIgnoreCase(cepDestino))) {
            novoHistorico.setCep(cepDestino);
            novoHistorico.setNumero(numDestino);
            novoHistorico.setComplemento(endereco.getDestinoComplemento());
            novoHistorico.setUf(endDestino.getUf());
            novoHistorico.setBairro(endDestino.getBairro());
            novoHistorico.setLogradouro(endDestino.getLogradouro());

            return novoHistorico;
        }

        return null;
    }

    private String verificarSituacao (String atual) {
        switch (atual) {
            case "cadastrado":
                return "cadastrado";
            case "recebido":
                return "aguardando";
            case "enviado":
                return "em transito";
            case "entregue":
                return "entregue";
            default:
                return "nao disponivel";
        }
    }
}
