package com.example.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Consulta;
import com.example.demo.models.Veterinario;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByVeterinarioAndDataHora(Veterinario veterinario, LocalDateTime dataHora);
}

