package br.com.colabore.models;

import br.com.colabore.models.constantes.StatusDemanda;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusDemanda status;
    @Column(length = 1000)
    private String descricao;
    private String titulo;
    private String previsaoTempo;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToOne
    private Usuario solicitante;

    @ManyToOne
    private Usuario colaborador;

    @ManyToMany
    private List<MotivoDemanda> motivos;

    @ManyToOne
    private TipoDemanda tipo;

}
