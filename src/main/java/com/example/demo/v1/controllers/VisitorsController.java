package com.example.demo.v1.controllers;
import com.example.demo.v1.dtos.InstituteDTO;
import com.example.demo.v1.dtos.VisitorsDTO;
import com.example.demo.v1.models.Institute;
import com.example.demo.v1.models.Visitors;
import com.example.demo.v1.services.IVisitorsService;
import com.example.demo.v1.services.InstituteService;
import com.example.demo.v1.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/visitors")
@Slf4j
@RequiredArgsConstructor
public class VisitorsController{
    private final IVisitorsService visitorsService;
    @PostMapping
    public ApiResponse<Visitors> save(
            @Valid @RequestBody VisitorsDTO visitorsDTO
    ) {
        Visitors savedVisitor = visitorsService.save(visitorsDTO);
        if (savedVisitor != null){
            return new ApiResponse<>(savedVisitor,"Visitor Registered successfully",HttpStatus.CREATED,true);
        }
        return new ApiResponse<>("Failure to record visit",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ApiResponse<List<Visitors>> getAll() {
        List<Visitors> visitors = visitorsService.getAll();
        if (visitors != null){
            return new ApiResponse<>(visitors,"Visits retrieval successful",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure visit retrieval",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/{id}")
    public ApiResponse<Optional<Visitors>> getById(@PathVariable(value = "id") UUID id){
        Optional<Visitors> visitor = visitorsService.getById(id);
        if (visitor.isPresent()){
            return new ApiResponse<>(visitor,"Visit retrieval Successful!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to retrieve visit",null,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/{id}")
    public ApiResponse<Boolean> remove(@PathVariable(value = "id") UUID id){
        boolean deletionSuccessful = visitorsService.delete(id);
        if(deletionSuccessful){
            return new ApiResponse<>(true,"Visit successfully delete!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to delete visit",null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/{id}")
    public ApiResponse<Visitors> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody VisitorsDTO visitorsDTO
    ) {
        Visitors updatedVisitor = visitorsService.update(id,visitorsDTO);
        return new ApiResponse<>(updatedVisitor,"Visitor successfully updated !",HttpStatus.OK,true);
    }
}