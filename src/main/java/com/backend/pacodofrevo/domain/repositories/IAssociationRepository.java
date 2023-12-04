package com.backend.pacodofrevo.domain.repositories;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import java.util.List;
import java.util.Optional;

public interface IAssociationRepository {
    List<Association> findAll();
    Optional<Association> findById(String id);
    Association save(Association association);
    void delete(String id);
}
