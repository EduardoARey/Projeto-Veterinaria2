package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.RegistroVacinacao;
import com.example.demo.repositories.RegistroVacinacaoRepository;

@Service
public class RegistroVacinacaoService {

    private final RegistroVacinacaoRepository registroVacinacaoRepository;

    public RegistroVacinacaoService(RegistroVacinacaoRepository registroVacinacaoRepository) {
        this.registroVacinacaoRepository = registroVacinacaoRepository;
    }

    public List<RegistroVacinacao> findAll() {
        return registroVacinacaoRepository.findAll();
    }

    public Optional<RegistroVacinacao> findById(Long id) {
        return registroVacinacaoRepository.findById(id);
    }

    public RegistroVacinacao save(RegistroVacinacao registroVacinacao) {
        return registroVacinacaoRepository.save(registroVacinacao);
    }

    public void deleteById(Long id) {
        registroVacinacaoRepository.deleteById(id);
    }
}
