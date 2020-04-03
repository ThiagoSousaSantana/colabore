package br.com.colabore.models.forms;

import lombok.Data;

@Data
public class LoginRequest {
    private String cpf;
    private String senha;
}
