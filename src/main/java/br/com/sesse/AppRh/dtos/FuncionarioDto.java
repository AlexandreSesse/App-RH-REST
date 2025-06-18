package br.com.sesse.AppRh.dtos;

import br.com.sesse.AppRh.models.Funcionario;
import java.time.LocalDate;

public record FuncionarioDto(
        long id,
        String nome,
        LocalDate data,
        String email) {

    public FuncionarioDto(Funcionario funcionario) {
        this(funcionario.getId(), funcionario.getNome(), funcionario.getData(), funcionario.getEmail());
    }
}
