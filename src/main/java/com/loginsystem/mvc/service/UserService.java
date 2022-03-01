package com.loginsystem.mvc.service;

import com.loginsystem.mvc.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
