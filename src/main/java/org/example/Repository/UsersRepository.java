package org.example.Repository;

import org.example.Models.DataModels.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UsersRepository extends MongoRepository<User, String> {

    @Query("{email:'?0'}")
    boolean existByEmail(String email);
}
