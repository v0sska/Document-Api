package org.example.documentapi.interfaces;

import org.example.documentapi.dtos.AuthorsDto;
import org.example.documentapi.entities.Authors;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAuthorService {

    Authors create(AuthorsDto authorsDto);

    List<Authors> find();

    Optional<Authors> findById(UUID id);

    void delete(UUID id);

    Authors update(UUID id, AuthorsDto authorsDto);

}
