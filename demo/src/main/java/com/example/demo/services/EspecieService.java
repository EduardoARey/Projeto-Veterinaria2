package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.EspecieDTO;
import com.example.demo.models.Especie;
import com.example.demo.repositories.EspecieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EspecieService {

    private final EspecieRepository especieRepository;

    // Injeção de dependência via construtor
    public EspecieService(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    // Converter model para DTO
    private EspecieDTO toDTO(Especie especie) {
        return new EspecieDTO(especie.getId(), especie.getNome(), especie.getDescricao());
    }

    // Converter DTO para model
    private Especie toEntity(EspecieDTO dto) {
        Especie especie = new Especie();
        especie.setId(dto.getId());
        especie.setNome(dto.getNome());
        especie.setDescricao(dto.getDescricao());
        return especie;
    }

    public List<EspecieDTO> findAll() {
        List<Especie> especies = especieRepository.findAll();
        return especies.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public EspecieDTO findById(Long id) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Espécie não encontrada com id: " + id));
        return toDTO(especie);
    }

    public EspecieDTO create(EspecieDTO dto) {
        Especie especie = toEntity(dto);
        especie.setId(null); // garantir criação
        especie = especieRepository.save(especie);
        return toDTO(especie);
    }

    public EspecieDTO update(Long id, EspecieDTO dto) {
        Especie especie = especieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Espécie não encontrada com id: " + id));
        especie.setNome(dto.getNome());
        especie.setDescricao(dto.getDescricao());
        especie = especieRepository.save(especie);
        return toDTO(especie);
    }

    public void delete(Long id) {
        if (!especieRepository.existsById(id)) {
            throw new EntityNotFoundException("Espécie não encontrada com id: " + id);
        }
        especieRepository.deleteById(id);
    }
}
