package com.example.workshopmongo.Repository;

import com.example.workshopmongo.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

}
