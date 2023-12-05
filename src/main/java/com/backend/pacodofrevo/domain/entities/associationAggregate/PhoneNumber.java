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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @ManyToOne
    @JoinColumn(name = "contactId", insertable = false, updatable = false)
    private Contact contact;
}
