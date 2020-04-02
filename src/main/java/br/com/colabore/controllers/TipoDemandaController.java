package br.com.colabore.controllers;

import br.com.colabore.models.TipoDemanda;
import br.com.colabore.services.TipoDemandaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demandas/tipos")
public class TipoDemandaController {

    private TipoDemandaService service;

    public TipoDemandaController(TipoDemandaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TipoDemanda> insere(@RequestBody TipoDemanda tipoDemanda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salva(tipoDemanda));
    }

    @GetMapping
    public Page<TipoDemanda> listaTipos(Pageable pageable) {
        return service.lista(pageable);
    }
}
