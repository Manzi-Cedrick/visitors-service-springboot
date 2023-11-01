package com.example.demo.v1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class Visitors {
    @Id
    @Column(name = "visitors")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(
            name = "visitors_users"
    )
    private User user;

    @OneToOne
    @JoinColumn(
            name = "visitors_institutes_services"
    )
    private InstituteService instituteService;

    private String visitDescription;

    private LocalTime startTime;

    private LocalTime endTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
        updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        updatedAt = new Date();
    }
    public Visitors(String id) {
        this.id = UUID.fromString(id);
    }
}
