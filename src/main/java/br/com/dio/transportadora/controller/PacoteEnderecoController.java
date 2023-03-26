package br.com.dio.transportadora.controller;

import br.com.dio.transportadora.entity.PacoteEndereco;
import br.com.dio.transportadora.entity.PacoteEnderecoForm;
import br.com.dio.transportadora.service.PacoteEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class PacoteEnderecoController {
    @Autowired
    private final PacoteEnderecoService service;

    public PacoteEnderecoController(PacoteEnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PacoteEndereco> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PacoteEndereco consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

    @GetMapping("/pacote/{pacote_id}")
    public PacoteEndereco consultarPorPacoteId(@PathVariable Long pacote_id) {
        return service.consultarPorPacoteId(pacote_id);
    }

    @PostMapping
    public PacoteEndereco incluir(@RequestBody PacoteEnderecoForm pacoteEnderecoForm) {
        return service.incluir(pacoteEnderecoForm);
    }

    @PutMapping("/{id}")
    public PacoteEndereco alterar(@PathVariable Long id, @RequestBody PacoteEnderecoForm pacoteEnderecoForm) {
        return service.alterar(id, pacoteEnderecoForm);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
