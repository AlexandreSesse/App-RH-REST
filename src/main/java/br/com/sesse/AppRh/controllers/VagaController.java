package br.com.sesse.AppRh.controllers;

import br.com.sesse.AppRh.dtos.VagaDto;
import br.com.sesse.AppRh.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<VagaDto> listarVagas() {
        return vagaService.listarTodos();
    }

    @PostMapping
    public VagaDto criarVaga(@RequestBody @Valid VagaDto vagaDto) {
        return vagaService.salvar(vagaDto);
    }

    @GetMapping("/{id}")
    public VagaDto buscarPorId(@PathVariable Long id) {
        return vagaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVaga(@PathVariable Long id) {
        vagaService.deletar(id);
    }
}
