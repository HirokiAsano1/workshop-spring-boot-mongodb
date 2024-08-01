package com.example.workshopmongo.Controller;

import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> findall()
        {
            List<User> list = userService.findAll();
            return ResponseEntity.ok().body(list); // o ok instancia atraves do metodo http de teve sucesso e no corpo tera a lista  de usuruaios

        }
}
