package com.assignment.klik_store.controller;

import com.assignment.klik_store.entity.Branch;
import com.assignment.klik_store.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchRepository branchRepository;

    @PutMapping("/{id}")
    public Branch updateBranch(@PathVariable Long id, @RequestBody Branch request) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setName(request.getName());
        return branchRepository.save(branch);
    }

    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Branch not found"));

        branch.setIsDeleted(true);
        branchRepository.save(branch);

        return "Branch soft deleted";
    }
}