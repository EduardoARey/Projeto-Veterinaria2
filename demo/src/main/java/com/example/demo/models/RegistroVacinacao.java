package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "registros_vacinacao")
// Design Pattern: Model (Entidade JPA)
public class RegistroVacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da vacina é obrigatório")
    @Size(min = 2, message = "Nome da vacina deve conter no mínimo 2 caracteres")
    private String nomeVacina;

    @NotNull(message = "Data de aplicação é obrigatória")
    private LocalDate dataAplicacao;

    @NotBlank(message = "Lote da vacina é obrigatório")
    private String lote;

    @FutureOrPresent(message = "A data da próxima dose deve ser futura ou atual")
    private LocalDate dataProximaDose;

    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id")
    @NotNull(message = "Animal é obrigatório")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;

    public RegistroVacinacao() {}

    public RegistroVacinacao(Long id, String nomeVacina, LocalDate dataAplicacao, String lote,
                              LocalDate dataProximaDose, Animal animal, Prontuario prontuario) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
        this.lote = lote;
        this.dataProximaDose = dataProximaDose;
        this.animal = animal;
        this.prontuario = prontuario;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getDataProximaDose() {
        return dataProximaDose;
    }

    public void setDataProximaDose(LocalDate dataProximaDose) {
        this.dataProximaDose = dataProximaDose;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        return "RegistroVacinacao{" +
                "id=" + id +
                ", nomeVacina='" + nomeVacina + '\'' +
                ", dataAplicacao=" + dataAplicacao +
                ", lote='" + lote + '\'' +
                ", dataProximaDose=" + dataProximaDose +
                ", animal=" + animal +
                ", prontuario=" + prontuario +
                '}';
    }
}
