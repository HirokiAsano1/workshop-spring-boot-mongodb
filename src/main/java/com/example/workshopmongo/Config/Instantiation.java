package com.example.workshopmongo.Config;

import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

   @Autowired
   private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User maria = new User(null, "maria", "maria@gmail.com");
        User Pedro = new User(null, "Pedro", "pedro@gmail.com");
        User Thiago = new User(null, "Thiago", "thiago@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, Pedro, Thiago));
    }
    //essa classe foi montada no intuito de toda vez que a aplicação seja instanciada ira apagar os registros do banco de dados e add esses 3
}
