package com.example.demo.dtos;

import java.time.LocalDate;

public class AnimalDTO {

    private Long id;
    private String nome;
    private Long especieId;
    private String raca;
    private LocalDate dataNascimento;
    private Long tutorId;
    

    public AnimalDTO() {}

    public AnimalDTO(Long id, String nome, Long especieId, String raca, LocalDate dataNascimento, Long tutorId) {
        this.id = id;
        this.nome = nome;
        this.especieId = especieId;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.tutorId = tutorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    
}
