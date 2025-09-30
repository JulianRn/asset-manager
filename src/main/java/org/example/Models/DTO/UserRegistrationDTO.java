package org.example.Models.DTO;

public record UserRegistrationDTO(
        String firstName,
        String lastName,
        String username,
        String password
) {
}
