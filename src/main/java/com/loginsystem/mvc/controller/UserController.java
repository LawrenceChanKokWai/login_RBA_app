package com.loginsystem.mvc.controller;

import com.loginsystem.mvc.model.UserDetailsRequestModel;
import com.loginsystem.mvc.model.UserRestModel;
import com.loginsystem.mvc.service.UserService;
import com.loginsystem.mvc.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "getUser is called";
    }

    @PostMapping
    public UserRestModel createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRestModel restValue = new UserRestModel();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, restValue);

        return restValue;
    }

    @PutMapping
    public String updateUser(){
        return "updateUser is called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleteUser is called";
    }
}
