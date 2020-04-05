package br.com.colabore.models.forms;

import br.com.colabore.models.constantes.StatusDemanda;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DemandaStatusForm {
    @NotNull
    private StatusDemanda status;
}
