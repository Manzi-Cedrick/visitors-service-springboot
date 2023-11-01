package com.example.demo.v1.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class InstituteService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Service Required")
    private String serviceName;

    private String serviceDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "institute_service"
    )
    private Institute institute;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @PrePersist
    private void OnCreate(){
        createdAt = new Date();
        updatedAt = new Date();
    }
    @PreUpdate
    private void OnUpdate(){
        updatedAt = new Date();
    }
    public InstituteService(String id) {
        this.id = UUID.fromString(id);
    }
}
