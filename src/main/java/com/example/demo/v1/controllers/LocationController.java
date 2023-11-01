package com.example.demo.v1.controllers;

import com.example.demo.v1.dtos.LocationDTO;
import com.example.demo.v1.dtos.UserDTO;
import com.example.demo.v1.models.Location;
import com.example.demo.v1.models.User;
import com.example.demo.v1.services.ILocationService;
import com.example.demo.v1.services.IUserService;
import com.example.demo.v1.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/location")
@Slf4j
@RequiredArgsConstructor
public class LocationController {
    private final ILocationService locationService;
    @PostMapping
    public ApiResponse<Location> save(
            @Valid @RequestBody LocationDTO locationDTO
    ) {
        Location savedLocation = locationService.save(locationDTO);
        if (savedLocation != null){
            return new ApiResponse<>(savedLocation,"Location Registered successfully",HttpStatus.CREATED,true);
        }
        return new ApiResponse<>("Failure to add location",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ApiResponse<List<Location>> getAll() {
        List<Location> locations = locationService.getAll();
        if (locations != null){
            return new ApiResponse<>(locations,"Locations retrieval successful",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure Location retrieval",null,HttpStatus.BAD_REQUEST);
    }
    @GetMapping(value = "/{id}")
    public ApiResponse<Optional<Location>> getById(@PathVariable(value = "id") UUID id){
        Optional<Location> location = locationService.getById(id);
        if (location.isPresent()){
            return new ApiResponse<>(location,"Location retrieval Successful!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to retrieve location",null,HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/{id}")
    public ApiResponse<Boolean> remove(@PathVariable(value = "id") UUID id){
        boolean deletionSuccessful = locationService.delete(id);
        if(deletionSuccessful){
            return new ApiResponse<>(true,"Location successfully delete!",HttpStatus.OK,true);
        }
        return new ApiResponse<>("Failure to delete location",null,HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/{id}")
    public ApiResponse<Location> update(
            @PathVariable(value = "id") UUID id,
            @Valid @RequestBody LocationDTO locationDTO
    ) {
        Location updatedLocation = locationService.update(id,locationDTO);
        return new ApiResponse<>(updatedLocation,"Location successfully updated !",HttpStatus.OK,true);
    }
}
