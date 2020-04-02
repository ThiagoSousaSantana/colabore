package br.com.colabore.controllers;

import br.com.colabore.models.MotivoDemanda;
import br.com.colabore.services.MotivoDemandaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demandas/motivos")
public class MotivoDemandaController {

    private MotivoDemandaService service;

    public MotivoDemandaController(MotivoDemandaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MotivoDemanda> insere(@RequestBody MotivoDemanda motivoDemanda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salva(motivoDemanda));
    }

    @GetMapping
    public Page<MotivoDemanda> listaMotivos(Pageable pageable) {
        return service.lista(pageable);
    }
}
