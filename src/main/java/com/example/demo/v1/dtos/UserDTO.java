package com.example.demo.v1.dtos;

import com.example.demo.v1.enumerations.EGender;
import com.example.demo.v1.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
    private EGender gender;
    private Role role;
}
