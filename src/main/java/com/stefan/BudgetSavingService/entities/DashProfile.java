package com.stefan.BudgetSavingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dash_profile")
public class DashProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer profileId;
    private Double income;
    private Date addedDate;

    @OneToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;
}
