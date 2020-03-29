package br.com.colabore.models.responses;

import br.com.colabore.models.Empresa;
import br.com.colabore.models.Endereco;
import br.com.colabore.models.Usuario;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsuarioResponse {

    private String id;
    private LocalDateTime dataCadastro;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String estadoEmissorRg;
    private String email;
    private String telefone;

    private Endereco endereco;

    private Empresa empresa;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.dataCadastro = usuario.getDataCadastro();
        this.nome = usuario.getNome();
        this.dataNascimento = usuario.getDataNascimento();
        this.cpf = usuario.getCpf();
        this.rg = usuario.getRg();
        this.estadoEmissorRg = usuario.getEstadoEmissorRg();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.endereco = usuario.getEndereco();
        this.empresa = usuario.getEmpresa();
    }
}
