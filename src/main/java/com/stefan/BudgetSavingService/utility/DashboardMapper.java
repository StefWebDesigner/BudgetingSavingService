package com.stefan.BudgetSavingService.utility;

import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.requests.CreateDashProfileRequest;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import com.stefan.BudgetSavingService.responses.CreateDashProfileResponse;
import com.stefan.BudgetSavingService.responses.CreateDashboardResponse;
import org.springframework.stereotype.Component;

@Component
public class DashboardMapper {

    public CreateDashboardResponse createDashboardMapper(Dashboard dashboard){
        CreateDashboardResponse createDashboardResponse = CreateDashboardResponse.builder()
                .userId(dashboard.getUser().getId())
                .dashboardId(dashboard.getDashboardId())
                .dashboardName(dashboard.getDashboardName()).build();

        return createDashboardResponse;
    }

    public CreateDashProfileResponse createDashProfileMapper(DashProfile dashProfile){
        CreateDashProfileResponse createDashProfileResponse = CreateDashProfileResponse.builder()
                .dashProfile(dashProfile).build();
        return createDashProfileResponse;
    }


}
