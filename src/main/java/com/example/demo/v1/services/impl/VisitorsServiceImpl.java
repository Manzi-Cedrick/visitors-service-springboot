package com.example.demo.v1.services.impl;

import com.example.demo.v1.dtos.VisitorsDTO;
import com.example.demo.v1.models.InstituteService;
import com.example.demo.v1.models.User;
import com.example.demo.v1.models.Visitors;
import com.example.demo.v1.repositories.IUserRepository;
import com.example.demo.v1.repositories.IVisitorsRepository;
import com.example.demo.v1.repositories.InstituteServiceRepository;
import com.example.demo.v1.services.IVisitorsService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VisitorsServiceImpl implements IVisitorsService {
    @Autowired
    private IVisitorsRepository visitorsRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private InstituteServiceRepository instituteServiceRepository;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Visitors save(VisitorsDTO visitorsDTO) {
        Visitors visitor = modelMapper.map(visitorsDTO,Visitors.class);
        User user = userRepository.findById(visitorsDTO.getUser().getId()).orElseThrow(()->null);
        InstituteService instituteService = instituteServiceRepository.findById(visitorsDTO.getInstituteService().getId()).orElseThrow(()->null);
        visitor.setInstituteService(instituteService);
        visitor.setUser(user);
        return visitorsRepository.save(visitor);
    }

    @Override
    public Visitors update(UUID id, VisitorsDTO visitorsDTO) {
        Optional<Visitors> visitor = visitorsRepository.findById(id);
        if (visitor.isPresent()){
            Visitors existingVisitor = visitor.get();
            existingVisitor.setStartTime(visitorsDTO.getStartTime());
            existingVisitor.setEndTime(visitorsDTO.getEndTime());
            existingVisitor.setInstituteService(visitorsDTO.getInstituteService());
            existingVisitor.setUser(visitorsDTO.getUser());
            return visitorsRepository.save(existingVisitor);
        }
        return null;
    }

    @Override
    public Optional<Visitors> getById(UUID id) {
        return visitorsRepository.findById(id);
    }

    @Override
    public List<Visitors> getAll() {
        return visitorsRepository.findAll();
    }

    @Override
    @Transactional
    public boolean delete(UUID id) {
        try {
            visitorsRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
