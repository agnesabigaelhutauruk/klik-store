package com.assignment.klik_store.repository;

import com.assignment.klik_store.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}