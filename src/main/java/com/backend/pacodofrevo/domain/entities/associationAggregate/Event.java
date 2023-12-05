package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.TemporalType;

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
   
    private String eventType;
   
    private Date dateOfAccomplishment;
    
    private int participantsAmount;

    @ManyToOne
    @JoinColumn(name = "associationId")
    private Association association;

    private String associationId;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

  
}
