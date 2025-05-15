package com.example.demo.dtos;

import java.time.LocalDateTime;

public class ConsultaDTO {

    private Long id;
    private LocalDateTime dataHora;
    private String local;
    private String status;
    private Long animalId;
    private Long veterinarioId;
    private Long prontuarioId;

    public ConsultaDTO() {}

    public ConsultaDTO(Long id, LocalDateTime dataHora, String local, String status,
                       Long animalId, Long veterinarioId, Long prontuarioId) {
        this.id = id;
        this.dataHora = dataHora;
        this.local = local;
        this.status = status;
        this.animalId = animalId;
        this.veterinarioId = veterinarioId;
        this.prontuarioId = prontuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    
}
