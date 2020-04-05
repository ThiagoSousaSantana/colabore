package br.com.colabore.models;

import br.com.colabore.models.constantes.Perfil;
import br.com.colabore.models.forms.UsuarioForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senha;
    private LocalDateTime dataCadastro;
    private String nome;
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String rg;
    private String estadoEmissorRg;
    private String email;
    private String telefone;
    private boolean bloqueado;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    private Set<Perfil> perfis = new HashSet<>();

    @OneToOne
    private Endereco endereco;

    @ManyToOne
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
        addPerfil(Perfil.USER);
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !bloqueado;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !bloqueado;
    }
}
