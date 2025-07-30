package org.example.Controller;

import org.example.config.DTOMapper.UserMapper;
import org.example.Models.DTO.UserDTO;
import org.example.Models.DTO.UserRegestrationDTO;
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
                userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<?> registrateUser(@RequestBody UserRegestrationDTO userRegestrationDTO) {
        userService.createNewUser(userRegestrationDTO);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.CREATED);
    }
}
