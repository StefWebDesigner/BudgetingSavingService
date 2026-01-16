package com.stefan.BudgetSavingService.service;

import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.entities.User;
import com.stefan.BudgetSavingService.repository.DashProfileRepository;
import com.stefan.BudgetSavingService.repository.DashboardRepository;
import com.stefan.BudgetSavingService.repository.UserRepository;
import com.stefan.BudgetSavingService.requests.CreateDashProfileRequest;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import com.stefan.BudgetSavingService.responses.CreateDashProfileResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Slf4j
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final UserRepository userRepository;
    private final DashProfileRepository dashProfileRepository;

    public Dashboard createDashboard(CreateDashboardRequest requestedDashboard) throws Exception {
        User fetchUser = userRepository.findById(requestedDashboard.getUserId()).orElseThrow(() -> new Exception("User not found"));
        Dashboard savedDashboard = Dashboard.builder()
                .dashboardName(requestedDashboard.getDashboardName())
                .dashItem(null)
                .dashProfile(null)
                .user(fetchUser).build();
        Dashboard result = dashboardRepository.save(savedDashboard);
        log.info("Dashboard created successfully");
        log.info("result Dashboard : " + result );
        return result;
    }

@Transactional
public CreateDashProfileResponse createProfile(CreateDashProfileRequest request) throws Exception {
    User fetchUser = userRepository.findById(request.getUserId()).orElseThrow(() -> new Exception("User not found"));
    Dashboard fetchDashboard = dashboardRepository.findById(request.getDashboardId()).orElseThrow(() -> new Exception("Dashboard not found"));

    DashProfile newProfile = new DashProfile();
    newProfile.setIncome(request.getDashProfile().getIncome());
    newProfile.setProfileName(request.getDashProfile().getProfileName());
    newProfile.setAddedDate(LocalDate.now());
    newProfile.setDashboard(fetchDashboard);
    dashProfileRepository.save(newProfile);

    fetchDashboard.setDashboardId(fetchDashboard.getDashboardId());
    fetchDashboard.setDashProfile(newProfile);
    dashboardRepository.save(fetchDashboard);

    CreateDashProfileResponse response = new CreateDashProfileResponse();
        response.setUserId(fetchDashboard.getUser().getId());
        response.setDashboardId(fetchDashboard.getDashboardId());
        response.setIncome(request.getDashProfile().getIncome());
        response.setProfileName(request.getDashProfile().getProfileName());
        return response;
}


}
