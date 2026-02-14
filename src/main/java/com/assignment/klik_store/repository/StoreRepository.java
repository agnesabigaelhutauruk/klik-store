package com.assignment.klik_store.repository;

import com.assignment.klik_store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("""
        SELECT s FROM Store s
        JOIN s.branch b
        JOIN b.province p
        WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :provinceName, '%'))
        AND s.isActive = true
        AND s.isDeleted = false
        AND b.isDeleted = false
        AND p.isDeleted = false
    """)
    Page<Store> findByProvinceName(String provinceName, Pageable pageable);
}