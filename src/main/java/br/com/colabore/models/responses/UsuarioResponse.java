package br.com.colabore.models.responses;

import br.com.colabore.models.Empresa;
import br.com.colabore.models.Endereco;
import br.com.colabore.models.Usuario;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class UsuarioResponse {

    private Long id;
    @JsonFormat(pattern = DataUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataCadastro;
    private String nome;
    @JsonFormat(pattern = DataUtils.DATE_FORMAT)
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String estadoEmissorRg;
    private String email;
    private String telefone;
    private boolean bloqueado;
    private Set<String> perfis = new HashSet<>();

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
        this.bloqueado = usuario.isBloqueado();
        usuario.getPerfis().forEach(perfil -> this.perfis.add(perfil.getPerfil()));
    }
}
