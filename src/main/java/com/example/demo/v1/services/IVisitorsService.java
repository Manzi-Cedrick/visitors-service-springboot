package com.example.demo.v1.services;

import com.example.demo.v1.dtos.VisitorsDTO;
import com.example.demo.v1.models.Visitors;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IVisitorsService {
    Visitors save(VisitorsDTO visitorsDTO);
    Visitors update(UUID id, VisitorsDTO visitorsDTO);
    Optional<Visitors> getById(UUID id);
    List<Visitors> getAll();
    boolean delete(UUID id);
}
