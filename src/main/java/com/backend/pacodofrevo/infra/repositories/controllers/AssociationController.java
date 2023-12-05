package com.backend.pacodofrevo.infra.repositories.controllers;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import com.backend.pacodofrevo.domain.services.AssociationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class AssociationController {
    private final AssociationServiceImpl associationService;

    public AssociationController(AssociationServiceImpl associationService) {
        this.associationService = associationService;
    }

    @GetMapping
    public ResponseEntity<List<Association>> getAllAssociations() {
        List<Association> associations = associationService.getAll();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Association> getAssociationById(@PathVariable Long id) {
        Optional<Association> association = associationService.getById(id);
        return association.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   @PostMapping
    public ResponseEntity<Association> createAssociation(@RequestBody Association association) {
        Association createdAssociation = associationService.createAssociation(association);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Association> updateAssociation(@PathVariable Long id, @RequestBody Association association) {
        Association updatedAssociation = associationService.updateAssociation(id, association);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable Long id) {
        associationService.deleteAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
