package com.assignment.klik_store.controller;

import com.assignment.klik_store.entity.Store;
import com.assignment.klik_store.entity.WhitelistStore;
import com.assignment.klik_store.repository.StoreRepository;
import com.assignment.klik_store.repository.WhitelistStoreRepository;
import com.assignment.klik_store.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;
    private final WhitelistStoreRepository whitelistStoreRepository;

    @GetMapping
    public Page<StoreResponseDTO> searchStores(
            @RequestParam String provinceName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        Page<Store> storePage = storeRepository.findByProvinceName(
                provinceName,
                PageRequest.of(page, size)
        );

        List<Store> provinceStores = storePage.getContent();

        List<Store> whitelistStores = whitelistStoreRepository.findAll()
                .stream()
                .map(WhitelistStore::getStore)
                .toList();

        Set<Store> combined = new LinkedHashSet<>();
        combined.addAll(whitelistStores);
        combined.addAll(provinceStores);

        List<StoreResponseDTO> dtoList = combined.stream()
                .map(store -> new StoreResponseDTO(
                        store.getId(),
                        store.getName(),
                        store.getBranch().getName(),
                        store.getBranch().getProvince().getName()
                ))
                .toList();

        return new PageImpl<>(
                dtoList,
                PageRequest.of(page, size),
                dtoList.size()
        );
    }
}