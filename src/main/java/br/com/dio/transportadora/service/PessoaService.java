package br.com.dio.transportadora.service;

import br.com.dio.transportadora.entity.Pessoa;
import br.com.dio.transportadora.entity.PessoaForm;
import br.com.dio.transportadora.interfaces.repository.IPessoaRepository;
import br.com.dio.transportadora.interfaces.service.IPessoaService;
import br.com.dio.transportadora.utils.JavaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PessoaService implements IPessoaService {
    @Autowired
    private final IPessoaRepository repository;

    public PessoaService(IPessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pessoa> listar() {
        return repository.findAll();
    }

    @Override
    public Pessoa consultar(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Pessoa incluir(PessoaForm pessoaForm) {
        Pessoa pessoa = new Pessoa();

        LocalDate dn = LocalDate.parse(pessoaForm.getDataNascimento(), JavaTimeUtils.LOCAL_DATE_FORMATTER);

        pessoa.setNome(pessoaForm.getNome());
        pessoa.setCpfCnpj(pessoaForm.getCpfCnpj());
        pessoa.setDataNascimento(dn);
        pessoa.setDataCadastro(LocalDateTime.now());

        return repository.save(pessoa);
    }

    @Override
    public Pessoa alterar(Long id, PessoaForm pessoaForm) {
        Pessoa pessoa = this.consultar(id);

        if (pessoa != null) {
            LocalDate dn = LocalDate.parse(pessoaForm.getDataNascimento(), JavaTimeUtils.LOCAL_DATE_FORMATTER);

            pessoa.setNome(pessoaForm.getNome());
            pessoa.setCpfCnpj(pessoaForm.getCpfCnpj());
            pessoa.setDataNascimento(dn);

            return repository.save(pessoa);
        } else {
            return null;
        }
    }

    @Override
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
