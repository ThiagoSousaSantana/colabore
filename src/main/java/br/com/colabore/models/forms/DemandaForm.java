package br.com.colabore.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DemandaForm {

    @NotBlank
    private String descricao;
    @NotNull
    private Long idSolicitante;
    @NotNull
    private Long idMotivo;
    @NotNull
    private Long idTipo;
}
