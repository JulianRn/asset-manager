package org.example.Service;

import org.example.Models.DataModels.User;
import org.example.Models.DataModels.UserPrincipal;
import org.example.Repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyUserDetailServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private MyUserDetailService myUserDetailService;

    @Test
    void loadUserByUsername() {
        User user = new User(
                "Test",
                "Tester",
                "test@test.de",
                "123abc"
        );
        UserDetails userPrincipal = new UserPrincipal(user);
        when(usersRepository.findByUsername("test@test.de")).thenReturn(user);

        UserDetails result = myUserDetailService.loadUserByUsername("test@test.de");

        assertNotNull(result);
        assertEquals(userPrincipal.getUsername(), result.getUsername());
    }

    @Test
    void loadUserByUsername_notFound_shouldThrowException() {
        when(usersRepository.findByUsername("notFound@test.de")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
           myUserDetailService.loadUserByUsername("notFound@test.de");
        });
    }
}