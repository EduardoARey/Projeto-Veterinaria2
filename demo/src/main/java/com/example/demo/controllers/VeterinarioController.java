package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Veterinario;
import com.example.demo.services.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Veterinario veterinario) {
        Veterinario salvo = veterinarioService.salvar(veterinario);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos() {
        return ResponseEntity.ok(veterinarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Veterinario> veterinario = veterinarioService.buscarPorId(id);
        if (veterinario.isPresent()) {
            return ResponseEntity.ok(veterinario.get());
        }
        return new ResponseEntity<>("Veterinário não encontrado", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Veterinario veterinarioAtualizado) {
        try {
            Veterinario atualizado = veterinarioService.atualizar(id, veterinarioAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deletado = veterinarioService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>("Veterinário não encontrado", HttpStatus.NOT_FOUND);
    }
}
