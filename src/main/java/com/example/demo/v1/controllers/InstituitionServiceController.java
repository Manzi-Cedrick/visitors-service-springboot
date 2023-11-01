package com.example.demo.v1.controllers;
import com.example.demo.v1.dtos.InstituteServiceDTO;
import com.example.demo.v1.models.InstituteService;
import com.example.demo.v1.services.InstituteServiceService;
import com.example.demo.v1.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/instituition-services")
@Slf4j
@RequiredArgsConstructor
public class InstituitionServiceController {
    private final InstituteServiceService instituteServiceService;
    @PostMapping
    public ApiResponse<InstituteService> save(
            @Valid @RequestBody InstituteServiceDTO instituteServiceDTO
    ) {
        InstituteService savedService = instituteServiceService.save(instituteServiceDTO);
        if (savedService != null){
            return new ApiResponse<>(savedService,"Institute Service Registered successfully",HttpStatus.CREATED,true);
        }
        return new ApiResponse<>("Failure to record service",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ApiResponse<List<InstituteService>> getAll() {
        List<InstituteService> services = instituteServiceService.getAll();
        if (services != null){
            return new ApiResponse<>(services,"Services retrieval successful",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure service retrieval",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/{id}")
    public ApiResponse<Optional<InstituteService>> getById(@PathVariable(value = "id") UUID id){
        Optional<InstituteService> service = instituteServiceService.getById(id);
        if (service.isPresent()){
            return new ApiResponse<>(service,"Service retrieval Successful!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to retrieve service",null,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/{id}")
    public ApiResponse<Boolean> remove(@PathVariable(value = "id") UUID id){
        boolean deletionSuccessful = instituteServiceService.delete(id);
        if(deletionSuccessful){
            return new ApiResponse<>(true,"Institute successfully delete!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to delete institute",null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/{id}")
    public ApiResponse<InstituteService> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody InstituteServiceDTO instituteServiceDTO
    ) {
        InstituteService updatedService = instituteServiceService.update(id,instituteServiceDTO);
        return new ApiResponse<>(updatedService,"Service successfully updated !",HttpStatus.OK,true);
    }
}
