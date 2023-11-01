package com.example.demo.v1.services.impl;

import com.example.demo.v1.dtos.InstituteDTO;
import com.example.demo.v1.models.Institute;
import com.example.demo.v1.models.Location;
import com.example.demo.v1.repositories.ILocationRepository;
import com.example.demo.v1.repositories.InstituteRepository;
import com.example.demo.v1.services.InstituteService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private ModelMapper modelMapperConfig;

    @Autowired
    private ILocationRepository locationRepository;
    @Override
    public Institute save(InstituteDTO instituteDTO) {
        Institute institute = modelMapperConfig.map(instituteDTO,Institute.class);
        Location location = locationRepository.findById(instituteDTO.getLocation().getId()).orElseThrow(()-> null);
        institute.setLocation(location);
        return instituteRepository.save(institute);
    }

    @Override
    @Transactional
    public boolean delete(UUID id) {
        try {
            instituteRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public Institute update(UUID id, InstituteDTO instituteDTO) {
        Optional<Institute> institute = instituteRepository.findById(id);
        if (institute.isPresent()){
            Institute institute1 = institute.get();
            institute1.setName(instituteDTO.getName());
            institute1.setEmail(instituteDTO.getEmail());
            institute1.setLocation(instituteDTO.getLocation());
            return instituteRepository.save(institute1);
        }
        return null;
    }

    @Override
    public List<Institute> getAll() {
        return instituteRepository.findAll();
    }

    @Override
    public Optional<Institute> getById(UUID id) {
        return instituteRepository.findById(id);
    }
}
