package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String surname;

    private String role;

    private int actuationTimeInMonths;

    private boolean isFrevoTheMainRevenueIncome;

    private Association association;

    private String associationId;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

   
}
