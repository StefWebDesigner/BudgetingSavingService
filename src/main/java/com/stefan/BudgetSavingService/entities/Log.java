package com.stefan.BudgetSavingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logId;
    private Integer userId;
    private Integer dashboardId;
    private Integer itemId;
    private Integer profileId;
    private String action;
    private String loggedDate;
}
