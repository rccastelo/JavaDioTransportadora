package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteEndereco;
import br.com.dio.transportadora.entity.PacoteEnderecoForm;
import br.com.dio.transportadora.interfaces.repository.IPacoteEnderecoRepository;
import br.com.dio.transportadora.interfaces.service.IPacoteEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteEnderecoService implements IPacoteEnderecoService {
    @Autowired
    private final IPacoteEnderecoRepository repository;

    @Autowired
    private final PacoteService pacoteService;

    public PacoteEnderecoService(IPacoteEnderecoRepository repository,
                                 PacoteService pacoteService) {
        this.repository = repository;
        this.pacoteService = pacoteService;
    }

    @Override
    public List<PacoteEndereco> listar() {
        return repository.findAll();
    }

    @Override
    public PacoteEndereco consultar(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public PacoteEndereco consultarPorPacoteId(Long pacote_id) {
        return repository.consultarPorPacoteId(pacote_id);
    }

    @Override
    public PacoteEndereco incluir(PacoteEnderecoForm pacoteEnderecoForm) {
        PacoteEndereco pacoteEndereco = new PacoteEndereco();

        pacoteEndereco.setDestinoCep(pacoteEnderecoForm.getDestinoCep());
        pacoteEndereco.setDestinoNumero(pacoteEnderecoForm.getDestinoNumero());
        pacoteEndereco.setDestinoComplemento(pacoteEnderecoForm.getDestinoComplemento());
        pacoteEndereco.setOrigemCep(pacoteEnderecoForm.getOrigemCep());
        pacoteEndereco.setOrigemNumero(pacoteEnderecoForm.getOrigemNumero());
        pacoteEndereco.setOrigemComplemento(pacoteEnderecoForm.getOrigemComplemento());

        Pacote pacote = pacoteService.consultar(pacoteEnderecoForm.getPacoteId());
        pacoteEndereco.setPacote(pacote);

        return repository.save(pacoteEndereco);
    }

    @Override
    public PacoteEndereco alterar(Long id, PacoteEnderecoForm pacoteEnderecoForm) {
        PacoteEndereco pacoteEndereco = this.consultar(id);

        if (pacoteEndereco != null) {
            pacoteEndereco.setDestinoCep(pacoteEnderecoForm.getDestinoCep());
            pacoteEndereco.setDestinoNumero(pacoteEnderecoForm.getDestinoNumero());
            pacoteEndereco.setDestinoComplemento(pacoteEnderecoForm.getDestinoComplemento());
            pacoteEndereco.setOrigemCep(pacoteEnderecoForm.getOrigemCep());
            pacoteEndereco.setOrigemNumero(pacoteEnderecoForm.getOrigemNumero());
            pacoteEndereco.setOrigemComplemento(pacoteEnderecoForm.getOrigemComplemento());

            return repository.save(pacoteEndereco);
        } else {
            return null;
        }
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
