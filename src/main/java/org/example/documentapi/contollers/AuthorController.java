package org.example.documentapi.contollers;

import lombok.AllArgsConstructor;
import org.example.documentapi.dtos.AuthorsDto;
import org.example.documentapi.entities.Authors;
import org.example.documentapi.interfaces.IAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("authors")
@AllArgsConstructor
public class AuthorController {
    private IAuthorService authorService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody AuthorsDto authors) {
        Authors authorToSave = authorService.create(authors);

        return new ResponseEntity<>(Map.of("message", "Author is added!", "data", authorToSave), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> find() {
        List<Authors> authors = authorService.find();

        return new ResponseEntity<>(Map.of("data", authors), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        Optional<Authors> author = authorService.findById(id);

        return new ResponseEntity<>(Map.of("data", author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        authorService.delete(id);

        return new ResponseEntity<>(Map.of("message", "Author is deleted!"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody AuthorsDto authors) {
        Authors author = authorService.update(id, authors);

        return new ResponseEntity<>(Map.of("message", "Author is updated!", "data", author), HttpStatus.OK);
    }
}
