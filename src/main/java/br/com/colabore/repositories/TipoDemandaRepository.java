package br.com.colabore.repositories;

import br.com.colabore.models.TipoDemanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoDemandaRepository extends JpaRepository<TipoDemanda, Long> {
    Optional<TipoDemanda> findByDescricao(String descricao);
}
