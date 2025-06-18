package br.com.sesse.AppRh.controllers;

import br.com.sesse.AppRh.dtos.DependenteDto;
import br.com.sesse.AppRh.exceptions.DependenteNotFoundException;
import br.com.sesse.AppRh.models.Dependente;
import br.com.sesse.AppRh.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping
    public List<DependenteDto> listarDependentes() {
        return dependenteService.listarTodos()
                .stream()
                .map(DependenteDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Dependente criarDependente(@RequestBody @Valid Dependente dependente) {
        return dependenteService.salvar(dependente);
    }

    @GetMapping("/{id}")
    public DependenteDto buscarPorId(@PathVariable Long id) {
        Dependente dependente = dependenteService.buscarPorId(id)
                .orElseThrow(() -> new DependenteNotFoundException("Dependente não encontrado"));
        return new DependenteDto(dependente);
    }

    @DeleteMapping("/{id}")
    public void deletarDependente(@PathVariable Long id) {
        dependenteService.deletar(id);
    }
}
