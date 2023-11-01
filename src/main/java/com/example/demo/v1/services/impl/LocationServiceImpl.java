package com.example.demo.v1.services.impl;

import com.example.demo.v1.dtos.LocationDTO;
import com.example.demo.v1.models.Location;
import com.example.demo.v1.repositories.ILocationRepository;
import com.example.demo.v1.services.ILocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Location save(LocationDTO locationDTO) {
        Location location = modelMapper.map(locationDTO,Location.class);
        return locationRepository.save(location);
    }

    @Override
    public Location update(UUID id, LocationDTO locationDTO) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()){
            Location existingLocation = location.get();
            existingLocation.setCountry(locationDTO.getCountry());
            existingLocation.setCity(locationDTO.getCity());
            existingLocation.setDistrict(locationDTO.getDistrict());
            existingLocation.setSector(locationDTO.getSector());
            existingLocation.setAddressNumber(locationDTO.getAddressNumber());
            existingLocation.setZipCode(locationDTO.getZipCode());
            return locationRepository.save(existingLocation);
        }
        return null;
    }

    @Override
    public Optional<Location> getById(UUID id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public boolean delete(UUID id) {
        try{
            locationRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
