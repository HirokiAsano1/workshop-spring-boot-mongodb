package com.example.workshopmongo.Controller;

import com.example.workshopmongo.DTO.UserDTO;
import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> Save (@RequestBody UserDTO objDto)
    {
        User obj = userService.fromDto(objDto);
        obj = userService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // linha responsavel por retorna um cabeçario contendo o caminho do obj criado
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody UserDTO objDto,@PathVariable String id)
    {
        User obj = userService.fromDto(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build(); //cod204
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> Delete(@PathVariable String id)
    {
     userService.delete(id);

     return ResponseEntity.noContent().build(); //cod204

    }


}
