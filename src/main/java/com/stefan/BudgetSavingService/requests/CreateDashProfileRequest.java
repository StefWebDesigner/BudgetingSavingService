package com.stefan.BudgetSavingService.requests;

import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import lombok.*;
import org.springframework.context.annotation.Profile;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDashProfileRequest {
    private Integer userId;
    private Integer dashboardId;
    private DashProfile dashProfile;
}
