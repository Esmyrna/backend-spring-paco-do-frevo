package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "social-networks")
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String socialNetworkType;
    private String url;
    private String createdBy;
    private String updatedBy;
    private Date createdAt;
    private Date updatedAt;

    public Association getAssociation() {
        return association;
    }
    public void setAssociation(Association association) {
        this.association = association;
    }
    @ManyToOne
    @JoinColumn(name = "associationId")
    private Association association;

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
       return  this.id = id;
    }

    public String getSocialNetworkType() {
        return socialNetworkType;
    }

    public void setSocialNetworkType(String socialNetworkType) {
        this.socialNetworkType = socialNetworkType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
