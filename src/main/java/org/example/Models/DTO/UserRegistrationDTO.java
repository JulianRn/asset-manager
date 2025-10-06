package org.example.Models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDTO(
        @NotBlank(message = "Please provide your firstname")
        String firstName,
        @NotBlank(message = "Please provide your lastname")
        String lastName,
        @NotBlank(message = "Email is mandatory")
        @Email(message = "Please provide a valid email address")
        String username,
        @NotBlank(message = "Password is mandatory")
        String password
) {
}
