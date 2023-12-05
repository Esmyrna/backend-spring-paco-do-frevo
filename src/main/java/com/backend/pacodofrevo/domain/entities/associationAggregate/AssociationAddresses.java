package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "associations-addresses")
public class AssociationAddresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid")
    private String id;
    private String addressSite;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Association association;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
   
    private String createdBy;
    
    private String updatedBy;


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
