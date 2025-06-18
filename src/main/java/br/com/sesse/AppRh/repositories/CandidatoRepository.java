package br.com.sesse.AppRh.repositories;

import br.com.sesse.AppRh.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByRg(String rg);
    List<Candidato> findByNomeCandidatoContaining(String nome);
    List<Candidato> findByVagaCodigo(Long vagaId);
}
