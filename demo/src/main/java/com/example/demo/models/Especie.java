package com.example.demo.models;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "especies")
// Design Pattern: Model
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da espécie é obrigatório")
    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "especie", fetch = FetchType.LAZY)
    private List<Animal> animais;

    public Especie() {}

    public Especie(Long id, String nome, String descricao, List<Animal> animais) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.animais = animais;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    @Override
    public String toString() {
        // Não imprime a lista animais para evitar recursão infinita
        return "Especie [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
    }
}
