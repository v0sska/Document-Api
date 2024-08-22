package org.example.documentapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documents {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull
    private Authors author;

    private Instant created;

    public Documents(String title, Authors author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
