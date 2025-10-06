package org.example.Models.DTO;

import jakarta.validation.constraints.NotBlank;
import org.example.Models.DataModels.Investment;

import java.util.ArrayList;

public record UserDTO (
        String id,
        String lastName,
        String firstName,
        String username,
        ArrayList<Investment> userInvestments
){}
