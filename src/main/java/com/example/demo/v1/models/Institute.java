package com.example.demo.v1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "institutes")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Institute {
    @Id
    @Column(name = "institutes_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Institute name required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "institutes_location"
    )
    private Location location;

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
    public Institute(String id){
        this.id = UUID.fromString(id);
    }
}
