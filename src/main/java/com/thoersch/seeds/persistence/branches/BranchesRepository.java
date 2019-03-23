package com.thoersch.seeds.persistence.branches;

import com.thoersch.seeds.representations.branches.Branches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchesRepository extends JpaRepository<Branches, Long> {
	
	@Query("SELECT ifsc, branch FROM Branches where ifsc=?1")
	Branches findBranchByIfsc(String ifsc);
}