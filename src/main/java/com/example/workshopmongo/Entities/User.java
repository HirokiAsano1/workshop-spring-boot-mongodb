package com.example.workshopmongo.Entities;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

@Document(collection="user") //substitui o @Entity do mysQL
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;


    @DBRef (lazy = true) // esse lazy faz com que os post referenciados do usuario só seja carregado se eu acessa-los , caso contrario irar mostrar so os user
    private List<Post> posts = new ArrayList<>();

    public User(String id , String name , String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
