package com.stefan.BudgetSavingService.service;

import com.stefan.BudgetSavingService.entities.DashItem;
import com.stefan.BudgetSavingService.entities.DashProfile;
import com.stefan.BudgetSavingService.entities.Dashboard;
import com.stefan.BudgetSavingService.entities.User;
import com.stefan.BudgetSavingService.repository.DashboardRepository;
import com.stefan.BudgetSavingService.repository.UserRepository;
import com.stefan.BudgetSavingService.requests.CreateDashboardRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class DashboardService {

    private final DashboardRepository dashboardRepository;
    private final UserRepository userRepository;

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
