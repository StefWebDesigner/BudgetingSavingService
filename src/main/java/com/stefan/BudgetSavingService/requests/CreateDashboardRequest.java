package com.stefan.BudgetSavingService.requests;

import com.stefan.BudgetSavingService.entities.DashItem;
import com.stefan.BudgetSavingService.entities.DashProfile;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDashboardRequest {
    @NotNull (message = "User Id can't be null")
    private Integer userId;
    @NotNull (message = "Dashboard name can't be null")
    @NotEmpty
    private String dashboardName;
    private List<DashItem> dashItem;
    private DashProfile dashProfile;
}
