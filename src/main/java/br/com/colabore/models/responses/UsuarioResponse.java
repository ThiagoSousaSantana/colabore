package br.com.colabore.models.responses;

import br.com.colabore.models.Empresa;
import br.com.colabore.models.Endereco;
import br.com.colabore.models.Usuario;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UsuarioResponse {

    private Long id;
    @JsonFormat(pattern = DataUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataCadastro;
    private String nome;
    private String senha;
    @JsonFormat(pattern = DataUtils.DATE_FORMAT)
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String estadoEmissorRg;
    private String email;
    private String telefone;
    private boolean bloqueado;

    private Endereco endereco;

    private Empresa empresa;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.dataCadastro = usuario.getDataCadastro();
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.dataNascimento = usuario.getDataNascimento();
        this.cpf = usuario.getCpf();
        this.rg = usuario.getRg();
        this.estadoEmissorRg = usuario.getEstadoEmissorRg();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.endereco = usuario.getEndereco();
        this.empresa = usuario.getEmpresa();
        this.bloqueado = usuario.isBloqueado();
    }
}
