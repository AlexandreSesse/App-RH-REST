package br.com.sesse.AppRh.services;

import br.com.sesse.AppRh.models.Dependente;
import br.com.sesse.AppRh.repositories.DependenteRepository;
import br.com.sesse.AppRh.exceptions.DependenteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    public List<Dependente> listarTodos() {
        return dependenteRepository.findAll();
    }

    public Optional<Dependente> buscarPorId(Long id) {
        return Optional.ofNullable(dependenteRepository.findById(id)
                .orElseThrow(() -> new DependenteNotFoundException("Dependente não encontrado")));
    }

    public Dependente salvar(Dependente dependente) {
        return dependenteRepository.save(dependente);
    }

    public void deletar(Long id) {
        dependenteRepository.deleteById(id);
    }
}