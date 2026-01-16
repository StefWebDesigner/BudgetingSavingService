package com.stefan.BudgetSavingService.repository;

import com.stefan.BudgetSavingService.entities.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer> {
}
