package br.com.colabore.services;

import br.com.colabore.models.Demanda;
import br.com.colabore.models.forms.DemandaForm;
import br.com.colabore.models.forms.DemandaStatusForm;
import br.com.colabore.repositories.DemandaRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DemandaService {

    private DemandaRepository repository;
    private TipoDemandaService tipoDemandaService;
    private MotivoDemandaService motivoDemandaService;
    private UsuarioService usuarioService;

    public DemandaService(DemandaRepository repository, TipoDemandaService tipoDemandaService,
                          MotivoDemandaService motivoDemandaService, UsuarioService usuarioService) {
        this.repository = repository;
        this.tipoDemandaService = tipoDemandaService;
        this.motivoDemandaService = motivoDemandaService;
        this.usuarioService = usuarioService;
    }

    public Demanda salva(DemandaForm form) {
        var demanda = new Demanda();
        var tipoDemanda = tipoDemandaService.buscaPorId(form.getIdTipo());
        var motivosDemanda = motivoDemandaService.buscaTodosPorId(form.getIdMotivos());
        var solicitante = usuarioService.buscaPorId(form.getIdSolicitante());

        demanda.setStatus(form.getStatus());
        demanda.setDescricao(form.getDescricao());
        demanda.setPrevisaoTempo(form.getPrevisaoTempo());
        demanda.setTitulo(form.getTitulo());
        demanda.setTipo(tipoDemanda);
        demanda.setMotivos(motivosDemanda);
        demanda.setSolicitante(solicitante);

        return repository.save(demanda);
    }

    public Page<Demanda> lista(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Demanda buscaPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Demanda não encontrada com ID: " + id));
    }

    public Demanda atualizaStatusDemanda(Long id, DemandaStatusForm form) {
        var demanda = buscaPorId(id);
        demanda.setStatus(form.getStatus());
        return repository.save(demanda);
    }
}
