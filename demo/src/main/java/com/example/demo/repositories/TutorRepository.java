package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
