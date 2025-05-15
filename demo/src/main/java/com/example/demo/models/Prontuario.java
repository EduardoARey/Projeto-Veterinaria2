package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "prontuarios")
// Design Pattern: Model (entidade)
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Observações são obrigatórias")
    private String observacoes;

    @NotNull(message = "Data de criação é obrigatória")
    private LocalDateTime dataCriacao;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consulta_id", unique = true, nullable = false)
    private Consulta consulta;

    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroVacinacao> vacinasAplicadas;

    public Prontuario() {}

    public Prontuario(Long id, String observacoes, LocalDateTime dataCriacao, Consulta consulta,
                      List<RegistroVacinacao> vacinasAplicadas) {
        this.id = id;
        this.observacoes = observacoes;
        this.dataCriacao = dataCriacao;
        this.consulta = consulta;
        this.vacinasAplicadas = vacinasAplicadas;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<RegistroVacinacao> getVacinasAplicadas() {
        return vacinasAplicadas;
    }

    public void setVacinasAplicadas(List<RegistroVacinacao> vacinasAplicadas) {
        this.vacinasAplicadas = vacinasAplicadas;
    }

    @Override
    public String toString() {
        // Evitar imprimir coleções grandes ou objetos relacionados para não causar loop
        return "Prontuario{" +
                "id=" + id +
                ", observacoes='" + observacoes + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", consultaId=" + (consulta != null ? consulta.getId() : "null") +
                ", vacinasAplicadasCount=" + (vacinasAplicadas != null ? vacinasAplicadas.size() : 0) +
                '}';
    }
}
