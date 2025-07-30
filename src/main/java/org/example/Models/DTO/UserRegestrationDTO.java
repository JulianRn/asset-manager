package org.example.Models.DTO;

public record UserRegestrationDTO(
        String firstName,
        String lastName,
        String email,
        String hashedPassword
) {
}
