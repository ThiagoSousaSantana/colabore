package br.com.colabore.services;

import br.com.colabore.models.MotivoDemanda;
import br.com.colabore.repositories.MotivoDemandaRepository;
import br.com.colabore.services.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MotivoDemandaService {

    private MotivoDemandaRepository repository;

    public MotivoDemandaService(MotivoDemandaRepository repository) {
        this.repository = repository;
    }

    public MotivoDemanda buscaPorId(Long idMotivo) {
        return repository.findById(idMotivo).orElseThrow(() ->
                new ObjectNotFoundException("Motivo demanda não encontrado com ID: " + idMotivo));
    }

    public MotivoDemanda salva(MotivoDemanda form) {
        form.setId(null);
        var motivoDemanda = repository.findByDescricao(form.getDescricao());
        return motivoDemanda.orElse(repository.save(form));
    }

    public Page<MotivoDemanda> lista(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
