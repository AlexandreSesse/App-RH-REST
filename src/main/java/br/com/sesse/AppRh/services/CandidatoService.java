package br.com.sesse.AppRh.services;

import br.com.sesse.AppRh.exceptions.CandidatoNotFoundException;
import br.com.sesse.AppRh.models.Candidato;
import br.com.sesse.AppRh.repositories.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> buscarPorId(Long id) {
        return Optional.ofNullable(candidatoRepository.findById(id)
                .orElseThrow(() -> new CandidatoNotFoundException("Candidato não encontrado")));
    }

    public Candidato salvar(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public void deletar(Long id) {
        candidatoRepository.deleteById(id);
    }
}
