package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.RegistroVacinacao;

@Repository
public interface RegistroVacinacaoRepository extends JpaRepository <RegistroVacinacao, Long> {

}
