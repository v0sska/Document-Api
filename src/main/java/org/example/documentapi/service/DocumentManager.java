package org.example.documentapi.service;

import lombok.AllArgsConstructor;
import org.example.documentapi.dtos.DocumentsDto;
import org.example.documentapi.entities.Authors;
import org.example.documentapi.entities.Documents;
import org.example.documentapi.entities.SearchRequest;
import org.example.documentapi.interfaces.IDocumentsManager;
import org.example.documentapi.repositories.DocumentsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DocumentManager implements IDocumentsManager {

    private DocumentsRepository documentRepository;
    private AuthorService authorService;

    @Override
    public Documents create(DocumentsDto documentsDto) {

        Optional<Authors> author = authorService.findById(documentsDto.getAuthorId());
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author not found");
        }

        Documents documentToSave = toEntity(documentsDto);
        documentToSave.setAuthor(author.get());
        documentToSave.setCreated(Instant.now());

        return documentRepository.save(documentToSave);
    }

    @Override
    public Optional<Documents> findById(UUID id) {
        return documentRepository.findById(id);
    }

    @Override
    public List<Documents> search(SearchRequest request) {
        return documentRepository.findAll().stream()
                .filter(document -> matchesRequest(document, request))
                .collect(Collectors.toList());
    }

    private boolean matchesRequest(Documents document, SearchRequest request) {
        return (request.getTitlePrefixes() == null || request.getTitlePrefixes().stream().anyMatch(prefix -> document.getTitle().startsWith(prefix))) &&
                (request.getContainsContents() == null || request.getContainsContents().stream().anyMatch(content -> document.getContent().contains(content))) &&
                (request.getAuthorIds() == null || request.getAuthorIds().contains(document.getAuthor().getId().toString())) &&
                (request.getCreatedFrom() == null || !document.getCreated().isBefore(request.getCreatedFrom())) &&
                (request.getCreatedTo() == null || !document.getCreated().isAfter(request.getCreatedTo()));
    }

    private Documents toEntity(DocumentsDto documentsDto) {
        Documents documents = new Documents();
        documents.setTitle(documentsDto.getTitle());
        documents.setContent(documentsDto.getContent());
        return documents;
    }

}
