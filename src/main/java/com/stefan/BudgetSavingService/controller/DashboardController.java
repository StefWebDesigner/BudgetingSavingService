package com.stefan.BudgetSavingService.controller;

import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import com.stefan.BudgetSavingService.responses.CreateDashboardResponse;
import com.stefan.BudgetSavingService.service.DashboardService;
import com.stefan.BudgetSavingService.utility.DashboardMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dashboard")
@AllArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;
    private final DashboardMapper dashboardMapper;

    @PostMapping
    public ResponseEntity<CreateDashboardResponse> createDashboard(@RequestBody @Valid  CreateDashboardRequest requestedDashboard) throws Exception {
        Dashboard request = new Dashboard();
        request = dashboardService.createDashboard(requestedDashboard);
        if(request != null) {
            CreateDashboardResponse response = dashboardMapper.createDashboardMapper(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
