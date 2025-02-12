package com.agsr.monitor_sensors.service.impl;

import com.agsr.monitor_sensors.domain.exception.ResourceAlreadyExistsException;
import com.agsr.monitor_sensors.domain.exception.ResourceDoesNotExistException;
import com.agsr.monitor_sensors.domain.security.User;
import com.agsr.monitor_sensors.repository.UserRepository;
import com.agsr.monitor_sensors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResourceAlreadyExistsException("User with email " +
                    user.getEmail() + " already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceDoesNotExistException(
                        "User with email " + email + " does not exist"
                ));
    }

}
