package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteForm;
import br.com.dio.transportadora.entity.Pessoa;
import br.com.dio.transportadora.interfaces.repository.IPacoteRepository;
import br.com.dio.transportadora.interfaces.service.IPacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService implements IPacoteService {
    @Autowired
    private final IPacoteRepository repository;

    @Autowired
    private final PessoaService pessoaService;

    public PacoteService(IPacoteRepository repository, PessoaService pessoaService) {
        this.repository = repository;
        this.pessoaService = pessoaService;
    }

    @Override
    public List<Pacote> listar() {
        return repository.findAll();
    }

    @Override
    public Pacote consultar(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Pacote incluir(PacoteForm pacoteForm) {
        Pacote pacote = new Pacote();

        pacote.setDescricao(pacoteForm.getDescricao());
        pacote.setPesoGrama(pacoteForm.getPesoGrama());
        pacote.setVolumeM3(pacoteForm.getVolumeM3());
        pacote.setSituacao(pacoteForm.getSituacao());

        Pessoa pessoa = pessoaService.consultar(pacoteForm.getPessoaId());
        pacote.setPessoa(pessoa);

        return repository.save(pacote);
    }

    @Override
    public Pacote alterar(Long id, PacoteForm pacoteForm) {
        Pacote pacote = this.consultar(id);

        if (pacote != null) {
            pacote.setDescricao(pacoteForm.getDescricao());
            pacote.setPesoGrama(pacoteForm.getPesoGrama());
            pacote.setVolumeM3(pacoteForm.getVolumeM3());
            pacote.setSituacao(pacoteForm.getSituacao());

            return repository.save(pacote);
        } else {
            return null;
        }
    }

    @Override
    public Pacote alterar(Long id, String situacao) {
        Pacote pacote = this.consultar(id);

        if (pacote != null) {
            pacote.setSituacao(situacao);

            return repository.save(pacote);
        } else {
            return null;
        }
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
