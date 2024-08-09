package com.example.workshopmongo.Entities;

import com.example.workshopmongo.DTO.AuthorDTO;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Document(collection = "post")
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;
}
