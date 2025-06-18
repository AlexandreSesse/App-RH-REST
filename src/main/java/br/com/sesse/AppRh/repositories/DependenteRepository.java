package br.com.sesse.AppRh.repositories;

import br.com.sesse.AppRh.models.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {
    List<Dependente> findByNomeContaining(String nome);
    List<Dependente> findByFuncionarioId(Long funcionarioId);
    Dependente findByCpf(String cpf);
}
