package br.com.sesse.AppRh.controllers;

import br.com.sesse.AppRh.dtos.CandidatoDto;
import br.com.sesse.AppRh.exceptions.CandidatoNotFoundException;
import br.com.sesse.AppRh.models.Candidato;
import br.com.sesse.AppRh.services.CandidatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping
    public List<CandidatoDto> listarCandidatos() {
        return candidatoService.listarTodos()
                .stream()
                .map(CandidatoDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Candidato criarCandidato(@RequestBody @Valid Candidato candidato) {
        return candidatoService.salvar(candidato);
    }

    @GetMapping("/{id}")
    public CandidatoDto buscarPorId(@PathVariable Long id) {
        Candidato candidato = candidatoService.buscarPorId(id)
                .orElseThrow(() -> new CandidatoNotFoundException("Candidato não encontrado"));
        return new CandidatoDto(candidato);
    }

    @DeleteMapping("/{id}")
    public void deletarCandidato(@PathVariable Long id) {
        candidatoService.deletar(id);
    }
}