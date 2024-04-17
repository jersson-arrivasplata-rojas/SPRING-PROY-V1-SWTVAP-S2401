package com.jersson.arrivasplata.swtvap.api.web.model;

import com.jersson.arrivasplata.swtvap.api.web.enums.StatusContact;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "swtvap_contacts")
public class WContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long contactId;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String contact;

    @Column(length = 50)
    private String email;

    @Column(name="details", columnDefinition = "TEXT")
    private String details;

    @Enumerated(EnumType.ORDINAL)
    private StatusContact status;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;
}
