package br.com.sesse.AppRh.dtos;

import br.com.sesse.AppRh.models.Dependente;
import java.time.LocalDate;

public record DependenteDto(
        long id,
        String cpf,
        String nome,
        LocalDate datanascimento,
        FuncionarioDto funcionario) {

    public DependenteDto(Dependente dependente){
        this(
                dependente.getId(),
                dependente.getCpf(),
                dependente.getNome(),
                dependente.getDatanascimento(),
                dependente.getFuncionario() != null ? new FuncionarioDto(dependente.getFuncionario()) : null
        );
    }
}
