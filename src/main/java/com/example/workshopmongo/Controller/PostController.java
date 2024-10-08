package com.example.workshopmongo.Controller;

import com.example.workshopmongo.Entities.Post;
import com.example.workshopmongo.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post>findById(@PathVariable String id)
    {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
