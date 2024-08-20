package org.example.documentapi.service;

import lombok.AllArgsConstructor;
import org.example.documentapi.dtos.AuthorsDto;
import org.example.documentapi.entities.Authors;
import org.example.documentapi.interfaces.IAuthorService;
import org.example.documentapi.mappers.AuthorMapper;
import org.example.documentapi.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorService implements IAuthorService {

    private AuthorMapper authorMapper;
    private AuthorRepository authorRepository;

    @Override
    public Authors create(AuthorsDto authorsDto) {
        System.out.println("dto: " + authorsDto.getName());
        Authors author = authorMapper.toEntity(authorsDto);
        System.out.println("author: " + author.getName());
        return authorRepository.save(author);
    }

    @Override
    public List<Authors> find() {
       return (List<Authors>) authorRepository.findAll();
    }

    @Override
    public Optional<Authors> findById(UUID id) {
        return authorRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Authors update(UUID id, AuthorsDto authorsDto) {
        Authors existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        existingAuthor.setName(authorsDto.getName());

        return authorRepository.save(existingAuthor);
    }
}
