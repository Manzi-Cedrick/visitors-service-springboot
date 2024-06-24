package com.example.demo.v1.dtos;
import com.example.demo.v1.enumerations.EUserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {
    @NotBlank(message = "Role Required ! Name!")
    private EUserRole roleName;
}