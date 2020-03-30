package br.com.colabore.services;


import br.com.colabore.models.Usuario;
import br.com.colabore.models.forms.UsuarioForm;
import br.com.colabore.repositories.UsuarioRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public Usuario salva(@Valid UsuarioForm form) {
        return repository.save(new Usuario(form));
    }

    public Usuario buscaPorId(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Usuario não econtrado com ID: " + id));
    }
}
