package com.example.demo.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class ProntuarioDTO {

    private Long id;
    private String observacoes;
    private LocalDateTime dataCriacao;
    private Long consultaId;
    private List<Long> vacinasAplicadasIds;

    public ProntuarioDTO() {}

    public ProntuarioDTO(Long id, String observacoes, LocalDateTime dataCriacao, Long consultaId, List<Long> vacinasAplicadasIds) {
        this.id = id;
        this.observacoes = observacoes;
        this.dataCriacao = dataCriacao;
        this.consultaId = consultaId;
        this.vacinasAplicadasIds = vacinasAplicadasIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public List<Long> getVacinasAplicadasIds() {
        return vacinasAplicadasIds;
    }

    public void setVacinasAplicadasIds(List<Long> vacinasAplicadasIds) {
        this.vacinasAplicadasIds = vacinasAplicadasIds;
    }

    
}
