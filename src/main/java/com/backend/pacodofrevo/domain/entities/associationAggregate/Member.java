package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
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
    private Association association;
    private String associationId;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

   
}
