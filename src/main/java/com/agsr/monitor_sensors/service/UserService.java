package com.agsr.monitor_sensors.service;

import com.agsr.monitor_sensors.domain.security.User;

public interface UserService {

    User create(User user);

    User findByEmail(String email);

}
