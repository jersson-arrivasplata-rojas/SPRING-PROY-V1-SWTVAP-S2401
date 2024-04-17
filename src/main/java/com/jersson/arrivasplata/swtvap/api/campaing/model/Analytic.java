package com.jersson.arrivasplata.swtvap.api.campaing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_analytics")
public class Analytic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long analyticId;

    @Column(name = "visited_page", length = 250)
    private String visitedPage;

    @Column(name = "visited_date")
    private LocalDate visitedDate;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;
}