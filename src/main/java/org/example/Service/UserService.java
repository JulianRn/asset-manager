package org.example.Service;

import com.sun.jdi.request.DuplicateRequestException;
import org.example.Models.DTO.UserDTO;
import org.example.Models.DTO.UserRegestrationDTO;
import org.example.Models.DataModels.User;
import org.example.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

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

    public void createNewUser (UserRegestrationDTO userRegestrationDTO) {
        // TODO: Create validation to check if email already exists
        String userEmail = userRegestrationDTO.email();
        if(usersRepository.existByEmail(userEmail)) {
            throw new RuntimeException(
                    "This email is already in usage."
            );
        }

        User user = new User(
                userRegestrationDTO.firstName(),
                userRegestrationDTO.lastName(),
                userRegestrationDTO.email(),
                passwordEncoder.encode(userRegestrationDTO.hashedPassword())
        );
        usersRepository.save(user);
    }
}
