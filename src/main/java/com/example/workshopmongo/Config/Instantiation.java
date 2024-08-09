package com.example.workshopmongo.Config;

import com.example.workshopmongo.DTO.AuthorDTO;
import com.example.workshopmongo.Entities.Post;
import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Repository.PostRepository;
import com.example.workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        User maria = new User(null, "maria", "maria@gmail.com");
        User Pedro = new User(null, "Pedro", "pedro@gmail.com");
        User Thiago = new User(null, "Thiago", "thiago@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, Pedro, Thiago));

        postRepository.deleteAll();
        Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem", "Vou viajar para São Paulo.Abraços",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("15/03/2024"), "Bom dia!", "Acabei de acordar para trablhar",new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
    //essa classe foi montada no intuito de toda vez que a aplicação seja instanciada ira apagar os registros do banco de dados e add esses 3
}
