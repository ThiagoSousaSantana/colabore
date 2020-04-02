package br.com.colabore.repositories;

import br.com.colabore.models.MotivoDemanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotivoDemandaRepository extends JpaRepository<MotivoDemanda, Long> {
    Optional<MotivoDemanda> findByDescricao(String descricao);
}
