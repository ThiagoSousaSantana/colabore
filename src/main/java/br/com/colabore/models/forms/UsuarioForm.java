package br.com.colabore.models.forms;

import br.com.colabore.models.Endereco;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class UsuarioForm {

    @NotBlank
    @Size(min = 6)
    private String senha;

    @NotBlank
    private String nome;

    @JsonFormat(pattern = DataUtils.DATE_FORMAT)
    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String estadoEmissorRg;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @Valid
    @NotNull
    private Endereco endereco;

    private boolean bloqueado;

}
