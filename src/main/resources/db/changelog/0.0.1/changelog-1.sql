--liquibase formatted sql

--changeset mqqqmi:1
--comment first migration

CREATE TABLE authors (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255)
);

CREATE TABLE documents (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255),
    content TEXT,
    author_id UUID,
    created TIMESTAMP,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);