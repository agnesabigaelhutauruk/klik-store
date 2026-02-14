package com.assignment.klik_store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreResponseDTO {

    private Long id;
    private String storeName;
    private String branchName;
    private String provinceName;
}