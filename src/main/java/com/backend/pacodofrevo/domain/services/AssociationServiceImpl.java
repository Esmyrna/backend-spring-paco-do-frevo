package com.backend.pacodofrevo.domain.services;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import com.backend.pacodofrevo.domain.usecases.IAssociationService;
import com.backend.pacodofrevo.infra.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationServiceImpl implements IAssociationService {
    @Autowired
    private AssociationRepository associationRepository;

    public AssociationServiceImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public List<Association> getAll() {
        return associationRepository.findAll();
    }

    @Override
    public Optional<Association> getById(Long id) {
        return associationRepository.findById(id);
    }

    @Override
    public Association createAssociation(Association association) {
        association.getAddress().setAssociation(association);
        association.getEvents().forEach(event -> event.setAssociation(association));
        association.getMembers().forEach(member -> member.setAssociation(association));
        association.getSocialNetworks().forEach(socialNetwork -> socialNetwork.setAssociation(association));
        association.getContacts().forEach(contact -> {
            contact.setAssociation(association);
            contact.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setContact(contact));
        });

        return associationRepository.save(association);
    }

    @Override
    public Association updateAssociation(Long id, Association association) {
        Optional<Association> associationFromRepOptional = associationRepository.findById(id);

        if (associationFromRepOptional.isPresent()) {
            Association existingAssociation = associationFromRepOptional.get();

            existingAssociation.setName(association.getName());
            existingAssociation.setFoundationDate(association.getFoundationDate());
            existingAssociation.setColors(association.getColors());
            existingAssociation.setAssociationType(association.getAssociationType());
            existingAssociation.setActiveMembers(association.getActiveMembers());
            existingAssociation.setSharedWithAResidence(association.isSharedWithAResidence());
            existingAssociation.setHasOwnedHeadquarters(association.isHasOwnedHeadquarters());
            existingAssociation.setLegalEntity(association.isLegalEntity());
            existingAssociation.setCNPJ(association.getCNPJ());
            existingAssociation.setCanIssueOwnReceipts(association.isCanIssueOwnReceipts());
            existingAssociation.setAssociationHistoryNotes(association.getAssociationHistoryNotes());
            existingAssociation.setCreatedAt(association.getCreatedAt());
            existingAssociation.setUpdateAt(association.getUpdateAt());
            existingAssociation.setCreatedBy(association.getCreatedBy());
            existingAssociation.setUpdateBy(association.getUpdateBy());
            existingAssociation.setAddress(association.getAddress());
            existingAssociation.setSocialNetworks(association.getSocialNetworks());
            existingAssociation.setEvents(association.getEvents());
            existingAssociation.setMembers(association.getMembers());
            existingAssociation.setContacts(association.getContacts());

            existingAssociation.getAddress().setAssociation(existingAssociation);
            existingAssociation.getEvents().forEach(event -> event.setAssociation(existingAssociation));
            existingAssociation.getMembers().forEach(member -> member.setAssociation(existingAssociation));
            existingAssociation.getSocialNetworks().forEach(socialNetwork -> socialNetwork.setAssociation(existingAssociation));
            existingAssociation.getContacts().forEach(contact -> {
                contact.setAssociation(existingAssociation);
                contact.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setContact(contact));
            });

            return associationRepository.save(existingAssociation);
        }
        return null;
    }


    @Override
    public void deleteAssociation(Long id) {
        Optional<Association> existingAssociationEntity = associationRepository.findById(id);
        Association existingAssociation = existingAssociationEntity.get();
        associationRepository.delete(existingAssociation);
    }
}
