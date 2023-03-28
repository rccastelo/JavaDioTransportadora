package br.com.dio.transportadora.controller;

import br.com.dio.transportadora.entity.Pacote;
import br.com.dio.transportadora.entity.PacoteForm;
import br.com.dio.transportadora.entity.PacoteHistorico;
import br.com.dio.transportadora.service.PacoteMovimentacaoService;
import br.com.dio.transportadora.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacote")
public class PacoteController {
    @Autowired
    private final PacoteService service;
    @Autowired
    private final PacoteMovimentacaoService movimentacaoService;

    public PacoteController(PacoteService service,
                            PacoteMovimentacaoService movimentacaoService) {
        this.service = service;
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Pacote> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pacote consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

    @PostMapping
    public Pacote incluir(@RequestBody PacoteForm pacoteForm) {
        return service.incluir(pacoteForm);
    }

    @PutMapping("/{id}")
    public Pacote alterar(@PathVariable Long id, @RequestBody PacoteForm pacoteForm) {
        return service.alterar(id, pacoteForm);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @PutMapping("/{pacote_id}/atualizar")
    public PacoteHistorico atualizar(@PathVariable Long pacote_id) {
        return movimentacaoService.atualizar(pacote_id);
    }
}
