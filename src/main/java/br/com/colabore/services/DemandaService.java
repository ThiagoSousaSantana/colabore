package br.com.colabore.services;

import br.com.colabore.models.Demanda;
import br.com.colabore.models.forms.DemandaForm;
import br.com.colabore.repositories.DemandaRepository;
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
        var motivoDemanda = motivoDemandaService.buscaPorId(form.getIdMotivo());
        var solicitante = usuarioService.buscaPorId(form.getIdSolicitante());

        demanda.setDescricao(form.getDescricao());
        demanda.setTipo(tipoDemanda);
        demanda.setMotivo(motivoDemanda);
        demanda.setSolicitante(solicitante);

        return repository.save(demanda);
    }

    public Page<Demanda> lista(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
