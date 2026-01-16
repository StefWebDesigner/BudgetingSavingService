package com.stefan.BudgetSavingService.repository;

import com.stefan.BudgetSavingService.entities.DashProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashProfileRepository extends JpaRepository<DashProfile, Integer> {
}
