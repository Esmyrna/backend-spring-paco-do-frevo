package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String addressTo;

    private String email;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

    @OneToOne
    @JoinColumn(name = "associationId")
    private Association association;

    private String associationId;

    public void setCreationStamps(String userId) {
        this.createdBy = userId;
    }

    public void setUpdateStamps(String userId) {
        this.updatedBy = userId;
    }

    public boolean isValid() {
        throw new UnsupportedOperationException("Method not implemented.");
    }
}
