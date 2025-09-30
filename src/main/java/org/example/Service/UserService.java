package org.example.Service;

import com.sun.jdi.request.DuplicateRequestException;
import org.example.Models.DTO.UserRegistrationDTO;
import org.example.Models.DataModels.User;
import org.example.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User getUserById(String id) {
        return usersRepository.findById(id).orElseThrow(() -> new ResourceAccessException(
                    "Custommer with id [%s] not found".formatted(id)));
    }

    public void registerUser (UserRegistrationDTO userRegistrationDTO) {
        User existingUser = usersRepository.findByUsername(userRegistrationDTO.username());
        if (Objects.equals(existingUser.getUsername(), userRegistrationDTO.username())) {
            throw new DuplicateRequestException("The given username is already in use");
        }

        User user = new User(
                userRegistrationDTO.firstName(),
                userRegistrationDTO.lastName(),
                userRegistrationDTO.username(),
                passwordEncoder.encode(userRegistrationDTO.password())
        );
        usersRepository.save(user);
    }
}
