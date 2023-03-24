package br.com.dio.transportadora.controller;

import br.com.dio.transportadora.entity.Pessoa;
import br.com.dio.transportadora.entity.PessoaForm;
import br.com.dio.transportadora.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pessoa consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

    @PostMapping
    public Pessoa incluir(@RequestBody PessoaForm pessoaForm) {
        return service.incluir(pessoaForm);
    }

    @PutMapping("/{id}")
    public Pessoa alterar(@PathVariable Long id, @RequestBody PessoaForm pessoaForm) {
        return service.alterar(id, pessoaForm);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
