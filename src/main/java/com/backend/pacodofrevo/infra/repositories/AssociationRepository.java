package com.backend.pacodofrevo.infra.repositories;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {

}
