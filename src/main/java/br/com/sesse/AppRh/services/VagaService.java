package br.com.sesse.AppRh.services;

import br.com.sesse.AppRh.dtos.VagaDto;
import br.com.sesse.AppRh.exceptions.VagaNotFoundException;
import br.com.sesse.AppRh.models.Vaga;
import br.com.sesse.AppRh.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public List<VagaDto> listarTodos() {
        return vagaRepository.findAll()
                .stream()
                .map(VagaDto::new)
                .collect(Collectors.toList());
    }

    public VagaDto buscarPorId(Long id) {
        Vaga vaga = vagaRepository.findById(id)
                .orElseThrow(() -> new VagaNotFoundException("Vaga não encontrada"));
        return new VagaDto(vaga);
    }

    public VagaDto salvar(VagaDto vagaDto) {
        Vaga vaga = new Vaga(vagaDto);
        vaga = vagaRepository.save(vaga);
        return new VagaDto(vaga);
    }

    public void deletar(Long id) {
        vagaRepository.deleteById(id);
    }
}
