package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventType;
    private Date dateOfAccomplishment;
    private int participantsAmount;

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    @ManyToOne
    @JoinColumn(name = "associationId")
    @JsonBackReference
    private Association association;

    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getDateOfAccomplishment() {
        return dateOfAccomplishment;
    }

    public void setDateOfAccomplishment(Date dateOfAccomplishment) {
        this.dateOfAccomplishment = dateOfAccomplishment;
    }

    public int getParticipantsAmount() {
        return participantsAmount;
    }

    public void setParticipantsAmount(int participantsAmount) {
        this.participantsAmount = participantsAmount;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
