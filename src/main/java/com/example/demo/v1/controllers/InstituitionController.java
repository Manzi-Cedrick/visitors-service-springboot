package com.example.demo.v1.controllers;
import com.example.demo.v1.dtos.InstituteDTO;
import com.example.demo.v1.models.Institute;
import com.example.demo.v1.services.InstituteService;
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
@RequestMapping("/api/v1/instituition")
@Slf4j
@RequiredArgsConstructor
public class InstituitionController {
    private final InstituteService instituteService;
    @PostMapping
    public ApiResponse<Institute> save(
            @Valid @RequestBody InstituteDTO instituteDTO
    ) {
        Institute savedInstitute = instituteService.save(instituteDTO);
        if (savedInstitute != null){
            return new ApiResponse<>(savedInstitute,"Institute Registered successfully",HttpStatus.CREATED,true);
        }
        return new ApiResponse<>("Failure to add institute",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ApiResponse<List<Institute>> getAll() {
        List<Institute> institutes = instituteService.getAll();
        if (institutes != null){
            return new ApiResponse<>(institutes,"Institute retrieval successful",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure institute retrieval",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/{id}")
    public ApiResponse<Optional<Institute>> getById(@PathVariable(value = "id") UUID id){
        Optional<Institute> institute = instituteService.getById(id);
        if (institute.isPresent()){
            return new ApiResponse<>(institute,"Institute retrieval Successful!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to retrieve institute",null,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/{id}")
    public ApiResponse<Boolean> remove(@PathVariable(value = "id") UUID id){
        boolean deletionSuccessful = instituteService.delete(id);
        if(deletionSuccessful){
            return new ApiResponse<>(true,"Institute successfully delete!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to delete institute",null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/{id}")
    public ApiResponse<Institute> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody InstituteDTO instituteDTO
    ) {
        Institute updatedInstitute = instituteService.update(id,instituteDTO);
        return new ApiResponse<>(updatedInstitute,"Institute successfully updated !",HttpStatus.OK,true);
    }
}
