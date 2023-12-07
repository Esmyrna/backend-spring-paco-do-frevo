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
    private AssociationAddress address;

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

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getAssociationType() {
        return associationType;
    }

    public void setAssociationType(String associationType) {
        this.associationType = associationType;
    }

    public int getActiveMembers() {
        return activeMembers;
    }

    public void setActiveMembers(int activeMembers) {
        this.activeMembers = activeMembers;
    }

    public boolean isSharedWithAResidence() {
        return isSharedWithAResidence;
    }

    public void setSharedWithAResidence(boolean sharedWithAResidence) {
        isSharedWithAResidence = sharedWithAResidence;
    }

    public boolean isHasOwnedHeadquarters() {
        return hasOwnedHeadquarters;
    }

    public void setHasOwnedHeadquarters(boolean hasOwnedHeadquarters) {
        this.hasOwnedHeadquarters = hasOwnedHeadquarters;
    }

    public boolean isLegalEntity() {
        return isLegalEntity;
    }

    public void setLegalEntity(boolean legalEntity) {
        isLegalEntity = legalEntity;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public boolean isCanIssueOwnReceipts() {
        return canIssueOwnReceipts;
    }

    public void setCanIssueOwnReceipts(boolean canIssueOwnReceipts) {
        this.canIssueOwnReceipts = canIssueOwnReceipts;
    }

    public String getAssociationHistoryNotes() {
        return associationHistoryNotes;
    }

    public void setAssociationHistoryNotes(String associationHistoryNotes) {
        this.associationHistoryNotes = associationHistoryNotes;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date updateAt) {
        UpdateAt = updateAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public AssociationAddress getAddress() {
        return address;
    }

    public void setAddress(AssociationAddress address) {
        this.address = address;
    }

    public List<SocialNetwork> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(List<SocialNetwork> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}