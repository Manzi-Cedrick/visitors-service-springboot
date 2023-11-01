package com.example.demo.v1.services;

import com.example.demo.v1.dtos.InstituteServiceDTO;
import com.example.demo.v1.models.InstituteService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InstituteServiceService {
    InstituteService save(InstituteServiceDTO instituteServiceDTO);
    InstituteService update(UUID id, InstituteServiceDTO instituteServiceDTO);
    Optional<InstituteService> getById(UUID id);
    List<InstituteService> getAll();
    boolean delete(UUID id);
}
