package com.example.demo.v1.services.impl;
import com.example.demo.v1.dtos.InstituteServiceDTO;
import com.example.demo.v1.models.Institute;
import com.example.demo.v1.models.InstituteService;
import com.example.demo.v1.repositories.InstituteRepository;
import com.example.demo.v1.repositories.InstituteServiceRepository;
import com.example.demo.v1.services.InstituteServiceService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstituteServiceServiceImpl implements InstituteServiceService {
    @Autowired
    private InstituteServiceRepository instituteServiceRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private InstituteRepository instituteRepository;
    @Override
    public InstituteService save(InstituteServiceDTO serviceDTO) {
        InstituteService service = modelMapper.map(serviceDTO, InstituteService.class);
        Institute institute = instituteRepository.findById(serviceDTO.getInstitute().getId()).orElseThrow(()->null);
        service.setInstitute(institute);
        return instituteServiceRepository.save(service);
    }

    @Override
    public InstituteService update(UUID id, InstituteServiceDTO instituteServiceDTO) {
        Optional<InstituteService> service = instituteServiceRepository.findById(id);
        if (service.isPresent()){
            InstituteService service1 = service.get();
            service1.setServiceName(instituteServiceDTO.getServiceName());
            service1.setServiceDescription(instituteServiceDTO.getServiceDescription());
            service1.setInstitute(instituteServiceDTO.getInstitute());
            return instituteServiceRepository.save(service1);
        }
        return null;
    }

    @Override
    public Optional<InstituteService> getById(UUID id) {
        return instituteServiceRepository.findById(id);
    }

    @Override
    public List<InstituteService> getAll() {
        return instituteServiceRepository.findAll();
    }

    @Override
    @Transactional
    public boolean delete(UUID id) {
        try {
            instituteServiceRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
