package br.com.colabore.controllers;

import br.com.colabore.models.forms.UsuarioForm;
import br.com.colabore.models.responses.UsuarioResponse;
import br.com.colabore.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContrller {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> insereUsuario(@RequestBody @Valid UsuarioForm form) {
        var usuario = usuarioService.salva(form);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscaUsuario(@PathVariable String id) {
        return ResponseEntity.ok(new UsuarioResponse(usuarioService.buscaPorId(id)));
    }

    @GetMapping
    public Page<UsuarioResponse> listaUsuarios(Pageable pageable) {
        return usuarioService.listaUsuarios(pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizaUsuario(@PathVariable String id,
                                                           @RequestBody @Valid UsuarioForm form) {
        return ResponseEntity.ok(new UsuarioResponse(usuarioService.atualizaUsuario(id, form)));
    }
}
