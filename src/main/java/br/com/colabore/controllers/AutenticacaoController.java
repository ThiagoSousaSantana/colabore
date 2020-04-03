package br.com.colabore.controllers;

import br.com.colabore.models.forms.LoginRequest;
import br.com.colabore.models.responses.AutenticacaoResponse;
import br.com.colabore.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @PostMapping
    public ResponseEntity<AutenticacaoResponse> autenticaUsuario(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(service.autenticaUsuario(loginRequest));
    }
}
