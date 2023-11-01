package com.example.demo.v1.repositories;

import com.example.demo.v1.models.InstituteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstituteServiceRepository extends JpaRepository<InstituteService, UUID> {
}
