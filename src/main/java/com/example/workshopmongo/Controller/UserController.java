package com.example.workshopmongo.Controller;

import com.example.workshopmongo.DTO.UserDTO;
import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<UserDTO>> findall()
        {
            List<User> list = userService.findAll();
            List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//Converter todos os usuarios da lista para UserDto
            return ResponseEntity.ok().body(listDTO); // o ok instancia atraves do metodo http de teve sucesso e no corpo tera a lista  de usuruaios

        }
    @GetMapping("/{id}")
    public ResponseEntity <UserDTO> findById(@PathVariable String id) //essa anotação é para passar o requisito por URL
    {
        User obj = userService.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj)); // converter para userDTO

    }
}
