package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.AnimalDTO;
import com.example.demo.models.Animal;
import com.example.demo.models.Especie;
import com.example.demo.models.Tutor;
import com.example.demo.repositories.AnimalRepository;
import com.example.demo.repositories.EspecieRepository;
import com.example.demo.repositories.TutorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final EspecieRepository especieRepository;
    private final TutorRepository tutorRepository;

    public AnimalService(AnimalRepository animalRepository, EspecieRepository especieRepository, TutorRepository tutorRepository) {
        this.animalRepository = animalRepository;
        this.especieRepository = especieRepository;
        this.tutorRepository = tutorRepository;
    }

    @Transactional(readOnly = true)
    public List<AnimalDTO> findAll() {
        List<Animal> animais = animalRepository.findAll();
        return animais.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AnimalDTO findById(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado: " + id));
        return toDTO(animal);
    }

    @Transactional
    public AnimalDTO insert(AnimalDTO dto) {
        Animal animal = fromDTO(dto);
        animal = animalRepository.save(animal);
        return toDTO(animal);
    }

    @Transactional
    public AnimalDTO update(Long id, AnimalDTO dto) {
        try {
            Animal animal = animalRepository.getReferenceById(id);
            updateData(animal, dto);
            animal = animalRepository.save(animal);
            return toDTO(animal);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Animal não encontrado para atualização: " + id);
        }
    }

    public void delete(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal não encontrado para exclusão: " + id);
        }
        animalRepository.deleteById(id);
    }

    private AnimalDTO toDTO(Animal animal) {
        return new AnimalDTO(
                animal.getId(),
                animal.getNome(),
                animal.getEspecie().getId(),
                animal.getRaca(),
                animal.getDataNascimento(),
                animal.getTutor().getId()
        );
    }

    private Animal fromDTO(AnimalDTO dto) {
        Especie especie = especieRepository.findById(dto.getEspecieId())
                .orElseThrow(() -> new EntityNotFoundException("Espécie não encontrada: " + dto.getEspecieId()));

        Tutor tutor = tutorRepository.findById(dto.getTutorId())
                .orElseThrow(() -> new EntityNotFoundException("Tutor não encontrado: " + dto.getTutorId()));

        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setEspecie(especie);
        animal.setRaca(dto.getRaca());
        animal.setDataNascimento(dto.getDataNascimento());
        animal.setTutor(tutor);
        return animal;
    }

    private void updateData(Animal animal, AnimalDTO dto) {
        animal.setNome(dto.getNome());

        Especie especie = especieRepository.findById(dto.getEspecieId())
                .orElseThrow(() -> new EntityNotFoundException("Espécie não encontrada: " + dto.getEspecieId()));
        animal.setEspecie(especie);

        animal.setRaca(dto.getRaca());
        animal.setDataNascimento(dto.getDataNascimento());

        Tutor tutor = tutorRepository.findById(dto.getTutorId())
                .orElseThrow(() -> new EntityNotFoundException("Tutor não encontrado: " + dto.getTutorId()));
        animal.setTutor(tutor);
    }
}
