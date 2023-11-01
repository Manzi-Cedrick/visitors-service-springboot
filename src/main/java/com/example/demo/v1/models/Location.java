package com.example.demo.v1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Country is required")
    private String country;

    private String city;

    private String district;

    private String sector;

    private String zipCode;

    private String addressNumber;

    public Location(String id){
        this.id = UUID.fromString(id);
    }
}
