package com.stefan.BudgetSavingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dashboard")
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dashboardId;

    @OneToMany(mappedBy = "dashboard")
    private List<DashItem> dashItem;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private DashProfile dashProfile;
}
