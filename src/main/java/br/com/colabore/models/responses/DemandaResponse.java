package br.com.colabore.models.responses;

import br.com.colabore.models.Demanda;
import br.com.colabore.models.MotivoDemanda;
import br.com.colabore.models.TipoDemanda;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DemandaResponse {

    private Long id;
    private boolean bloqueado;
    private boolean concluido;
    private String descricao;
    @JsonFormat(pattern = DataUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataCadastro;
    private UsuarioDemandaResponse solicitante;
    private UsuarioDemandaResponse colaborador;
    private MotivoDemanda motivo;
    private TipoDemanda tipo;

    public DemandaResponse(Demanda demanda) {
        this.id = demanda.getId();
        this.bloqueado = demanda.isBloqueado();
        this.concluido = demanda.isConcluido();
        this.descricao = demanda.getDescricao();
        this.dataCadastro = demanda.getDataCadastro();
        this.solicitante = new UsuarioDemandaResponse(demanda.getSolicitante());
        this.colaborador = demanda.getColaborador() != null ? new UsuarioDemandaResponse(demanda.getColaborador()) : null;
        this.motivo = demanda.getMotivo();
        this.tipo = demanda.getTipo();
    }
}
