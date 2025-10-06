package org.example.Controller;

import jakarta.validation.Valid;
import org.example.Exception.ResourceNotFoundException;
import org.example.config.DTOMapper.UserMapper;
import org.example.Models.DTO.UserDTO;
import org.example.Models.DTO.UserRegistrationDTO;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(user -> userMapper.toUserDTO(user))
                .toList();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable String id) {
        return userMapper.toUserDTO(
                userService.getUserById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("User not found for this id : " + id)
                        )
        );
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.registerUser(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
