package br.com.colabore.models.responses;

import br.com.colabore.models.Usuario;
import lombok.Data;

@Data
public class UsuarioDemandaResponse {
    private Long id;
    private String nome;

    public UsuarioDemandaResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
}
