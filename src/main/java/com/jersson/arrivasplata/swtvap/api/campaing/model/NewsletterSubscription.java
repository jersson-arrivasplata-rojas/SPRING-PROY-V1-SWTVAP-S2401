package com.jersson.arrivasplata.swtvap.api.campaing.model;

import com.jersson.arrivasplata.swtvap.api.campaing.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_newsletter_subscriptions")
public class NewsletterSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long newsletterSubscriptionId;

    @Column(length = 50)
    private String email;

    @Column(name = "subscribed_at")
    private LocalDate subscribedAt;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;
}