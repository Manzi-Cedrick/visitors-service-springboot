package com.example.demo.v1.services;

import com.example.demo.v1.dtos.LocationDTO;
import com.example.demo.v1.models.Location;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ILocationService {
    Location save(LocationDTO locationDTO);
    Location update(UUID id,LocationDTO locationDTO);
    Optional<Location> getById(UUID id);
    List<Location> getAll();
    boolean delete(UUID id);
}
