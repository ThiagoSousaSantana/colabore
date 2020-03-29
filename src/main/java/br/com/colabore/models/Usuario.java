package br.com.colabore.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
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

    private Endereco endereco;

    private Empresa empresa;

}
