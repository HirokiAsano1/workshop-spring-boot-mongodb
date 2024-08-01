package com.example.workshopmongo.Services;

import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //INTANCIAR AUTOMATICAMENTE
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
