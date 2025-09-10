package org.example.Repository;

import org.example.Models.DataModels.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<User, String> {

    @Query("{username:'?0'}")
    boolean existByUsername(String username);

    User findByUsername(String email);
}
