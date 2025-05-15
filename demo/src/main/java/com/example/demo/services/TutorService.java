package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Tutor;
import com.example.demo.repositories.TutorRepository;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> buscarPorId(Long id) {
        return tutorRepository.findById(id);
    }

    public Tutor atualizar(Long id, Tutor tutorAtualizado) {
        Optional<Tutor> tutorOpt = tutorRepository.findById(id);
        if (!tutorOpt.isPresent()) {
            throw new IllegalArgumentException("Tutor não encontrado");
        }
        Tutor tutor = tutorOpt.get();

        tutor.setNome(tutorAtualizado.getNome());
        tutor.setTelefone(tutorAtualizado.getTelefone());
        tutor.setEmail(tutorAtualizado.getEmail());
        tutor.setEndereco(tutorAtualizado.getEndereco());
        tutor.setCpf(tutorAtualizado.getCpf());
        tutor.setSenha(tutorAtualizado.getSenha());

        return tutorRepository.save(tutor);
    }

    public boolean deletar(Long id) {
        Optional<Tutor> tutorOpt = tutorRepository.findById(id);
        if (tutorOpt.isPresent()) {
            tutorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
