package com.example.workshopmongo.Services;

import com.example.workshopmongo.Entities.Post;
import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Excpetions.ObjectNotFoundException;
import com.example.workshopmongo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id)
    {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
