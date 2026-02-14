package com.assignment.klik_store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isDeleted = false;
}