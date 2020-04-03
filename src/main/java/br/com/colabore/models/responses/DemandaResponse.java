package br.com.colabore.models.responses;

import br.com.colabore.models.Demanda;
import br.com.colabore.models.MotivoDemanda;
import br.com.colabore.models.TipoDemanda;
import br.com.colabore.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DemandaResponse {

    private Long id;
    private boolean bloqueado;
    private boolean concluido;
    private String descricao;
    private String titulo;
    @JsonFormat(pattern = DataUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataCadastro;
    private UsuarioDemandaResponse solicitante;
    private UsuarioDemandaResponse colaborador;
    private List<MotivoDemanda> motivos;
    private TipoDemanda tipo;

    public DemandaResponse(Demanda demanda) {
        this.id = demanda.getId();
        this.bloqueado = demanda.isBloqueado();
        this.concluido = demanda.isConcluido();
        this.descricao = demanda.getDescricao();
        this.titulo = demanda.getTitulo();
        this.dataCadastro = demanda.getDataCadastro();
        this.solicitante = new UsuarioDemandaResponse(demanda.getSolicitante());
        this.colaborador = demanda.getColaborador() != null ? new UsuarioDemandaResponse(demanda.getColaborador()) : null;
        this.motivos = demanda.getMotivos();
        this.tipo = demanda.getTipo();
    }
}
