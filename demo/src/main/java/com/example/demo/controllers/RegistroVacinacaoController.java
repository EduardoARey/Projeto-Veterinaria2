package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.RegistroVacinacao;
import com.example.demo.services.RegistroVacinacaoService;

@RestController
@RequestMapping("/api/registros-vacinacao")
public class RegistroVacinacaoController {

    private final RegistroVacinacaoService registroVacinacaoService;

    public RegistroVacinacaoController(RegistroVacinacaoService registroVacinacaoService) {
        this.registroVacinacaoService = registroVacinacaoService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroVacinacao>> getAll() {
        List<RegistroVacinacao> lista = registroVacinacaoService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroVacinacao> getById(@PathVariable Long id) {
        Optional<RegistroVacinacao> registroOpt = registroVacinacaoService.findById(id);
        return registroOpt.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegistroVacinacao> create(@RequestBody RegistroVacinacao registro) {
        RegistroVacinacao salvo = registroVacinacaoService.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroVacinacao> update(@PathVariable Long id, @RequestBody RegistroVacinacao registro) {
        Optional<RegistroVacinacao> registroExistenteOpt = registroVacinacaoService.findById(id);
        if (!registroExistenteOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        registro.setId(id);
        RegistroVacinacao atualizado = registroVacinacaoService.save(registro);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<RegistroVacinacao> registroExistenteOpt = registroVacinacaoService.findById(id);
        if (!registroExistenteOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        registroVacinacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
