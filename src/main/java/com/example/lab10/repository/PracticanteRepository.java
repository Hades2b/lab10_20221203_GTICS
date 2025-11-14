package com.example.lab10.repository;

import com.example.lab10.entity.Practicante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticanteRepository extends JpaRepository<Practicante,Integer> {
}
