package com.agsr.monitor_sensors.service.security;

import com.agsr.monitor_sensors.domain.exception.ResourceDoesNotExistException;
import com.agsr.monitor_sensors.domain.security.User;
import com.agsr.monitor_sensors.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws ResourceDoesNotExistException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceDoesNotExistException(
                        "User not found with email: " + email)
                );
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.getAuthorities()
        );
    }

}
