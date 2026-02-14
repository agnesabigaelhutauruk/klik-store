package com.assignment.klik_store.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WhitelistStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;
}