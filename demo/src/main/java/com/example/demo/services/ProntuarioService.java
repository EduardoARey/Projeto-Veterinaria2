package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Prontuario;
import com.example.demo.repositories.ProntuarioRepository;

@Service
public class ProntuarioService {

    private final ProntuarioRepository repository;

    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public List<Prontuario> findAll() {
        return repository.findAll();
    }

    public Optional<Prontuario> findById(Long id) {
        return repository.findById(id);
    }

    public Prontuario save(Prontuario prontuario) {
        return repository.save(prontuario);
    }

    public Prontuario update(Long id, Prontuario prontuarioAtualizado) {
        return repository.findById(id)
            .map(prontuario -> {
                prontuario.setObservacoes(prontuarioAtualizado.getObservacoes());
                prontuario.setDataCriacao(prontuarioAtualizado.getDataCriacao());
                prontuario.setConsulta(prontuarioAtualizado.getConsulta());
                prontuario.setVacinasAplicadas(prontuarioAtualizado.getVacinasAplicadas());
                return repository.save(prontuario);
            })
            .orElseThrow(() -> new RuntimeException("Prontuario não encontrado para update: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
