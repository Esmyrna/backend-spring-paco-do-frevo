package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String role;
    private int actuationTimeInMonths;
    private boolean isFrevoTheMainRevenueIncome;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getActuationTimeInMonths() {
        return actuationTimeInMonths;
    }

    public void setActuationTimeInMonths(int actuationTimeInMonths) {
        this.actuationTimeInMonths = actuationTimeInMonths;
    }

    public boolean isFrevoTheMainRevenueIncome() {
        return isFrevoTheMainRevenueIncome;
    }

    public void setFrevoTheMainRevenueIncome(boolean frevoTheMainRevenueIncome) {
        isFrevoTheMainRevenueIncome = frevoTheMainRevenueIncome;
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
