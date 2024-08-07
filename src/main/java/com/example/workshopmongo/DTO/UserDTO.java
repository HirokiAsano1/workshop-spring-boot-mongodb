package com.example.workshopmongo.DTO;


import com.example.workshopmongo.Entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO { //DTO É USADO PARA CUSTOMIZAR O TRAFEGO DOS DADOS , POR EX SE EU PRECISAR APENAS MOSTRAR OS NOMES DOS USUARIOS SEM MOSTRAR O ID E DOS EMAIL

    private String id;
    private String name;
    private String email;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
