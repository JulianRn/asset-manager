package org.example.dbTests;

import org.example.Models.DataModels.User;
import org.example.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.mongodb.assertions.Assertions.assertNotNull;


@DataMongoTest
public class TestUserRepository {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void findByUsername() {
        User user = new User(
                "Test",
                "Tester",
                "tester@test.de",
                "123"
        );

        usersRepository.save(user);

        User found = usersRepository.findByUsername("tester@test.de");

        assertNotNull(found);
        assertEquals("tester@test.de", found.getUsername());
        System.out.println("Testergebniss: " + found.getUsername());
    }
}
