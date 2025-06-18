package br.com.sesse.AppRh.dtos;

import br.com.sesse.AppRh.models.Vaga;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record VagaDto(
        long codigo,
        String nome,
        String descricao,
        LocalDate data,
        BigDecimal salario,
        @JsonBackReference
        List<CandidatoDto> candidatos) {

    public VagaDto(Vaga vaga) {
        this(
                vaga.getCodigo(),
                vaga.getNome(),
                vaga.getDescricao(),
                vaga.getData(),
                vaga.getSalario(),
                vaga.getCandidatos() == null ? null : vaga.getCandidatos().stream()
                        .map(CandidatoDto::new)
                        .collect(Collectors.toList())
        );
    }
}
