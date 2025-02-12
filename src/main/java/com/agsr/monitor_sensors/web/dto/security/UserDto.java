package com.agsr.monitor_sensors.web.dto.security;

import com.agsr.monitor_sensors.domain.security.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    @Size(min = 3, max = 30, message = "Email should be between 3 and 30 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 30, message = "Password should be between 3 and 30 characters")
    private String password;

    private User.Role role;

}
