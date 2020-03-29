package br.com.colabore.services;


import br.com.colabore.models.Usuario;
import br.com.colabore.repositories.UsuarioRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public Usuario salva(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario buscaPorId(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Usuario não econtrado com ID: " + id));
    }
}
