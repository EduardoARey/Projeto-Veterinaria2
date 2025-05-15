package com.example.demo.dtos;

import java.time.LocalDate;

public class RegistroVacinacaoDTO {

    private Long id;
    private String nomeVacina;
    private LocalDate dataAplicacao;
    private String lote;
    private LocalDate dataProximaDose;
    private Long animalId;
    private Long prontuarioId;

    public RegistroVacinacaoDTO() {}

    public RegistroVacinacaoDTO(Long id, String nomeVacina, LocalDate dataAplicacao, String lote, LocalDate dataProximaDose, Long animalId, Long prontuarioId) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
        this.lote = lote;
        this.dataProximaDose = dataProximaDose;
        this.animalId = animalId;
        this.prontuarioId = prontuarioId;
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

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }
}
