package com.backend.pacodofrevo.domain.entities.associationAggregate;

import jakarta.persistence.*;

import java.util.Date;

public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String countryCode;
    private String areaCode;
    private String number;
    private String contactId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt")
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    @ManyToOne
    @JoinColumn(name = "contactId", insertable = false, updatable = false)
    private Contact contact;


}
