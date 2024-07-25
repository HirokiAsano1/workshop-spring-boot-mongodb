package com.example.workshopmongo.Controller;

import com.example.workshopmongo.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity <List<User>> findall()
        {
            User maria = new User("1" ,"Maria Brown","maria@gmail.com");
            User alex = new User("2","Alex","alex@gmail.com");
            List<User> list = new ArrayList<>();
            list.addAll(Arrays.asList(maria,alex));
            return ResponseEntity.ok().body(list); // o ok instancia atraves do metodo http de teve sucesso e no corpo tera a lista  de usuruaios

        }
}
