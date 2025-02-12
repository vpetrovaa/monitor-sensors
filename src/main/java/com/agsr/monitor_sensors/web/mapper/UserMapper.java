package com.agsr.monitor_sensors.web.mapper;

import com.agsr.monitor_sensors.domain.security.User;
import com.agsr.monitor_sensors.web.dto.security.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

}
