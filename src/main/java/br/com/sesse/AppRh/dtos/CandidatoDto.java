package br.com.sesse.AppRh.dtos;

import br.com.sesse.AppRh.models.Candidato;
import br.com.sesse.AppRh.models.Vaga;

public record CandidatoDto(
        long id,
        String rg,
        String nomeCandidato,
        String email,
        VagaDto vaga) {

    public CandidatoDto(Candidato candidato){
        this(
                candidato.getId(),
                candidato.getRg(),
                candidato.getNomeCandidato(),
                candidato.getEmail(),
                new VagaDto(candidato.getVaga())
        );
    }
}
