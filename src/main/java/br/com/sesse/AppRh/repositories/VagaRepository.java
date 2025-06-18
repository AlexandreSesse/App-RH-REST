package br.com.sesse.AppRh.repositories;

import br.com.sesse.AppRh.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByNomeContaining(String nome);
    List<Vaga> findBySalarioGreaterThan(BigDecimal salario);  // Alterado para BigDecimal
}
