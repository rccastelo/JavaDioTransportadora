package br.com.dio.transportadora.controller;

import br.com.dio.transportadora.entity.PacoteHistorico;
import br.com.dio.transportadora.service.PacoteHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class PacoteHistoricoController {
    @Autowired
    private final PacoteHistoricoService service;

    public PacoteHistoricoController(PacoteHistoricoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PacoteHistorico> listar() {
        return service.listar();
    }

    @GetMapping("/pacote/{pacote_id}")
    public List<PacoteHistorico> consultarPorPacoteId(@PathVariable Long pacote_id) {
        return service.consultarPorPacoteId(pacote_id);
    }

    @PutMapping("/pacote/{pacote_id}/movimentar")
    public PacoteHistorico incluir(@PathVariable Long pacote_id) {
        return service.incluir(pacote_id);
    }
}
