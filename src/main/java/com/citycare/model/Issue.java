package com.citycare.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String description;
    private String title;
    private String status;
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy | hh:mm a", timezone = "Asia/Kolkata")
    private LocalDateTime createdAt;

    private Double longitude;
    private Double Latitude;
    private String AssignedTo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("issues")
    private User reportedBy;


    @ElementCollection
    private List<String> images;
}
