package br.com.colabore.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean bloqueado = true;
    private boolean concluido = false;
    private String descricao;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @ManyToOne
    private Usuario solicitante;

    @ManyToOne
    private Usuario colaborador;

    @ManyToOne
    private MotivoDemanda motivo;

    @ManyToOne
    private TipoDemanda tipo;

}
