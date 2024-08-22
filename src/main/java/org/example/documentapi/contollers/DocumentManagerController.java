package org.example.documentapi.contollers;

import lombok.AllArgsConstructor;
import org.example.documentapi.dtos.DocumentsDto;
import org.example.documentapi.entities.Documents;
import org.example.documentapi.entities.SearchRequest;
import org.example.documentapi.interfaces.IDocumentsManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("documents")
@AllArgsConstructor
public class DocumentManagerController {
    private IDocumentsManager documentsManager;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody DocumentsDto documentsDto){
        Documents document = documentsManager.create(documentsDto);

        return new ResponseEntity<>(Map.of("message", "Document is created!", "data", document), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id){
        Optional<Documents> documents = documentsManager.findById(id);

       return new ResponseEntity<>(Map.of("data", documents), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Object> search(@RequestBody SearchRequest searchRequest){
        List<Documents> documentsList = documentsManager.search(searchRequest);

        return new ResponseEntity<>(Map.of("data", documentsList), HttpStatus.OK);
    }
}
