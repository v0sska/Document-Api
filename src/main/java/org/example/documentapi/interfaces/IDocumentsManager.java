package org.example.documentapi.interfaces;

import org.example.documentapi.dtos.DocumentsDto;
import org.example.documentapi.entities.Documents;
import org.example.documentapi.entities.SearchRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDocumentsManager {

    Documents create(DocumentsDto documentsDto);

    Optional<Documents> findById(UUID id);

    List<Documents> search(SearchRequest request);

}
