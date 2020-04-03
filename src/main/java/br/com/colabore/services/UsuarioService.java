package br.com.colabore.services;


import br.com.colabore.models.Usuario;
import br.com.colabore.models.forms.UsuarioBloqueadoForm;
import br.com.colabore.models.forms.UsuarioForm;
import br.com.colabore.models.responses.UsuarioResponse;
import br.com.colabore.repositories.EnderecoRepository;
import br.com.colabore.repositories.UsuarioRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UsuarioService implements UserDetailsService {

    private UsuarioRepository repository;
    private EnderecoRepository enderecoRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, EnderecoRepository enderecoRepository) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario salva(@Valid UsuarioForm form) {
        var usuario = new Usuario(form);
        usuario.setEndereco(enderecoRepository.save(usuario.getEndereco()));
        usuario.setSenha(passwordEncoder.encode(form.getSenha()));
        return repository.save(usuario);
    }

    public Usuario buscaPorId(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Usuario não econtrado com ID: " + id));
    }

    public Page<UsuarioResponse> listaUsuarios(Pageable pageable) {
        return repository.findAll(pageable).map(UsuarioResponse::new);
    }

    public Usuario atualizaUsuario(Long id, UsuarioForm form) {
        var usuario = buscaPorId(id);
        atualizaUsuario(form, usuario);

        enderecoRepository.save(usuario.getEndereco());
        return repository.save(usuario);
    }

    public Usuario atualizaUsuario(Long id, UsuarioBloqueadoForm form) {
        var usuario = buscaPorId(id);
        usuario.setBloqueado(form.isBloqueado());
        return repository.save(usuario);
    }

    private void atualizaUsuario(UsuarioForm form, Usuario usuario) {
        usuario.setNome(form.getNome());
        usuario.setDataNascimento(form.getDataNascimento());
        usuario.setCpf(form.getCpf());
        usuario.setRg(form.getRg());
        usuario.setEstadoEmissorRg(form.getEstadoEmissorRg());
        usuario.setTelefone(form.getTelefone());
        usuario.setEmail(form.getEmail());
        usuario.setBloqueado(form.isBloqueado());

        form.getEndereco().setId(usuario.getEndereco().getId());
        usuario.setEndereco(form.getEndereco());
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return repository.findByCpf(cpf).orElseThrow(() ->
                new ObjectNotFoundException("Usuario não econtrado com CPF: " + cpf));
    }
}
