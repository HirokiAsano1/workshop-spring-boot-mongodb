package com.example.workshopmongo.Entities;

import com.example.workshopmongo.DTO.AuthorDTO;
import com.example.workshopmongo.DTO.CommentDTO;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
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

    private List<CommentDTO> comments = new ArrayList<>();

    public Post (String id , Date date, String title,String body, AuthorDTO author)
    {
        this.id =id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
