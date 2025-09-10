package org.example.config.DTOMapper;

import org.example.Models.DTO.UserDTO;
import org.example.Models.DataModels.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getLastName(),
                user.getFirstName(),
                user.getUsername(),
                user.getUserInvestments()
        );
    }
}
