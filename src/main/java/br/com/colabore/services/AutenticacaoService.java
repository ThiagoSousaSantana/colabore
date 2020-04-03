package br.com.colabore.services;

import br.com.colabore.models.Usuario;
import br.com.colabore.models.forms.LoginRequest;
import br.com.colabore.models.responses.AutenticacaoResponse;
import br.com.colabore.models.responses.UsuarioResponse;
import br.com.colabore.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UsuarioService usuarioService;

    public AutenticacaoService(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.usuarioService = usuarioService;
    }

    public AutenticacaoResponse autenticaUsuario(LoginRequest loginRequest) {
        Usuario usuario = (Usuario) usuarioService.loadUserByUsername(loginRequest.getCpf());

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCpf(), loginRequest.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new AutenticacaoResponse(
                tokenProvider.geraToken(authentication),
                new UsuarioResponse(usuario));
    }
}
