package br.com.sesse.AppRh.repositories;

import br.com.sesse.AppRh.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNomeContaining(String nome);
    Funcionario findByEmail(String email);
}
