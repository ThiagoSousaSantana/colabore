package br.com.colabore.models.responses;

import lombok.Data;

@Data
public class AutenticacaoResponse {
    private String token;
    private UsuarioResponse usuarioResponse;

    public AutenticacaoResponse(String token, UsuarioResponse usuarioResponse) {
        this.token = token;
        this.usuarioResponse = usuarioResponse;
    }
}
