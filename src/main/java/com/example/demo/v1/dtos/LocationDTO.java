package com.example.demo.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private String country;
    private String city;
    private String district;
    private String sector;
    private String zipCode;
    private String addressNumber;
}
