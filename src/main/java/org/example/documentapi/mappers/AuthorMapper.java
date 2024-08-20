package org.example.documentapi.mappers;

import org.example.documentapi.dtos.AuthorsDto;
import org.example.documentapi.entities.Authors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(source = "name", target = "name")
    Authors toEntity(AuthorsDto authorsDto);

    AuthorsDto toDto(Authors authors);
}

