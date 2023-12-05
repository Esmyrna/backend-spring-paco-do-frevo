package com.backend.pacodofrevo.infra.repositories;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import com.backend.pacodofrevo.domain.repositories.IAssociationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, String>, IAssociationRepository {
    List<Association> findAll();
    Optional<Association> findById(Long id);
    Association save(Association association);
    void delete(Long id);
}
