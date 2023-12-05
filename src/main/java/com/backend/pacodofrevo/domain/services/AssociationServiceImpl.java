package com.backend.pacodofrevo.domain.services;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import com.backend.pacodofrevo.infra.repositories.AssociationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public void deleteAssociation(Long id) {
        Optional<Association> existingAssociationEntity = associationRepository.findById(id);
        Association existingAssociation = existingAssociationEntity.get();
        associationRepository.delete(existingAssociation);
    }
}
