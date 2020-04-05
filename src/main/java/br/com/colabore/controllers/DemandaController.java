package br.com.colabore.controllers;

import br.com.colabore.models.forms.DemandaForm;
import br.com.colabore.models.forms.DemandaStatusForm;
import br.com.colabore.models.responses.DemandaResponse;
import br.com.colabore.services.DemandaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/demandas")
public class DemandaController {

    private DemandaService service;

    public DemandaController(DemandaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DemandaResponse> insereDemanda(@RequestBody @Valid DemandaForm demandaForm) {
        var demanda = service.salva(demandaForm);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(demanda.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DemandaResponse(demanda));
    }

    @GetMapping
    public Page<DemandaResponse> listaDemandas(Pageable pageable) {
        return service.lista(pageable).map(DemandaResponse::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandaResponse> buscaDemanda(@PathVariable Long id) {
        return ResponseEntity.ok(new DemandaResponse(service.buscaPorId(id)));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DemandaResponse> atualizaStatusDemanda(@PathVariable Long id,
                                                                 @RequestBody @Valid DemandaStatusForm form) {
        return ResponseEntity.ok(new DemandaResponse(service.atualizaStatusDemanda(id, form)));
    }
}
