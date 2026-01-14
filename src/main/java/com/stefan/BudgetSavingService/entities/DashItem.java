package com.stefan.BudgetSavingService.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dash_item")
public class DashItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String itemName;
    private String itemDescription;
    private Double installment;
    private Double currDebtAmount;
    private Double pastDebtAmount;
    private Double remainderAmount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;
}
