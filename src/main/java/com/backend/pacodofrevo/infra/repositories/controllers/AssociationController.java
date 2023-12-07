package com.backend.pacodofrevo.infra.repositories.controllers;

import com.backend.pacodofrevo.domain.entities.associationAggregate.Association;
import com.backend.pacodofrevo.domain.services.AssociationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/associations")

public class AssociationController {
    private final AssociationServiceImpl associationService;
    @Autowired
    public AssociationController(AssociationServiceImpl associationService) {
        this.associationService = associationService;
    }

    @GetMapping()
    public ResponseEntity<List<Association>> getAllAssociations() {
        List<Association> associations = associationService.getAll();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

   @PostMapping
    public ResponseEntity<Association> createAssociation(@RequestBody Association association) {
        Association createdAssociation = associationService.createAssociation(association);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Association> getAssociationById(@PathVariable String id) {
        try {
            Long associationId = Long.parseLong(id);
            Optional<Association> association = associationService.getById(associationId);
            return association.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Association> updateAssociation(@PathVariable String id, @RequestBody Association association) {
        try {
            Long associationId = Long.parseLong(id);
            Association updatedAssociation = associationService.updateAssociation(associationId, association);
            if (updatedAssociation != null) {
                return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable String id) {
        try {
            Long associationId = Long.parseLong(id);
            associationService.deleteAssociation(associationId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
