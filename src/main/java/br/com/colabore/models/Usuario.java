package br.com.colabore.models;

import br.com.colabore.models.forms.UsuarioForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
public class Usuario {

    @Id
    private String id;
    private String senha;
    private LocalDateTime dataCadastro;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String estadoEmissorRg;
    private String email;
    private String telefone;
    private boolean bloqueado;

    private Endereco endereco;

    private Empresa empresa;

    public Usuario(UsuarioForm form) {
        this.senha = form.getSenha();
        this.dataCadastro = LocalDateTime.now();
        this.nome = form.getNome();
        this.dataNascimento = form.getDataNascimento();
        this.cpf = form.getCpf();
        this.rg = form.getRg();
        this.estadoEmissorRg = form.getEstadoEmissorRg();
        this.email = form.getEmail();
        this.telefone = form.getTelefone();
        this.endereco = form.getEndereco();
        this.bloqueado = form.isBloqueado();
    }

}
