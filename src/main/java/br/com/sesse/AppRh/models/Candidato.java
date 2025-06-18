package br.com.sesse.AppRh.models;

import br.com.sesse.AppRh.dtos.CandidatoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "tb_candidatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(unique = true)
    private String rg;

    @NotEmpty
    private String nomeCandidato;

    @NotEmpty
    private String email;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    @JsonIgnore 
    private Vaga vaga;

    public Candidato(CandidatoDto candidatoDto) {
        this.id = candidatoDto.id();
        this.nomeCandidato = candidatoDto.nomeCandidato();
        this.email = candidatoDto.email();
    }
}