package com.stefan.BudgetSavingService.responses;

import com.stefan.BudgetSavingService.entities.DashItem;
import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDashboardResponse {
    private Integer dashboardId;
    private String dashboardName;
    private Integer userId;
}
