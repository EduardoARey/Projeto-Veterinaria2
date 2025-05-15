package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dtos.EspecieDTO;
import com.example.demo.services.EspecieService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> getAll() {
        return ResponseEntity.ok(especieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecieDTO> getById(@PathVariable Long id) {
        try {
            EspecieDTO dto = especieService.findById(id);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<EspecieDTO> create(@RequestBody EspecieDTO dto) {
        EspecieDTO created = especieService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecieDTO> update(@PathVariable Long id, @RequestBody EspecieDTO dto) {
        try {
            EspecieDTO updated = especieService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            especieService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
