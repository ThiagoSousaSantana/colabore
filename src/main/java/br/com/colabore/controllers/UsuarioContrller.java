package br.com.colabore.controllers;

import br.com.colabore.models.Usuario;
import br.com.colabore.models.responses.UsuarioResponse;
import br.com.colabore.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContrller {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> insereUsuario(@RequestBody Usuario usuario) {
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UsuarioResponse(usuarioService.salva(usuario)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscaUsuario(@PathVariable String id) {
        return ResponseEntity.ok(new UsuarioResponse(usuarioService.buscaPorId(id)));
    }
}
