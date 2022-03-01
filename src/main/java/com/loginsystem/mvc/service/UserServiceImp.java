package com.loginsystem.mvc.service;

import com.loginsystem.mvc.UserRepository;
import com.loginsystem.mvc.entity.UserEntity;
import com.loginsystem.mvc.share.Utils;
import com.loginsystem.mvc.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Duplicate user: User already exist in the database");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        //creating public user id
        String publicUserId = utils.generateUserId(20);

        // params
        userEntity.setUserId(publicUserId);
        userEntity.setEncryptedPassword("testing");


        UserEntity savedUserDetails = userRepository.save(userEntity);

        UserDto restValue = new UserDto();
        BeanUtils.copyProperties(savedUserDetails, restValue);

        return restValue;
    }
}
