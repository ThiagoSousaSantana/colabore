package br.com.colabore.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DemandaForm {

    @NotBlank
    private String descricao;
    @NotNull
    private Long idSolicitante;
    @NotNull
    private List<Long> idMotivos;
    @NotNull
    private Long idTipo;
}
