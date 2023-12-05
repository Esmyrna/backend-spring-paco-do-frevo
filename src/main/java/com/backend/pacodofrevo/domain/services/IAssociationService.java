package com.backend.pacodofrevo.domain.services;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;

import java.util.List;
import java.util.Optional;

public interface IAssociationService {
    List<Association> getAll();
    Optional<Association> getById(Long id);
    Association createAssociation(Association association);
    void deleteAssociation(Long id);
}
