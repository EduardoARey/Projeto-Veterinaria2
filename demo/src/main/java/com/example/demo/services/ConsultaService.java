package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.ConsultaDTO;
import com.example.demo.models.Animal;
import com.example.demo.models.Consulta;
import com.example.demo.models.Prontuario;
import com.example.demo.models.Veterinario;
import com.example.demo.repositories.AnimalRepository;
import com.example.demo.repositories.ConsultaRepository;
import com.example.demo.repositories.ProntuarioRepository;
import com.example.demo.repositories.VeterinarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;
    private final ProntuarioRepository prontuarioRepository;

    public ConsultaService(ConsultaRepository consultaRepository,
                           AnimalRepository animalRepository,
                           VeterinarioRepository veterinarioRepository,
                           ProntuarioRepository prontuarioRepository) {
        this.consultaRepository = consultaRepository;
        this.animalRepository = animalRepository;
        this.veterinarioRepository = veterinarioRepository;
        this.prontuarioRepository = prontuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<ConsultaDTO> findAll() {
        return consultaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ConsultaDTO findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada: " + id));
        return toDTO(consulta);
    }

    @Transactional
    public ConsultaDTO insert(ConsultaDTO dto) {
        Consulta consulta = fromDTO(dto);
        consulta = consultaRepository.save(consulta);
        return toDTO(consulta);
    }

    @Transactional
    public ConsultaDTO update(Long id, ConsultaDTO dto) {
        try {
            Consulta consulta = consultaRepository.getReferenceById(id);
            updateData(consulta, dto);
            consulta = consultaRepository.save(consulta);
            return toDTO(consulta);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Consulta não encontrada para atualização: " + id);
        }
    }

    public void delete(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new EntityNotFoundException("Consulta não encontrada para exclusão: " + id);
        }
        consultaRepository.deleteById(id);
    }

    private ConsultaDTO toDTO(Consulta consulta) {
        Long prontuarioId = consulta.getProntuario() != null ? consulta.getProntuario().getId() : null;
        return new ConsultaDTO(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getLocal(),
                consulta.getStatus(),
                consulta.getAnimal().getId(),
                consulta.getVeterinario().getId(),
                prontuarioId
        );
    }

    private Consulta fromDTO(ConsultaDTO dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado: " + dto.getAnimalId()));
        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinário não encontrado: " + dto.getVeterinarioId()));

        Prontuario prontuario = null;
        if (dto.getProntuarioId() != null) {
            prontuario = prontuarioRepository.findById(dto.getProntuarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Prontuário não encontrado: " + dto.getProntuarioId()));
        }

        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setLocal(dto.getLocal());
        consulta.setStatus(dto.getStatus());
        consulta.setAnimal(animal);
        consulta.setVeterinario(veterinario);
        consulta.setProntuario(prontuario);
        return consulta;
    }

    private void updateData(Consulta consulta, ConsultaDTO dto) {
        consulta.setDataHora(dto.getDataHora());
        consulta.setLocal(dto.getLocal());
        consulta.setStatus(dto.getStatus());

        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado: " + dto.getAnimalId()));
        consulta.setAnimal(animal);

        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinário não encontrado: " + dto.getVeterinarioId()));
        consulta.setVeterinario(veterinario);

        if (dto.getProntuarioId() != null) {
            Prontuario prontuario = prontuarioRepository.findById(dto.getProntuarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Prontuário não encontrado: " + dto.getProntuarioId()));
            consulta.setProntuario(prontuario);
        } else {
            consulta.setProntuario(null);
        }
    }
}
