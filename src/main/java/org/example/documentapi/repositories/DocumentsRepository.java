package org.example.documentapi.repositories;

import org.example.documentapi.entities.Documents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentsRepository extends CrudRepository<Documents, UUID> {
}
