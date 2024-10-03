package com.example.vcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vcm.model.Pessoal;

public interface PessoalRepository extends JpaRepository<Pessoal, Long> {
}
