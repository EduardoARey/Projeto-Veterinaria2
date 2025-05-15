package com.example.demo.dtos;

import java.util.List;

public class VeterinarioDTO {

    private Long id;
    private String nome;
    private String crmv;
    private String telefone;
    private String email;
    private List<Long> especieIds;

    public VeterinarioDTO() {}

    public VeterinarioDTO(Long id, String nome, String crmv, String telefone, String email, List<Long> especieIds) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
        this.email = email;
        this.especieIds = especieIds;
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

    public List<Long> getEspecieIds() {
        return especieIds;
    }

    public void setEspecieIds(List<Long> especieIds) {
        this.especieIds = especieIds;
    }

    
}
