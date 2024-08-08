package com.example.workshopmongo.Services;

import com.example.workshopmongo.DTO.UserDTO;
import com.example.workshopmongo.Entities.User;
import com.example.workshopmongo.Excpetions.ObjectNotFoundException;
import com.example.workshopmongo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //INTANCIAR AUTOMATICAMENTE
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update (User obj)
    {
        User newobj = userRepository.findById(obj.getId()).get();
        updateData(newobj,obj);
        return userRepository.save(newobj);
    }

    private void updateData(User newobj, User obj) {
        newobj.setName(obj.getName());
        newobj.setEmail(obj.getEmail());
    }

    public void delete (String id)
    {
        findById(id); //reutilizei o metodo de exceçao acima para o lançar execeçao no medodo delete tbm
        userRepository.deleteById(id);
    }


    public User fromDto(UserDTO obj)
    {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
