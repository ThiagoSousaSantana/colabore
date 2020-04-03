package br.com.colabore.models;

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
    private boolean bloqueado = true;
    private boolean concluido = false;
    private String descricao;
    private String titulo;
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
