package com.stefan.BudgetSavingService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate addedDate;
    private String profileName;

    @OneToOne
    @JoinColumn(name = "dashboard_id")
    @JsonManagedReference
    private Dashboard dashboard;
}
