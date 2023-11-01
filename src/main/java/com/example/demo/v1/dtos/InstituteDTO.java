package com.example.demo.v1.dtos;

import com.example.demo.v1.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstituteDTO {
    private String name;
    private String email;
    private Location location;
}