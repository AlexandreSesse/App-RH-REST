package br.com.sesse.AppRh.models;

import br.com.sesse.AppRh.dtos.VagaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_vagas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Usar identidade se o banco suportar
    private long codigo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private LocalDate data;

    @NotNull
    private BigDecimal salario;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Candidato> candidatos;

    public Vaga(VagaDto vaga) {
        this.codigo = vaga.codigo();
        this.nome = vaga.nome();
        this.descricao = vaga.descricao();
        this.data = vaga.data();
        this.salario = vaga.salario();
    }
}
