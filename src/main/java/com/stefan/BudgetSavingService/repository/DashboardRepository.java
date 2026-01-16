package com.stefan.BudgetSavingService.repository;

import com.stefan.BudgetSavingService.entities.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Integer> {

//    @Query(value = """
//        update Dashboard set profile_id = :profileId where dashboard_id = :dashboardId
//     """)
//    Dashboard updateDashboard(@Param("profileId") int profileId, @Param("dashboardId") int dashboardId);


//    @Modifying
//    @Query(value = """
//        update Dashboard d set d.profile_id = :profileId where d.dashboard_Id = :dashboardId
//     """)
//    void updateDashboard(@Param("profileId") int profileId, @Param("dashboardId") int dashboardId);

}
