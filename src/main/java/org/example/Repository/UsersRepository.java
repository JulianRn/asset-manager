package org.example.Repository;

import org.example.Models.DataModels.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
