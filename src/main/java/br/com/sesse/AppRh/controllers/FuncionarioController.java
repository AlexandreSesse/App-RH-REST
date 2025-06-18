package br.com.sesse.AppRh.controllers;

import br.com.sesse.AppRh.dtos.FuncionarioDto;
import br.com.sesse.AppRh.models.Funcionario;
import br.com.sesse.AppRh.services.FuncionarioService;
import br.com.sesse.AppRh.exceptions.FuncionarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDto> listarFuncionarios() {
        return funcionarioService.listarTodos()
                .stream()
                .map(FuncionarioDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @GetMapping("/{id}")
    public FuncionarioDto buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarPorId(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado"));
        return new FuncionarioDto(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletar(id);
    }
}
