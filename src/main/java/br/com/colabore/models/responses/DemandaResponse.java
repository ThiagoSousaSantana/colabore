package br.com.colabore.models.responses;

import br.com.colabore.models.Demanda;
import br.com.colabore.models.MotivoDemanda;
import br.com.colabore.models.TipoDemanda;
import br.com.colabore.models.constantes.StatusDemanda;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DemandaResponse {

    private Long id;
    private StatusDemanda status;
    private String descricao;
    private String titulo;
    private String previsaoTempo;
    @JsonFormat(pattern = DataUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataCadastro;
    private UsuarioDemandaResponse solicitante;
    private UsuarioDemandaResponse colaborador;
    private List<MotivoDemanda> motivos;
    private TipoDemanda tipo;

    public DemandaResponse(Demanda demanda) {
        this.id = demanda.getId();
        this.titulo = demanda.getTitulo();
        this.descricao = demanda.getDescricao();
        this.status = demanda.getStatus();
        this.dataCadastro = demanda.getDataCadastro();
        this.previsaoTempo = demanda.getPrevisaoTempo();
        this.solicitante = new UsuarioDemandaResponse(demanda.getSolicitante());
        this.colaborador = demanda.getColaborador() != null ? new UsuarioDemandaResponse(demanda.getColaborador()) : null;
        this.motivos = demanda.getMotivos();
        this.tipo = demanda.getTipo();
    }
}
