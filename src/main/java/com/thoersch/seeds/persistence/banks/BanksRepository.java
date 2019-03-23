package com.thoersch.seeds.persistence.banks;

import com.thoersch.seeds.representations.banks.Banks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanksRepository extends JpaRepository<Banks, Long> {
}
