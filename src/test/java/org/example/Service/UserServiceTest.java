package org.example.Service;

import org.example.Exception.ResourceBadRequestException;
import org.example.Models.DTO.UserRegistrationDTO;
import org.example.Models.DataModels.User;
import org.example.Repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void getAllUsers_shouldReturnAllUsers() {
        List<User> users = List.of(
            new User(
              "test",
              "tester",
              "test@test.de",
              "123"
            ),
            new User(
                "test2",
                "tester2",
                "tes2t@test.de",
                "123"
            )
        );
        when(usersRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    void getUserById_shouldReturnOneUser() {
        User user = new User(
                "user",
                "tester",
                "user@tester.de",
                "123"
        );
        when(usersRepository.findById("1")).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById("1");
        assert(result.isPresent());
        assertEquals(user.getUsername(), result.get().getUsername());
    }

    @Test
    void getUserById_shouldNotReturnUser() {
        when(usersRepository.findById("99")).thenReturn(Optional.empty());
        Optional<User> result = userService.getUserById("99");
        assertFalse(result.isPresent());
        assertTrue(result.isEmpty());
    }

    @Test
    void registerUser() {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO(
                "userDto",
                "test",
                "UserDTO",
                "123"
        );
        when(usersRepository.findByUsername(userRegistrationDTO.username())).thenReturn(null);
        when(passwordEncoder.encode("123")).thenReturn("encodedPassword");
        userService.registerUser(userRegistrationDTO);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(usersRepository, times(1)).save(userCaptor.capture());

        User savedUser = userCaptor.getValue();
        assertEquals("userDto", savedUser.getFirstName());
        assertEquals("test", savedUser.getLastName());
        assertEquals("UserDTO", savedUser.getUsername());
        assertEquals("encodedPassword", savedUser.getPassword());
    }

    @Test
    void registerUser_shouldThrowException() {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO(
                "userDto",
                "test",
                "UserDTO",
                "123"
        );
        User user  = new User(
                "userDto",
                "test",
                "UserDTO",
                "123"
        );
        when(usersRepository.findByUsername(userRegistrationDTO.username())).thenReturn(user);
        assertThrows(ResourceBadRequestException.class, () -> {
            userService.registerUser(userRegistrationDTO);
        });
    }
}