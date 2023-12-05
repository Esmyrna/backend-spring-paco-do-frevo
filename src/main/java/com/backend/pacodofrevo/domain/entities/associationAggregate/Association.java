package com.backend.pacodofrevo.domain.entities.associationAggregate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "associations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date foundationDate;
    private String addressId;
    private ArrayList<String> colors;
    private String associationType;
    private int activeMembers;
    private boolean isSharedWithAResidence;
    private boolean hasOwnedHeadquarters;
    private boolean isLegalEntity;
    private String CNPJ;
    private boolean canIssueOwnReceipts;
    private String associationHistoryNotes;
    private Date createdAt;
    private Date UpdateAt;
    private String createdBy;
    private String updateBy;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "association_address_id")
    private AssociationAddresses address;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialNetwork> socialNetworks;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;

    @OneToMany(mappedBy = "association", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;
    

    public void setCreationStamps(String userId) {
        this.createdBy = userId;
    }

    public void setUpdateStamps(String userId) {
        this.updateBy = userId;
    }

    public boolean isValid() {
        throw new UnsupportedOperationException("Method not implemented.");
    }

}