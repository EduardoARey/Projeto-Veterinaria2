package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.models.Veterinario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}
