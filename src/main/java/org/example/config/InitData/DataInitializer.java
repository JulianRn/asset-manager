package org.example.config.InitData;

import org.example.Models.DataModels.User;
import org.example.Repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        if (userRepository.count() == 0) {
            System.out.println("Creating demo user...");
            User user = new User(
                    "demo",
                    "user",
                    "demo@user.de",
                     passwordEncoder.encode("1234")
            );
            userRepository.save(user);
            System.out.println("Demo user created");
        }
        System.out.println("Demo user already exists - skipping");
    }
}
