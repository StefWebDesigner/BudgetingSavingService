package com.stefan.BudgetSavingService.responses;

import com.stefan.BudgetSavingService.entities.DashItem;
import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDashProfileResponse {
    private Integer userId;

    //Dashboard
    private Integer dashboardId;
    private String dashboardName;
    private DashProfile dashProfile;



    //DashProfile
    private Double income;
    private String profileName;
    private Dashboard dashboard;
}
