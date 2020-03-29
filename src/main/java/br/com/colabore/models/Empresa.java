package br.com.colabore.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Empresa {

    @Id
    private String id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;

}
