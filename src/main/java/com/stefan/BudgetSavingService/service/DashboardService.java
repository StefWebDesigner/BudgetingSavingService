package com.stefan.BudgetSavingService.service;

import com.stefan.BudgetSavingService.entities.DashItem;
import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.entities.User;
import com.stefan.BudgetSavingService.repository.DashProfileRepository;
import com.stefan.BudgetSavingService.repository.DashboardRepository;
import com.stefan.BudgetSavingService.repository.UserRepository;
import com.stefan.BudgetSavingService.requests.CreateDashProfileRequest;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import com.stefan.BudgetSavingService.responses.CreateDashboardResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final UserRepository userRepository;
    private final DashProfileRepository dashProfileRepository;

    public Dashboard createDashboard(CreateDashboardRequest requestedDashboard) throws Exception {
        Optional<User> fetchUser = userRepository.findById(requestedDashboard.getUserId());
        System.out.println("fetchUser: " + fetchUser);

        if(fetchUser.isPresent()){
            Dashboard savedDashboard = Dashboard.builder()
                    .dashboardName(requestedDashboard.getDashboardName())
                    .dashItem(null)
                    .dashProfile(null)
                    .user(fetchUser.get()).build();
            Dashboard result = dashboardRepository.save(savedDashboard);
            log.info("Dashboard created successfully");
            log.info("result Dashboard : " + result );
            return result;
        } else {
            throw new Exception("The user does not exist");
        }
    }

//    public DashProfile createProfile(CreateDashProfileRequest createDashProfileRequest) throws Exception {
//        Optional<Dashboard> fetchDashboard = dashboardRepository.findById(createDashProfileRequest.getDashboardId());
//        if(fetchDashboard.isPresent()){
//            Optional<DashProfile> fetchProfile = dashProfileRepository.findById(createDashProfileRequest.getDashProfile().getProfileId());
//            if(fetchProfile.isEmpty()){
//                DashProfile savedProfile = DashProfile.builder()
//                        .income(createDashProfileRequest.getDashProfile().getIncome())
//                        .addedDate(LocalDate.now())
//                        .profileName(createDashProfileRequest.getDashProfile().getProfileName())
//                        .dashboard(fetchDashboard.get()).build();
//                DashProfile result = dashProfileRepository.save(savedProfile);
//                return result;
//            } else {
//                throw new Exception("The profile already exists");
//            }
//        } else {
//            throw new Exception("The dashboard does not exist");
//        }
//    }

//    public DashProfile createProfile(DashProfile dashProfile, Integer dashboardId, Integer userId) throws Exception {
//        Optional<User> fetchUser = userRepository.findById(userId);
//        if (fetchUser.isPresent()) {
//            Optional<Dashboard> fetchDashboard = dashboardRepository.findById(dashboardId);
//            if (fetchDashboard.isPresent()) {
//
//                DashProfile savedProfile = DashProfile.builder()
//                        .income(dashProfile.getIncome())
//                        .addedDate(LocalDate.now())
//                        .profileName(dashProfile.getProfileName())
//                        .dashboard(fetchDashboard.get()).build();
//
//                Dashboard savedDashboard = Dashboard.builder()
//                        .dashboardId(fetchDashboard.get().getDashboardId())
//                        .dashboardName(fetchDashboard.get().getDashboardName())
//                        .dashItem(null)
//                        .dashProfile(savedProfile)
//                        .user(fetchDashboard.get().getUser()).build();
//
//                User savedUser = User.builder()
//                        .id(fetchUser.get().getId())
//                        .firstname(fetchUser.get().getFirstname())
//                        .lastname(fetchUser.get().getLastname())
//                        .email(fetchUser.get().getEmail())
//                        .password(fetchUser.get().getPassword())
//                        .role(fetchUser.get().getRole())
//                        .tokens(fetchUser.get().getTokens())
//                        .dashboardList(fetchUser.get().getDashboardList())
//                        .build();
//                userRepository.save(savedUser);
//
//                dashboardRepository.save(savedDashboard);
//                return dashProfileRepository.save(savedProfile);
//            } else {
//                throw new Exception("The user does not exist");
//            }
//        }
//        throw new Exception("The user does not exist");
//    }


//    public CreateDashboardResponse createProfile(CreateDashProfileRequest createDashProfileRequest) throws Exception {
//        CreateDashboardResponse response = new CreateDashboardResponse();
////        Dashboard fetchDashboard = dashboardRepository.findById(createDashProfileRequest.getDashboardId()).get();
//        Optional<Dashboard> fetchDashboard = dashboardRepository.findById(createDashProfileRequest.getDashboardId());
//        if(fetchDashboard.isPresent()){
//            DashProfile newProfile = new DashProfile();
//            newProfile.setIncome(createDashProfileRequest.getDashProfile().getIncome());
//            newProfile.setProfileName(createDashProfileRequest.getDashProfile().getProfileName());
//            newProfile.setAddedDate(LocalDate.now());
//            newProfile.setDashboard(fetchDashboard.get());
//
//            Dashboard updatedDashboard = new Dashboard();
//            updatedDashboard.setDashboardId(fetchDashboard.get().getDashboardId());
//            updatedDashboard.setDashboardName(fetchDashboard.get().getDashboardName());
//            updatedDashboard.setDashItem(null);
//            updatedDashboard.setDashProfile(newProfile);
//            updatedDashboard.setUser(fetchDashboard.get().getUser());
//
//            dashboardRepository.save(updatedDashboard);
//            dashProfileRepository.save(newProfile);
//
//            response.setUserId(fetchDashboard.get().getUser().getId());
//            response.setDashboardId(fetchDashboard.get().getDashboardId());
//            response.setDashboardName(fetchDashboard.get().getDashboardName());
//
//            return response;
//        } else {
//            throw new Exception("The user does not exist");
//        }
//
//    }

//    public CreateDashboardResponse createProfile(CreateDashProfileRequest request) throws Exception {
//        // 1. Retrieve the existing dashboard (managed by Hibernate)
//        Dashboard dashboard = dashboardRepository.findById(request.getDashboardId())
//                .orElseThrow(() -> new Exception("Dashboard not found for ID: " + request.getDashboardId()));
//
//        // 2. Create the new profile
//        DashProfile newProfile = new DashProfile();
//        newProfile.setIncome(request.getDashProfile().getIncome());
//        newProfile.setProfileName(request.getDashProfile().getProfileName());
//        newProfile.setAddedDate(LocalDate.now());
//
//        // 3. Link BOTH sides of the relationship
//        newProfile.setDashboard(dashboard);
//        dashboard.setDashProfile(newProfile);
//
//        // 4. Save only the necessary entities
//        // If Dashboard has CascadeType.ALL, saving dashboard will save newProfile too
//        dashboardRepository.save(dashboard);
//
//        // 5. Build and return response
//        CreateDashboardResponse response = new CreateDashboardResponse();
//        response.setUserId(dashboard.getUser().getId());
//        response.setDashboardId(dashboard.getDashboardId());
//        response.setDashboardName(dashboard.getDashboardName());
//        return response;
//    }

@Transactional
public CreateDashboardResponse createProfile(CreateDashProfileRequest request) throws Exception {
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

    CreateDashboardResponse response = new CreateDashboardResponse();
        response.setUserId(fetchDashboard.getUser().getId());
        response.setDashboardId(fetchDashboard.getDashboardId());
        response.setDashboardName(fetchDashboard.getDashboardName());
        return response;
}











//    userRepository.findById(requestedDashboard.getUserId())
//            .ifPresent(user -> {
//        // process the user
//    });

//    public Dashboard createDashboard(CreateDashboardRequest requestedDashboard) throws Exception {
//        Optional<User> fetchUser = userRepository.findById(requestedDashboard.getUserId());
//        fetchUser.ifPresent(user -> {
//                    Dashboard savedDashboard = Dashboard.builder()
//                            .dashboardName(requestedDashboard.getDashboardName())
//                            .dashItem(null)
//                            .dashProfile(null)
//                            .user(fetchUser.get()).build();
//                    Dashboard result = dashboardRepository.save(savedDashboard);
//                    log.info("Dashboard created successfully");
//                    log.info("result Dashboard : " + result );
//                    return result;
//                });
//
//        return null;
//
//
//
//
//    }

}
