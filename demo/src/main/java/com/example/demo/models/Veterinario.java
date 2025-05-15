package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres")
    private String nome;

    @NotBlank(message = "CRMV é obrigatório")
    private String crmv;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone deve seguir o padrão (99)99999-9999")
    private String telefone;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @ManyToMany
    @JoinTable(
        name = "veterinario_especie",
        joinColumns = @JoinColumn(name = "veterinario_id"),
        inverseJoinColumns = @JoinColumn(name = "especie_id")
    )
    private List<Especie> especies;

    @OneToMany(mappedBy = "veterinario")
    private List<Consulta> consultas; 

    
    public Veterinario() {
    }

    
    public Veterinario(Long id, String nome, String crmv, String telefone, String email, List<Especie> especies,
                       List<Consulta> consultas) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
        this.email = email;
        this.especies = especies;
        this.consultas = consultas;
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


    public String getCrmv() {
        return crmv;
    }


    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public List<Especie> getEspecies() {
        return especies;
    }


    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }


    public List<Consulta> getConsultas() {
        return consultas;
    }


    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }


    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", crmv='" + crmv + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
