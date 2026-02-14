package com.assignment.klik_store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isActive = true;
    private Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}