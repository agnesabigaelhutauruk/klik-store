package com.assignment.klik_store.repository;

import com.assignment.klik_store.entity.WhitelistStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhitelistStoreRepository extends JpaRepository<WhitelistStore, Long> {
}