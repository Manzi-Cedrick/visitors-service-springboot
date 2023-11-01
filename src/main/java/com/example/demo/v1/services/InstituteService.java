package com.example.demo.v1.services;

import com.example.demo.v1.dtos.InstituteDTO;
import com.example.demo.v1.models.Institute;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InstituteService {
    Institute save(InstituteDTO instituteDTO);
    boolean delete(UUID id);
    Institute update(UUID id,InstituteDTO instituteDTO);
    List<Institute> getAll();
    Optional<Institute> getById(UUID id);
}
