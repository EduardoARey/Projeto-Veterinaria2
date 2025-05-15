package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Veterinario;
import com.example.demo.repositories.VeterinarioRepository;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    public Veterinario salvar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    public Optional<Veterinario> buscarPorId(Long id) {
        return veterinarioRepository.findById(id);
    }

    public Veterinario atualizar(Long id, Veterinario veterinarioAtualizado) {
        Optional<Veterinario> veterinarioOpt = veterinarioRepository.findById(id);
        if (!veterinarioOpt.isPresent()) {
            throw new IllegalArgumentException("Veterinário não encontrado");
        }
        Veterinario veterinario = veterinarioOpt.get();

        veterinario.setNome(veterinarioAtualizado.getNome());
        veterinario.setCrmv(veterinarioAtualizado.getCrmv());
        veterinario.setTelefone(veterinarioAtualizado.getTelefone());
        veterinario.setEmail(veterinarioAtualizado.getEmail());
        veterinario.setEspecies(veterinarioAtualizado.getEspecies());
        

        return veterinarioRepository.save(veterinario);
    }

    public boolean deletar(Long id) {
        Optional<Veterinario> veterinarioOpt = veterinarioRepository.findById(id);
        if (veterinarioOpt.isPresent()) {
            veterinarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}