package br.com.colabore.services;

import br.com.colabore.models.TipoDemanda;
import br.com.colabore.repositories.TipoDemandaRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoDemandaService {

    private TipoDemandaRepository repository;

    public TipoDemandaService(TipoDemandaRepository repository) {
        this.repository = repository;
    }

    public TipoDemanda buscaPorId(Long idMotivo) {
        return repository.findById(idMotivo).orElseThrow(() ->
                new ObjectNotFoundException("Tipo Demanda não encontrado com o ID: " + idMotivo));
    }

    public TipoDemanda salva(TipoDemanda form) {
        form.setId(null);
        var tipoDemanda = repository.findByDescricao(form.getDescricao());
        return tipoDemanda.orElse(repository.save(form));
    }

    public Page<TipoDemanda> lista(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
