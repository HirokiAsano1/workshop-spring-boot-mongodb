package com.example.workshopmongo.DTO;

import com.example.workshopmongo.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO {
    private String Id;
    private String name;

    public AuthorDTO(User obj){
        this.Id = obj.getId();
        this.name = obj.getName();

    }
}
