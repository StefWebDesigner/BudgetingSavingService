package com.stefan.BudgetSavingService.controller;

import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.requests.CreateDashProfileRequest;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import com.stefan.BudgetSavingService.responses.CreateDashProfileResponse;
import com.stefan.BudgetSavingService.responses.CreateDashboardResponse;
import com.stefan.BudgetSavingService.service.DashboardService;
import com.stefan.BudgetSavingService.utility.DashboardMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/v1/dashboard")
@AllArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;
    private final DashboardMapper dashboardMapper;

    @PostMapping("/createDashboard")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
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

    @PostMapping("/createProfile")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<CreateDashProfileResponse> createDashProfile(@RequestBody CreateDashProfileRequest createDashProfileRequest) throws Exception {
        CreateDashProfileResponse request = new  CreateDashProfileResponse();
        request = dashboardService.createProfile(createDashProfileRequest);
        if(request != null) {
//            return new ResponseEntity<>(dashboardMapper.createDashProfileMapper(request), HttpStatus.CREATED);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
