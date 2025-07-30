package org.example.Models.DTO;

import org.example.Models.DataModels.Investment;

import java.util.ArrayList;

public record UserDTO (
        String id,
        String lastName,
        String firstName,
        String email,
        ArrayList<Investment> userInvestments
){}
