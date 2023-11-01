package com.example.demo.v1.dtos;

import com.example.demo.v1.models.Institute;
import com.example.demo.v1.models.InstituteService;
import com.example.demo.v1.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitorsDTO {
    private User user;
    private InstituteService instituteService;
    private String visitDescription;
    private LocalTime startTime;
    private LocalTime endTime;
}
